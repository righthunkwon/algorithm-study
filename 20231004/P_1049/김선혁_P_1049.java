import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] arr = new int[K][2];
		for(int i =0;i<K;i++) {
			for(int j=0;j<2;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력
		int a = 987654321;
		int b = 987654321;
		for(int i =0;i<K;i++) {
			if(a > arr[i][0]) {
				a= arr[i][0];
			}
			if(b > arr[i][1]) {
				b = arr[i][1];
			}
		}
		//		System.out.println(a);
		//		System.out.println(b);
		int cnt =0;
		int tmp =0;
		// a는 6개줄의 최소값
		// b는 단일 최소값
		// 만약 a나 b가 0이라면
		// 어차피 결과는 0이 나온다.
		if(a!=0 && b!= 0) {
			tmp = a/b;
			tmp ++;
			// 만약 6개로 구매하는것이
			// 단일로 6개 구매하는 값보다 비싸다면
			// 그냥 a는 b를 6개 구매하는 값으로
			// tmp는 6으로 설정한다.
			if(tmp >6) {
				a = 6 * b;
				tmp = 6;
			}
			// 이제 바꿔야 하는 줄의 개수가 
			// tmp보다 크다면 
			// N을 6줄여주고 세트의 값을 cnt에 더한다.
			// 이 과정을 N이 tmp보다 작아질때까지 반복하고
			// tmp보다 작다면 나머지는 단일로 구매하고 break
			while(true) {
				//			System.out.println(N+" "+tmp);
				if(N>=tmp) {
					N-=6;
					cnt+= a;
					// 6을 빼는 과정 중에 
					// 음수가 된다면 결과가 달라지기 때문에
					// break
					if(N<=0) {
						break;
					}
				}
				else {
					// 단일로 구매
					cnt+= N* b;
					break;
				}			
			}
		}
		System.out.println(cnt);

	}


}
