import java.util.Scanner;

public class Main {
	static long N;
	static long M;
	static long[] arr;
	static long ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1 -> 1 , 2 -> 10 , 3 -> 11 , 4 -> 100 , 5-> 101,
		// 6 -> 110 , 7 -> 111 , 8-> 1000
		// 2의 제곱에서 7은 일단 4 + 2 + 1

		// 최대의 수에서 2의 n승을 뺄때마다 +1 , 2까지했을때 1이면 +1 아니면 0

		// 4 ~ 7 1+ 2+ 2 + 3 ||  2~3 = 1 + 1 
		// 8 ~15 1+ 2 + 2+ 3 + 2 + 3 + 3 + 4
		// 아마 16에서 31까지도 8~15를 2곱한 후 + 8일거임
		// 누적합으로 ?
		N = sc.nextLong()-1;
		M = sc.nextLong();
		//		arr = new long[101];
		//		arr[1] = 1; // 1까지 1
		//		arr[2] = 4;  // 3까지 1 + 3
		//		arr[3] = 12; // 7까지 1 + 3 + 8
		//		arr[4] = 32; // 15까지 1 + 3 + 8 + 20
		// 전항 x2  + 2의 (index-1)승을 +한것
		//		for(int i = 5 ;i<100 ;i++) {
		//			arr[i] = (long) (arr[i-1]*2 + (long) Math.pow(2, i-1)-1);
		//		}
		// 8은 8  		13
		//(15) 9는 8  + 1	13 + 1 -> 13 + +1
		//(17) 10은 8 +2		13 + 2 -> 13 + (2의 2제곱 +4)
		//(20) 11은 8 + 2 +1 13 + 
		//(22) 12의 경우는 8 + 4 -> 13 + 5(+4)
		ans = solve(M) - solve(N);
		System.out.println(ans);
	}
	public static long solve(long num) {
		if(num ==0 || num == 1) {
			return num;
		}	
		// 일단 최대한 2를 계속 곱해서 num에 맞춤
		long pownum = 1;
		int cnt = 0;
		while(true) {
			if(pownum > num) {
				pownum /= 2;	
				cnt--;
				break;
			}
			pownum *=2;
			cnt++;
		}
		// num보다 작은 최대 2의 제곱수 구하기

		// 전항 *2 + 그 남은 숫자들의 개수
		// 다시 0이나 1이 될때까지 재귀
//		System.out.println(pownum+" "+cnt);
//		System.out.println(pownum *(cnt/2)+ (num-pownum+1));
		return cnt *(pownum/2)+ (num-pownum+1)+ solve(num - pownum);

	}


}
