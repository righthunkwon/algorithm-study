package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2879_코딩은예쁘게 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cur = new int[N];
		int[] tab = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) tab[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) tab[i] = Integer.parseInt(st.nextToken()) - tab[i];
		
		int res = 0;
		int diff = 0;
		
		if(N > 1) {
			diff = tab[0];
			for(int i = 1; i < N; i++) {
				if(diff * tab[i] < 0) res += Math.abs(diff);
				else if(Math.abs(diff) >= Math.abs(tab[i]))
					res += Math.abs(diff) - Math.abs(tab[i]);
				diff = tab[i];
			}
		} else res = tab[0];
		
		res += Math.abs(diff);
		System.out.println(res);
	}
}
		
//		for(int i = 0; i < N; i++) {
//			int newDiff = tab[i] - cur[i];
//			if(newDiff == 0) res += Math.abs(diff);
//			if((diff <= 0 && newDiff > 0) || (diff >= 0 && newDiff < 0)) {
//				res += Math.abs(diff);
//				diff = newDiff;
//			} else {
//				if(diff > 0) diff = diff < newDiff ? newDiff : diff;
//				else diff = diff > newDiff ? newDiff : diff;
//			}
//		}
//		
//		res += Math.abs(diff);
//		System.out.println(res);
		
