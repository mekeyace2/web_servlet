package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

//copyright Model + Login Model
public class copyright {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	ArrayList<String> cp = null;
	m_dbinfo db = new m_dbinfo();
	String result = null;
	m_member mmb = new m_member();	//DTO 선언
	
	//login
	public String user_login(m_member dto) {
		try {
			this.con = this.db.getConnection();
			this.sql = "select mid,mname,memail from joins where mid=? and mpass=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, dto.getMid());
			this.ps.setString(2, dto.getMpass());
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == true) {	//정상적으로 아이디 및 패스워드가 맞을 경우
				this.result = "ok";
				//기존에 사용된 DTO를 초기화 및 새로운 DTO값을 구성	
				mmb.setMid(this.rs.getString("mid"));	//아이디
				mmb.setMname(this.rs.getString("mname")); //가입자명
				mmb.setMemail(this.rs.getString("memail")); //이메일
			}
			
		}catch(Exception e) {
			this.result = null;
		}finally {
			try {
			    this.rs.close();
			    this.ps.close();
				this.con.close();
			}catch (Exception e) {
				
			}
		}
		return this.result;
	}
	
	
	
	//copyright
	public ArrayList<String> copyright_info() {
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from corp_info";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			this.rs.next();
			this.cp = new ArrayList<String>();
			this.cp.add(this.rs.getString("corp_nm"));
			this.cp.add(this.rs.getString("ceo_nm"));
			this.cp.add(this.rs.getString("corp_addr"));
			this.cp.add(this.rs.getString("corp_tel"));
			this.cp.add(this.rs.getString("corp_time"));
			this.cp.add(this.rs.getString("ceo_email"));
			this.cp.add(this.rs.getString("corp_no"));
			this.cp.add(this.rs.getString("corp_no2"));
			this.cp.add(this.rs.getString("corp_master"));
			this.cp.add(this.rs.getString("corp_domain"));
			//System.out.println(this.cp);
		}catch(Exception e) {
			System.out.println("Database Error!!");
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				System.out.println("Database Error!!");
			}
		}
		return this.cp;
	}
	
}




