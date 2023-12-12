import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[M];
		for(int i =0;i<M;i++) {
			arr[i] = sc.nextInt();
		}
		//  입력끝
		
		int ans = 0; 
		
		// 이중으로 탐색해서 먼저
		// 좌측 우측 가장 높은 높이를 구한다음에
		// 그 높이중 적은 높이를 기준으로
		// 중간의 배열이
		// 비가 찬다고 생각
		
		// 먼저 맨끝은 탐색할필요 x 
		for(int i =1;i<M-1;i++) {
			int left = 0;
			int right = 0;
			
			// 이제 이 i번째 배열에서 좌측과 우측의
			// 가장높은 높이 찾기
			for(int j=0;j<i;j++) {
				left = Math.max(left, arr[j]);
			}
			// 오른쪽도 찾기
			for(int j =i+1;j<M;j++) {
				right = Math.max(right, arr[j]);
			}
			// 둘중 낮은거 tmp로 일단 설정
			int tmp = Math.min(right, left);
			// 현재의 높이가 tmp보다 작을때만 +해줌
			if(arr[i] < tmp) {
				ans += tmp - arr[i];
			}
			
		}
		System.out.println(ans);
		
		
	}

}
