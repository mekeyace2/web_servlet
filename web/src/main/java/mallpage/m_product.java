package mallpage;
//상품 리스트 Database연결 Model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

public class m_product {
	//DTO (setter,getter)
	dto_product pd = new dto_product();
	
	ArrayList<ArrayList<String>> all = null;
	ArrayList<String> al = null;
	
	//DB정보 및 연결
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;	//DB 쿼리문
	
	//DB접속 정보
	m_dbinfo db = new m_dbinfo();
	
	public ArrayList<ArrayList<String>> product_all(){
		
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from mall_product order by midx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			this.all = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.al = new ArrayList<String>();
				this.al.add(String.valueOf(this.rs.getInt("midx")));
				this.al.add(this.rs.getString("pcode"));
				this.al.add(this.rs.getString("pnm"));
				this.al.add(this.rs.getString("pmoney"));
				this.al.add(this.rs.getString("psales"));
				this.al.add(this.rs.getString("psmoney"));
				this.al.add(this.rs.getString("pimg"));
				this.al.add(this.rs.getString("pdate"));
				this.all.add(this.al);
			}
			
		}catch(Exception e) {
			this.all = null;
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				this.all = null;
			}
		}
	
		return this.all;
	}
	
}
