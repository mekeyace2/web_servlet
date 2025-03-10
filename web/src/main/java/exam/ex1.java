package exam;

import java.util.Random;
import java.util.Scanner;

//Random : 자동으로 PC 생성하는 원리 => 기본 소수점
//Math.random() 
public class ex1 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하세요 : ");
		int no = sc.nextInt();
		for(int f=1; f<=no; f++) {
			int free = rand.nextInt(99);
			System.out.println(free);
		}
		sc.close();
	}

}
