package exam;

import java.util.Scanner;

public class ex10 extends ex10_box {
	public static void main(String[] args) {
		System.out.println("[1.휴대폰 인증, 2.이메일 인증] 선택 : ");
		new ex10().sec();
	}
	public void sec() {
		String part = this.sc.next();
		String result = null;
		if(part.equals("1")) {
			System.out.println("휴대폰 번호를 입력하세요(숫자만) : ");
			try {
				Integer hpno = this.sc.nextInt();
				result = this.hp(hpno);
				
			}catch(Exception e){
				System.out.println("숫자만 입력하셔야 합니다. 재실행 합니다.");
				new ex10().main(null);
			}
		}
		else if(part.equals("2")) {
			System.out.println("이메일을 입력하세요 : ");
			String useremail = this.sc.next();
			result = this.email(useremail);	
		}
		else {
			new ex10().main(null);
		}
		System.out.println(result);
	}
}

abstract class ex10_box{
	Scanner sc = new Scanner(System.in);
	public String hp(Integer hpno) {	//휴대폰 인증
		String msg = "인증번호 5523 발송";
		return msg;
	}
	public String email(String useremail) {	//이메일 인증
		String msg = "인증번호 5523 발송";
		return msg;
	}
	
}
