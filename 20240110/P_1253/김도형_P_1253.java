package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q1253_좋다 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]arr=new int[N];
		boolean[]good=new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		boolean flag = false;
		
		int ans = 0; //좋은 수의 개수
		
		for(int i=0;i<N;i++) {
			int left = 0;
			int right=N-1;
			while(true) {
				if(left == i)left++; //자기자신은 합에 포함x
				else if(right == i)right--;
				
				if(left>=right)break; //좋은 수 X
				
				if(arr[left]+arr[right]==arr[i]) { //두 수 합 딱 맞아 떨어지면 break
					ans++;
					break;
				}
				
				if(arr[left]+arr[right]>arr[i])right--; //합이 더 크면 오른쪽 땡기기
				else if(arr[left]+arr[right]<arr[i])left++; //합이 더 작으면 왼쪽꺼 땡기기
				
				if(left<0 || right>=N)break; 
			}
		}
		System.out.println(ans);
	}

}
