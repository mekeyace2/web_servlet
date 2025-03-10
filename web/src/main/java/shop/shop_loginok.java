package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class shop_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	//select
	HttpSession session = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			response.setContentType("text/html;charset=utf-8");
			String spart = request.getParameter("spart");
			String sid = request.getParameter("sid");
			String spw = request.getParameter("spw");	//사용자가 입력한 사항
			m_dbinfo db = new m_dbinfo();
			this.pw = response.getWriter();
			try {
				this.con = db.getConnection();
				//사용자가 입력한 값을 암호화로 처리해야만 Database와 비교가 가능함
				spw = new m_md5().md5_code(spw);
				String sql = "";	//Database Query문
				//Resultset의 값을 변수 받기위함
				String id = "";		//아이디
				String pw = "";		//패스워드
				String no = "";		//사업자번호
				String nm = "";		//고객명 또는 회사명
				
				if(spart.equals("P")) {	//개인회원
				sql = "select sid,spw,snm from shop_member where sid=?"; 	
				this.ps = this.con.prepareStatement(sql);	
				this.ps.setString(1, sid);
				this.rs = this.ps.executeQuery();
				
				while(this.rs.next()) {
					id = this.rs.getString("sid");
					pw = this.rs.getString("spw");
					nm = this.rs.getString("snm");
				}
				
				if(id.equals("") || nm.equals("")) {	//조회된 내용이 없을 경우
					this.pw.write("<script>"
							+ "alert('해당 아이디를 확인 할 수 없습니다.');"
							+ "history.go(-1);"
							+ "</script>");
				}else {	//조회된 내용이 있을 경우
					if(spw.equals(pw)) {	//사용자가 입력한 패스워드 == DB에 저장된 패스워드
						this.session = request.getSession();	//세션 생성
						this.session.setAttribute("mid", id);	//아이디를 세션 등록
						this.session.setAttribute("mnm", nm);	//고객명을 세션 등록
						this.pw.write("<script>"
								+ "alert('로그인 하셨습니다.');"
								+ "location.href='./main.jsp';"
								+ "</script>");
					}
				}
				}else { //사업자회원
					String sno = request.getParameter("sno");	//사업자 번호
					
					sql = "select sid,spw,snm,sno from shop_member where sid=? and sno=?";
					this.ps = this.con.prepareStatement(sql);
					this.ps.setString(1, sid);
					this.ps.setString(2, sno);
					this.rs = this.ps.executeQuery();
					//처리 방식 
					
					
				}
			}catch(Exception e) {
				
			}finally {
				try {
					this.con.close();
					this.pw.close();
				}catch(Exception e) {
					
				}
			}
			
	}

}
