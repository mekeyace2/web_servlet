package exam;

import java.util.ArrayList;
import java.util.Arrays;

public class ex8 extends ex8_box{
	
	@Override
	public void even() {	//짝수
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w < number.size()) {
			if(number.get(w) % 2 == 1) {	//홀수값 조건은 배열에 삭제
				number.remove(w);	//remove시 배열의 index 즉 node 번호가 변경됨
				w = 0;		//0사용은 배열에 값이 삭제 되면 노드변화로 처음부터 다시 검토 하도록함
			}
			else {
				w++;	//해당 조건(홀수)가 아니면 +1 증가시켜서 배열 검토하는 형태
			}
		}
		System.out.println(number);
	}
	@Override
	public void odd() {
				
	}
	public static void main(String[] args) {
		new ex8().even();
		new ex8().odd();
	}
}
//추상 클래스
abstract class ex8_box{
	Integer data[] = {3,5,2,1,6,7,8,9,10,4};
	abstract public void even();
	abstract public void odd();
}