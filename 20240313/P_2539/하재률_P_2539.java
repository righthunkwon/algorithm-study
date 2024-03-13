package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2539_모자이크 {
	
	static int n, m, p, x, max;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = Integer.parseInt(br.readLine());
		x = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			max = max > r ? max : r;
			list.add(c);
		}
		
		Collections.sort(list);
//		for(int i = 0; i < x; i++)System.out.print(list.get(i) + " ");
		int l = max;
		int r = n > m ? n : m;
		
		int res = 0;
		while(l <= r) {
			int mid = (l + r) / 2;
//			System.out.println("mid : "+mid + " => " + l + ", " + r);
			if(sol(mid)) {
				r = mid - 1;
				res = mid;
			}
			else {
				l = mid + 1;
			}
		}
		System.out.println(res);
	}
	
	static boolean sol(int mid) {
		int cnt = 1;
		int tmp = list.get(0) + mid - 1;
		for(int i = 1; i < x; i++) {
			if(tmp < list.get(i)) {
				tmp = list.get(i) + mid - 1;
				cnt++;
				if(cnt > p) return false;
			}
		}
		return true;
		
	}
}
