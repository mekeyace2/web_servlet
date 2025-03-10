package shop;

import java.security.MessageDigest;

//패스워드 MD5 암호화 생성
public class m_md5 {

	public String md5_code(String pw) throws Exception {
		StringBuilder sb = new StringBuilder();
		String md5_data = "";	//사용자가 입력한 값을 md5로 암호화 변수
		
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(pw.getBytes());
		byte md5byte[] = md.digest();
		
		//암호화 알고리즘
		for(byte alg : md5byte) {
			sb.append(String.format("%01x", alg));
		}
		md5_data = String.valueOf(sb);		
		
		return md5_data;
	}
	
}
