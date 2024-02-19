import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc= 1;tc<=T;tc++) {
			N = sc.nextInt();
			arr = new int[N];
			String first = sc.next();
			String second = sc.next();
			// 일단 입력 받고 계산
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(first.substring(i,i+1));
			}
			// 입력 끝
			
			// 1. 맨처음과 맨뒤항 먼저 확인하고 -1해줌
			// 2. 1 ~ N-1까지 1이상인값대상으로 확인시작 
			int ans =0;
			// 일단 맨처음과 맨뒤먼저 확인해주자
			if(arr[0] !=0 && arr[1] !=0) {
				// 두항이 모두 1이상이면 일단 둘다 -1해주고  
				// ans++
				arr[0]--;
				arr[1]--;
				ans++;
			}
			if(arr[N-1] !=0 & arr[N-2] !=0) {
				arr[N-1]--;
				arr[N-2]--;
				ans++;
			}
			
			// 이제 1번째항부터 N-1까지 확인 ----> 첨에 2부터해야겠다고 생각했지만 
			//								생각해보니 1번항 밑에가 지뢰일수도있어서 1부터
			// 앞뒤 지금자리가 1이상이면 -1씩
			for(int i=1;i<N;i++) {
				if(arr[i-1] >=1 && arr[i] >=1 && arr[i+1] >=1) {
					arr[i-1] --;
					arr[i] --;
					arr[i+1] --;
					ans++;
				}
			}
			// 이러면 다 0이 될거같음
			// 두번째항 고려안해도 될거같기도..?
			System.out.println(ans);
			
		}
		
		

	}

}
