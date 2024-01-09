package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27172_수나누기게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] res = new int[1000001];
		boolean[] tmp = new boolean[1000001];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = max > arr[i] ? max : arr[i];
			tmp[arr[i]] = true;
		}
		
		for(int i : arr) {
            for (int j = i + i; j < max + 1; j += i) {
                if (tmp[j]) {
                	res[i]++;
                	res[j]--;
                }
            }
        }
		
		for(int i : arr) System.out.print(res[i] + " ");
	}
}
