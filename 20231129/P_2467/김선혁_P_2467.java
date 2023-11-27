import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		
		long[] arr= new long[N]; 
		// N개에서 임의로 2개고르는건데
		// index를 이용해서 구하고
		// 0에 가까워지려면 
		// 두개를 더해서 
		// 절대값을한게 가장 적은값이어야함
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextLong();
		}
		// 입력 끝
		
		// 이제 for문을 통해서 
		// 0번쨰부터 0번째보다 큰 값들을 
		// 하나씩 해보자
		long min =  Long.MAX_VALUE; // 두수의 차이값 (최소로 구해야함)
		int ans1 = 0;
		int ans2 = 0;
		
		
		// 먼저 시작할 항 하나 선택
		// 이항은 맨마지막항 제외라 N-1까지
		for(int i =0;i<N-1;i++) {
			int left = i+1; //  i번째가 나오면안되서 i+1부터
			int right = N-1;
			// 이제 mid 구해서 쭉가보자
			while(true) {
				int mid = (left+right)/2;
				long sum = Math.abs(arr[i] + arr[mid]);
				// 두개의 수를 더해서 
				// 만약 sum이 min 작다면
				// 두개의 수 교체
				if(sum < min) {
					min = sum;
					ans1 = i;
					ans2 = mid;
				}
				
				// 여기서 mid의 수랑 i가 더한게 양수면
				// right 가 이동 , 반대면 left가 이동
				if(arr[mid]+arr[i] >=0) {
					right = mid - 1;
				}
				else {
					left = mid +1;
				}
				
				// right보다 left가 커지면 break
				if(right<left) {
					break;
				}
				
			}
			
		}
		System.out.println(arr[ans1]+" "+arr[ans2]);
		
		
		
	}
		
	
}
