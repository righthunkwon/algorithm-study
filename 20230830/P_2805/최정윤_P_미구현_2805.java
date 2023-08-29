package baek;
import java.io.*;
import java.util.*;

public class Problem_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		long max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max=Math.max(max, arr[i]);
		}
		long min = 0;
		long sum = 0;
		long middle = (min + max) / 2;
		while (min<=max) {
			 middle = (min + max) / 2;
			sum = 0;
			for (int i=0;i<N;i++) {
				if (arr[i] - middle >= 0) {
					sum += arr[i] - middle;
				}
			}
			if (sum < M)
				max = middle - 1;
			else if (sum > M)
				min = middle + 1;
			else {
				break;
			}
		}
		System.out.println(middle);


	}
}
