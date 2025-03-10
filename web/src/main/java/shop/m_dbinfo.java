package shop;
//Database, 사용자 아이디, 사용자 패스워드

import java.sql.Connection;
import java.sql.DriverManager;

//Database의 기본 메소드명 : getConnection
public class m_dbinfo {
	
	public static Connection getConnection() throws Exception{
		//해당 라이브러리를 가져오는 역활 변수
		String db_driver = "com.mysql.cj.jdbc.Driver";
		//Database 경로 연결 : jdbc:mysql://IP 또는 도메인:port번호/Database명
		String db_url = "jdbc:mysql://localhost:3306/mrp";
		//mysql에 접속하는 사용자
		String db_user = "project";
		//mysql에 접속하는 사용자의 패스워드
		String db_passwd = "a123456";
		
		//실제 Database에 연결을 하는 명령어
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_passwd);
		//System.out.println(con);
		return con;	//데이터 베이스가 정상적으로 연결이 되었는지 확인 결과를 return함 
	}
	
}
