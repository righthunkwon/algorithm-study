package study_240320;

import java.io.*;
import java.util.*;

public class Pro_2437_저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scale = new int[N];
		for (int i = 0; i < N; i++) {
			scale[i] = Integer.parseInt(st.nextToken());
		}
		// 1 1 2 3 6 7 30
		Arrays.sort(scale);
		//그니까 이게 여태까지 만들수 있는 num과 제일 마지막 추 더하면 그 수 까지는 가능하다는것인데
		//마지막 추가 8이라면 15까지 가능하다.
		int possible = 0;
		for (int i = 0; i < N; i++) {
			if(scale[i]>possible+1) {
				System.out.println(possible+1);
				System.exit(0);
			}else {
				possible+=scale[i];
			}
		}
		System.out.println(possible+1);
	}
}
