import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int A;
	static int B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt = sc.nextInt();
	
		// n=1이나 2일떄의 개수를 세보자 		
		A=0;
		B=0;
		solve(N);
		// A랑B는 첫째항과 두째항의 계수
		// 3 = 1 1 
		// 4 = 1 2
		// 5 = 2 3
		// 6 = 3 5
		// 우선 6의 경우 b의 값이 최대일때부터 쭉 내려가다가 
		// 3의배수만큼의 값이 남는 지점 파악
		int a= 0;
		int b = 0;
		// 일단 최대 b부터 정해놓고
		// a가 나눠떨어지는지 확인		
		for(int i=cnt/B;i>0;i--) {
			int tmp = cnt-B*i; // cnt에서 두번째항 x i를 한값만큼 뺸것이
			// 계수인 A에 나눠떨어지는지 확인
			if(tmp%A==0) {
				b = i;
				a = tmp/A;
				if(a==0) {
					// 0일때에는 x이므로 다음항 봐야한다.
					continue;
				}
				break;
			}
		}
		
		System.out.println(a);
		System.out.println(b);
		
	}
	
	
	public static void solve(int day) {
		// 1보다 작을때는 끝내고
		// 마지막항이 1이면 A++
		// 마지막항이 2이면 B++
		if(day<1) {
			return;
		}
		if(day==1) {
			A++;
			return;
		}
		if(day==2) {
			B++;
			return;
		}
		// 재귀 시작
		solve(day-1);
		solve(day-2);
		return;
		
	}
		
		
		
		
	


}
