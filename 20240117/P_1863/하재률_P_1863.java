package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1863_스카이라인쉬운거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < n; i++) {
			if(arr[i] == 0) {
				while(!s.isEmpty()) {
					s.pop();
					cnt++;
				}
			} else {
				while(!s.isEmpty() && s.peek() > arr[i]) {
					s.pop();
					cnt++;
				}
				if(s.isEmpty() || s.peek() < arr[i]) s.add(arr[i]);
				
			}
		}
		
		cnt += s.size();
		System.out.println(cnt);
	}
}
