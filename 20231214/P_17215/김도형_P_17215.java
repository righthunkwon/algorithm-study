package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q17215_볼링점수계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[]arr = str.toCharArray();
		
		int [] pin = new int[26]; //기본 점수 기록할 배열
		int [] spareBonus = new int [26]; //스페어 보너스점수 기록할 배열
		int [] strikeBonus = new int [26]; //스트라이크 보너스점수 기록할 배열
		
		int idx =0;
		//기본 핀 개수 배열에 넣기(단, 스트라이크치면 10, -1을 넣어줌 why? 
		for(int i=0;i<str.length();i++) {
			if(arr[i]=='S') {//스트라이크
				pin[idx++]=10;
				pin[idx++]=-1;
			}else if(arr[i]=='P') {//스페어
				pin[idx]=10-pin[idx-1]; //그전에친거랑 합 10 되게끔..
				idx++;
			}else if(arr[i]=='-') {//거터
				pin[idx++]=0;
			}else {//숫자면
				pin[idx++]=arr[i]-'0';
			}
		}
//		System.out.println(Arrays.toString(pin));

		//스페어 보너스 계산
		for(int i=0;i<24;i++) {
			if(i%2==1 && pin[i]+pin[i-1]==10) { //스페어면
				spareBonus[i]=pin[i+1];
			}
		}
//		System.out.println(Arrays.toString(spairBonus));
		
		//스트라이크 보너스 계산
		for(int i=0;i<24;i++) {
			//i%2==0 -> 거터치고 스페어 처리한거랑 구분하기 위해서
			if(i%2==0 && pin[i]==10 && pin[i+2]!=10) { //스트라이크인데 더블은 아닌 경우
				strikeBonus[i]=pin[i+2]+pin[i+3];
			}else if(i%2==0 && pin[i]==10 && pin[i+2]==10) {//스트라이크인데 뒤에도 스트라이크면..
				strikeBonus[i]=pin[i+2]+pin[i+4];
			}
		}
//		System.out.println(Arrays.toString(strikeBonus));
		
		//총점 계산
		int total=0;
		for(int i=0;i<20;i++) {
			if(pin[i]>=0)total+=pin[i];
			total+=spareBonus[i];
			total+=strikeBonus[i];
		}
		
		System.out.println(total);
		
	}
}
