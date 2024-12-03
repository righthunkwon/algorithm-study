package 백준;

import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		// 모두 같은 색이 나오려면
		// 우선 전체돌의 개수에서 나올수 있는 가짓수를 구한후에
		// for문을 통해 하나씩 같은 색의 돌이 k개를 뽑았을 때 같은 경우의 수를 구하면된다.
		int cnt = 0;
		for(int i = 0 ; i < N ;i++) {
			arr[i] = sc.nextInt();
			cnt += arr[i];
		}
		K = sc.nextInt();
		// cnt에서 나올수 있는 총 가짓수
		// C공식 이용
		double sum = 1;
		for(int i = 0;i<K;i++) {
			sum *= (double)(cnt-i);
			sum /= (double)(K-i);
		}
		// 이제 각 확률 계산
//		System.out.println(sum);
		double partSum = 0;
		for(int i = 0; i < N;i++) {
			if(arr[i] >= K) {
				// for문을통해 각 확률 구함
				double tmp = 1;
				for(int j = 0;j<K;j++) {
					tmp *= (double)(arr[i] - j);
					tmp /= (double)(K- j);
				}
//				System.out.println(tmp);
				// 해당 tmp가짓수만큼 partsum에 더해줌
				partSum += tmp;
			}
		}
		
		System.out.println(partSum/sum);
		
	}

}
