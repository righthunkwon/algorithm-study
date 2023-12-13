package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken()); // 세로 길이 1 ~ 500
		int W = Integer.parseInt(st.nextToken()); // 가로 길이 1 ~ 500
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) arr[i] = Integer.parseInt(st.nextToken()); // 입력완
		
		int res = 0;
		for(int i = 1; i < W-1; i++) { // 양끝빼고
			int l = 0; int r = 0;
			for(int j = 0; j < i; j++) l = l > arr[j] ? l : arr[j]; // 왼쪽벽 설정
			for(int j = i; j < W; j++) r = r > arr[j] ? r : arr[j]; // 오른쪽벽 설정
			if(arr[i] < l && arr[i] < r) res += l < r ? l - arr[i] : r - arr[i]; // 그 칸 빗물 채우기
		}
		System.out.println(res);
	}
}
