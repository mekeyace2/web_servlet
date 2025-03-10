package notice;
//Database에 Table 사항 중 where 및 조회수 증가
//Query : select, update
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.m_dbinfo;

public class m_noticeview {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "";	//Query문법
	m_dbinfo db = new m_dbinfo();	//Database 정보
	
	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			//해당 컬럼에 값을 +1씩 증가시키는 Query문
			this.sql = "update notice set nview=nview+1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);	//setInt : nidx 자료형이 int 이므로
			this.ps.executeUpdate();	//Query문을 실행!!
		}catch (Exception e) {
			
		}finally {
			try {
				this.ps.close();
				this.con.close();
			}catch (Exception e) {
				
			}
		}	
	}
	
}
