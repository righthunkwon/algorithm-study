package _20240110;

import java.util.*;
import java.io.*;

public class _27172_수나누기게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max=0;
		boolean[] card = new boolean[1000001];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			card[arr[i]]=true;
			if(arr[i]>max) max = arr[i];
		}
		
		int[] score = new int[max+1];
		
		for(int i=0;i<N;i++) {
			int a = arr[i];
			int b = max/a;
			for(int j=2;j<=b;j++) {
				if(card[j*a]) {
					score[j*a]-=1;
					score[a]+=1;					
				}
			}
		}

		for(int m : arr) {
			System.out.print(score[m]+" ");
		}
	}//main

}
