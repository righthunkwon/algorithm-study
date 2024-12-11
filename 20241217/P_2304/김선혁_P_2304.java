package 백준;

import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 가장 큰 기둥을 기준으로 
		// 값을 저장해놓고 왼쪽과 오른쪽 맨끝에서 서로 가장큰 기둥이 나올때까지 max값 갱신
		// 가운데와 가운데 사이는 따로 플러스
		int[] arr = new int[1001];
		int maxI = 0;
		int max = 0;
		for(int i = 0 ; i < N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			maxI = Math.max(maxI, a);
			max = Math.max(max, b);
			arr[a] = b;
		}
		// max를 기준으로 양끝에서 시작
		int sum = 0 ;
		int tmp = 0;
		int st = 0;
		int en = 0;
		for(int i= 0 ;i<= maxI;i++) {
			tmp = Math.max(tmp, arr[i]);
			if(tmp == max) {
				st = i;
				break;
			}
			sum += tmp;
		}
		tmp = 0;
		for(int i = maxI; i>=0;i--) {
			tmp = Math.max(tmp, arr[i]);
			if(tmp == max) {
				en = i;
				break;
			}
			sum += tmp;
		}
		// 이제 최대 높이기둥 사이만 더하면됨
		sum += arr[st] * (en - st +1);
		
		System.out.println(sum);
	}
	
	
}
