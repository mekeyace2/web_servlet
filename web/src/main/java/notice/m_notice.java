package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import shop.m_dbinfo;

//공지사항 게시판 파일을 저장하는 Model
public class m_notice{
	Connection con = null;
	PreparedStatement ps = null;
	//Model
	m_dbinfo db = new m_dbinfo();	//DB접속정보
	
	String sql = "";	//DB Query문
	int result = 0;		//DB저장 결과값
	
	String msg = "";	//Model에서 처리된 값을 Controller로 결과값을 반환하는 역활 변수	
	
	String subject,writer,pw,texts;
	
	//즉시 실행 메소드에서 첨부파일을 저장하는 역활만 합니다.
	public m_notice(Part nfile,String subject,String writer,String pw,String texts,HttpServletRequest request) throws Exception {
		this.subject = subject;
		this.writer = writer;
		this.pw = pw;
		this.texts = texts;
		//파일 용량
		long filesize = nfile.getSize();
		//파일명
		String filenm = nfile.getSubmittedFileName();
		//첨부파일 저장될 Web Directory 설정
		String url = request.getServletContext().getRealPath("/notice_file/");
		try {
			nfile.write(url + filenm);	//웹에 저장
			this.fileok(filenm);	//정상적으로 저장 되었을 경우
		}catch (Exception e) {
			this.fileok("error");	//비정상적으로 해당 디렉토리에 파일이 저장되지 않을 경우
		}
		
	}
	//DB로 저장 및 Controller로 결과값을 return하는 메소드
	private String fileok(String data) throws Exception {
		if(data.equals("error")) {
			this.msg = "error";
		}
		else {	//파일 정상적으로 저장 되었을 경우
			try {
				this.con = this.db.getConnection();
				this.sql = "insert into notice (nidx,subject,writer,pw,texts,filenm,nfile,ndate)"
						+ "values ('0',?,?,?,?,?,?,now())";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, this.subject);
				this.ps.setString(2, this.writer);
				this.ps.setString(3, this.pw);
				this.ps.setString(4, this.texts);
				this.ps.setString(5, data);
				this.ps.setString(6, data);
				this.result = this.ps.executeUpdate();
				if(this.result > 0) {
					this.msg = "ok";
				}
				
			}catch (Exception e) {
				this.msg = "error";
			}finally {
				this.ps.close();
				this.con.close();
			}
		}
		return this.msg;	//Controller로 보내는 값
	}
	
}
