package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2831_댄스파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> mp = new ArrayList<>();
		List<Integer> mm = new ArrayList<>();
		List<Integer> wp = new ArrayList<>();
		List<Integer> wm = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp > 0) mp.add(tmp);
			else mm.add(-tmp);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp > 0) wp.add(tmp);
			else wm.add(-tmp);
		}
		
		Collections.sort(mp);
		Collections.sort(mm);
		Collections.sort(wp);
		Collections.sort(wm);
		
		int res = 0;
		int i = 0, j = 0;
		
		while(i < mp.size() && j < wm.size()) {
			if(mp.get(i) > wm.get(j)) {
				i++; j++;
				res++;
			}else j++;
		}
		i = 0; j = 0;
		while(i < wp.size() && j < mm.size()) {
			if(wp.get(i) > mm.get(j)) {
				i++; j++;
				res++;
			}else i++;
		}
		
		System.out.println(res);
	}
}
		
		// 우선순위 큐로 풀어보려 했지만 실패
//		PriorityQueue<Integer> mp = new PriorityQueue<>();
//		PriorityQueue<Integer> mm = new PriorityQueue<>();
//		PriorityQueue<Integer> wp = new PriorityQueue<>();
//		PriorityQueue<Integer> wm = new PriorityQueue<>();
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			if(tmp > 0) mp.add(tmp);
//			else mm.add(-tmp);
//		}
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			if(tmp > 0) wp.add(tmp);
//			else wm.add(-tmp);
//		}
//		
//		int res = 0;
//		
//		while(!mp.isEmpty() && !wm.isEmpty()) if(mp.poll() < wm.poll()) res++;
//		while(!mm.isEmpty() && !wp.isEmpty()) if(mm.poll() > wp.poll()) res++;
//		
//		System.out.println(res);
		

