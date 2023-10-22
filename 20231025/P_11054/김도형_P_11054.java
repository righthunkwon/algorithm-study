package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q11054_가장_긴_바이토닉_부분_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] arr = new int[N + 1];
		int maxlength = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		int increaseMax = 0;
		int decreaseMax = 0;
		int[] increaseDP = new int[N + 1]; // 앞에서부터 i번쨰 행까지 봤을 때 가장 긴 증가부분수열 길이 구할 dp배열
		int[] decreaseDP = new int[N + 1]; // 뒤에서부터 i번쨰 행까지 봤을 때 가장 긴 감소부분수열 길이 구할 dp배열

		// 증가하는 부분수열 최대 길이 구하기
		increaseDP[1] = 1;
		for (int i = 2; i < N + 1; i++) {
			increaseDP[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i]) {
					increaseDP[i] = Math.max(increaseDP[i], increaseDP[j] + 1);
				}
			}
			increaseMax = Math.max(increaseMax, increaseDP[i]);
		}

		// 감소하는 부분수열 최대 길이 구하기
		decreaseDP[N] = 1;
		for (int i = N - 1; i >= 1; i--) {
			decreaseDP[i] = 1;
			for (int j = N; j > i; j--) {
				if (arr[j] < arr[i]) {
					decreaseDP[i] = Math.max(decreaseDP[i], decreaseDP[j] + 1);
				}
			}
			decreaseMax = Math.max(decreaseMax, decreaseDP[i]);
		}

		for (int i = 1; i <= N; i++) {
			int bitonicLength = increaseDP[i] + decreaseDP[i] - 1;
			maxlength = Math.max(maxlength, bitonicLength);
		}

		System.out.println(maxlength);

	}// main

}// class



///////////////////////////////////////////////////////////////////////시간초과 dfs ver ㅠㅠㅠ

public class BOJ_Q11054_가장_긴_바이토닉_부분_수열_dfs시간초과 {

	static int N;
	static int[]arr;
	static int maxlength;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 수열의 크기
		arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}//입력 끝
		
		maxlength=0;
		dfs(0,0,0,0);
		System.out.println(maxlength);
	}
	
	//idx: 현위치  nownum : 가장 최근 선택한 숫자   status : 증감상태( 0: 증가중 / 1: 감소중 ) cnt:선택한 숫자 갯수
	public static void dfs(int idx,int nownum, int status, int cnt) {
		
		if(idx>=N) {
			maxlength=Math.max(maxlength, cnt);
			return;
		}
		
		if(status==0) { //증가중인 상태에
			if(nownum<arr[idx]) { //최근 선택 숫자보다 큰 숫자를 만나면
				
				dfs(idx+1,arr[idx],0,cnt+1); //선택하고 증가상태
				dfs(idx+1,nownum,0,cnt); //선택안하고 넘어가기
				
			}else if(nownum>arr[idx]) { //최근 선택 숫자보다 작은 숫자를 만나면
				
				dfs(idx+1,arr[idx],1,cnt+1); //선택하고 감소로 전환
				dfs(idx+1,nownum,0,cnt); //선택안하고 넘어가기
			}else //같은숫자면 패스
				dfs(idx+1,nownum,0,cnt);
			
		}else { //감소중인 상태면
			if(nownum<=arr[idx]) //최근 선택 숫자보다 큰 수 만나면
				dfs(idx+1,nownum,status,cnt); //넘어가기
			else {
				dfs(idx+1,arr[idx],1,cnt+1);//선택하고 감소상태
				dfs(idx+1,nownum,1,cnt);//선택안하고 넘어가기
			}
		}
		
	}
	
}


