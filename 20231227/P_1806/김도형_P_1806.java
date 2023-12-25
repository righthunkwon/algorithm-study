package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q1806_부분합 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		int start = 0;
		int end = 0;
		int minLength = 100000;
		int hap = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));
		
		
		//처음 end 구하기
		while (true) {
			hap+=arr[end];
			if(hap>=S) {
				break;
			}
			end++;
			if(end>=N) {
				System.out.println(0);
				return;
			}
		}
		
//		System.out.println("start:"+start);
//		System.out.println("end:"+end);
//		System.out.println("--------------");
		

		//start 하나씩 늘리다가 hap이 S보다 작아지는 지점에서 길이 재보고 갱신
		//그 다음 end 하나씩 늘리다가 hap이 S보다 크거나 같아지면 다시 위 과정으로..
		l:while (end < N) {

			while (true) {
				hap-=arr[start];
				start++;
				if(hap<S) {
					minLength=Math.min(minLength, end-start+2);
					break;
				}
			}
			
			while (true) {
				end++;
				if(end>=N)break l;
				
				hap+=arr[end];
				if(hap>=S) {
					break;
				}
			}

		}
		if(minLength == 100000) {
			System.out.println(0);
		}else
		System.out.println(minLength);
			
		
		

	}

}
