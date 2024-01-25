import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		// 투포인터 써서 
		// 최장길이를 구해보자
		int ans = 0 ;
		int[] cnt = new int[200001];
		int left = 0;
		int right = 0;
		cnt[arr[0]]++;
		while(true) {
			// 일단 오른쪽 하나늘리고
			// 만약 M을 넘어가면
			// Left를 M보다 낮아질떄까지 쭉 떙기고
			// right늘리는 과정에서 ans느 계속 갱신
			
			// 순서가 일단 오른쪽 늘리고
			// cnt에 추가하고
			// 만약 M넘으면
			// 줄이고 반영
//			System.out.println(right+" "+left+1);
			
			ans = Math.max(ans, right-left+1);
			right++;
			if(right ==N) {
				break;
			}
			cnt[arr[right]]++;
			if(cnt[arr[right]]> M) {
				while(cnt[arr[right]]>M) {
					//왼쪽꺼 뺴주고 left++
					cnt[arr[left]]--;
					left++;	
				}
			}			
		}
		System.out.println(ans);
		
		
	}
}
