package baek;

import java.io.*;
import java.util.*;

public class Pro_1043_거짓말2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int t_cnt = Integer.parseInt(st.nextToken());
		boolean[] truth = new boolean[N];
		List<Integer> t_list = new ArrayList<Integer>();
		for (int i = 0; i < t_cnt; i++) {
			int num = Integer.parseInt(st.nextToken()) - 1;
			truth[num] = true;
			t_list.add(num);
		}
		List<Integer>[] arr = new ArrayList[N];// 인접리스트 만들기
		List<Integer>[] party = new ArrayList[M];// 인접리스트 만들기
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			List<Integer> list=new ArrayList<Integer>();
			for (int j = 0; j < p; j++) {
				int num=Integer.parseInt(st.nextToken()) - 1;
				party[i].add(num);
				list.addAll(arr[num]);
				list.add(num);
				
			}
			for (Integer a : party[i]) {
				arr[a].addAll(list);
			}
		}
		
		for(Integer a:t_list) {
			for(Integer b:arr[a]) {
				truth[b]=true;
			}
		}
		int cnt=0;
		b: for(List<Integer> list:party) {
			for(Integer a:list) {
				if(truth[a]) continue b;
			}
			cnt++;
		}
		System.out.println(Arrays.toString(truth));
		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);

	}
}
