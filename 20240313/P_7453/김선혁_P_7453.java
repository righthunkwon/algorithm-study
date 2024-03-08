import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long[] A = new long[N];
		long[] B = new long[N];
		long[] C = new long[N];
		long[] D = new long[N];
		// 배열 4개만들어서
		// 다 입력받고 정렬
		for(int i = 0;i<N;i++) {
			A[i] = sc.nextLong();
			B[i] = sc.nextLong();
			C[i] = sc.nextLong();
			D[i] = sc.nextLong();
		}
		// 3개를 기준잡고 일일히 하면서 이분탐색 해야하나

		// 근데 제한시간이 12초인거보면 일일히 하는게 맞을거같음
		// 배열을 2개씩 나눠서 2개의 합을 저장한 후 두개를 비교
		// 이분탐색, 투포인터 두개다 가능하지만
		// B형을 위해 이분탐색을 써보겠습니다 -> 합이 같은것들 처리하기 귀찮아서(12퍼에서 틀림)
		// 그냥 투포인터로 노선변경
		long[] ab = new long[N*N];
		long[] cd = new long[N*N];
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				ab[i*N + j] = A[i] + B[j];
				cd[i*N + j] = C[i] + D[j];
			}
		}
		// 배열 안합치면 4000 x 4000 x 4000 
		// 두개 합치면 (4000 x 4000) + 4000 x 4000 인듯

		// 일단 입력 끝 정렬 
		Arrays.sort(ab);
		Arrays.sort(cd);
		// 두개를 투포인터로 
		long ans = 0;
		int left = 0;
		int right = ab.length-1;
		while(true) {
			// 범위 벗어나면 break
			// left는 ab , right 는 cd index로 
			// 합이 음수면 left++ , 양수면 right--를 진행
			// 두개 중 하나 범위벗어나면 끝
			if(left == N*N || right == -1) {
				break;
			}
			long a = ab[left];
			long b = cd[right];
			long sum = a + b;
			if(sum>0) {
				right --;
			}
			else if(sum ==0) {
				// 합이 0이면 ab와 cd에서 각각 
				// 합이 같은 것들의 개수를 세서 서로 곱해야함
				// left쪽부터 검사
				long tmp1 = 0;
				long tmp2 = 0;
				while(true) {
					// 다음항이랑 비교해서 같으면 +1해주고
					// 아니면 break; 
					// 벙뮈도 검사
					if(left == N*N || ab[left] != a) {
						break;
					}
					tmp1++;
					left++;
				}	
				//똑같이 right도 진행
				while(true) {
					if(right == -1 || cd[right] != b) {
						break;
					}
					tmp2++;
					right --;
				}
				// tmp1과 tmp2 개수의 곱만큽 더함
				ans += tmp1 * tmp2;
			}
			else {
				left++;
			}
		}

		System.out.println(ans);



	}

}
