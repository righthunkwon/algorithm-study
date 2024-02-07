package _20240207;

import java.util.*;
import java.io.*;

public class _1041_주사위 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		for(int i=0;i<6;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		if (N==1) {
			Arrays.sort(arr);
			int sum=0;
			for(int i=0;i<5;i++) {
				sum +=arr[i];
			}
			System.out.println(sum);
			return;
		}

		long oneSide = Long.MAX_VALUE, twoSides = Long.MAX_VALUE, threeSides = Long.MAX_VALUE;
		for(int i=0;i<6;i++) {
			oneSide = Math.min(oneSide, arr[i]);
			for(int j=0;j<6;j++) {
				if(i!=j && i+j!=5) { // 마주 보는 면을 피함
					twoSides = Math.min(twoSides, arr[i]+arr[j]);
					for(int k=0;k<6;k++) {
						if (k!=i && k!=j && i+k!=5 && j+k!=5 && i+j!=5) { // 마주 보는 면을 피함
							threeSides = Math.min(threeSides, arr[i]+arr[j]+arr[k]);
						}
					}
				}
			}
		}

		long sum = 0;
		sum += (long)(N-2) * (N-2) * oneSide; // 중앙 면
		sum += (long)(N-2) * 4 * (N-1) * oneSide; // 가장자리 면
		sum += (long)(4 * (N-1) + (N-2)*4) * twoSides; // 가장자리 두 면
		sum += 4 * threeSides; // 모서리

		System.out.println(sum);
	}//main
}
