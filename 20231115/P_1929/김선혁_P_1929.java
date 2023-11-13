import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[M+1]; // 0부터 m까지 선언
		
		//0,1은 제외하고 2부터  M까지 값 입력해놓음
		for(int i=2;i<=M;i++) {
			arr[i] = 1;
		}
		// 이제 2,3은 소수니깐 4(2+2)부터 쭉 그 수가 지나가는 수는 값을 다 0으로 바꾸자 
		for(int i =2;i<=M;i++) {
			// i는 2부터 쭉가는데 j는 i의 배수들을 모두 0처리할거임
			// 만약 해당수가 어차피 0이면 그 배수는 볼필요 x
			if(arr[i] ==0) {
				continue;
			}
			for(int j =i+i;j<=M;j+=i) {
				if(arr[j]!=0) {
					arr[j] = 0;
				}
			}
		}
		// 배수는 다 0으로 바꾸기 성공
		
		for(int i =N;i<=M;i++) {
			if(arr[i] !=0) {
				System.out.println(i);
			}
		}
		
	}
}
