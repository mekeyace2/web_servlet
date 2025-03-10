package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.m_dbinfo;
import shop.m_md5;
//첨부파일
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 5, //5MB
	maxFileSize = 1024 * 1024 * 50,	//최대용량 50MB
	maxRequestSize = 1024 * 1024 * 500
)
public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	//Model
	m_dbinfo db = new m_dbinfo();	//DB접속정보
	m_md5 md5 = new m_md5();	//md5 암호화
	
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		//첨부파일 있고, 없고 따라서 SQL 저장방식 변경됨
		Part nfile = request.getPart("nfile");
		long filesize = nfile.getSize();
		
		try {
			this.con = this.db.getConnection();	//DB연결
			String subject = request.getParameter("subject");
			String writer = request.getParameter("writer");
			String pw = request.getParameter("pw");
			String texts = request.getParameter("texts");
			
			//패스워드를 암호화
			pw = this.md5.md5_code(pw);
			
			String sql = "";	//DB Query문
			int result = 0;		//DB에서 저장된 결과를 받는 변수	
			
			if(filesize == 0) {	//첨부파일 없을 경우
				sql = "insert into notice (nidx,subject,writer,pw,texts,ndate)"
						+ "values ('0',?,?,?,?,now())";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, subject);
				this.ps.setString(2, writer);
				this.ps.setString(3, pw);
				this.ps.setString(4, texts);
				result = this.ps.executeUpdate();
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('게시물이 올바르게 등록 되었습니다.');"
							+ "location.href = './notice_list.do';"
							+ "</script>");
				}
			}
			else {	//첨부파일 있을 경우
				//Model을 이용하여 첨부파일 저장하는 방식	
				m_notice nt = new m_notice(nfile,subject,writer,pw,texts,request);
				//return 메소드가 private므로 전역변수의 값을 직접 Controller에 로드함
				String msg = nt.msg;
				
				if(msg.equals("ok")) {
					this.pw.write("<script>"
							+ "alert('올바르게 공지사항이 등록 되었습니다.');"
							+ "location.href = './notice_list.do';"
							+ "</script>");
				}
				else {
					this.pw.write("<script>"
							+ "alert('Database 및 첨부파일 오류 발생!!');"
							+ "history.go(-1);"
							+ "</script>");
				}
			}
		}catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스 문제로 인하여 저장되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}catch(Exception e) {
				
			}
		}
	}

}
