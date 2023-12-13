package _20231214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202_보석도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
    		@Override
    		public int compare(int[] o1, int[] o2){
    			if(o1[1] == o2[1]){
    				return Integer.compare(o1[0],o2[0]);
    			} else{
    				return Integer.compare(-o1[1],-o2[1]);
    			}
    		}
    	});
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a,b});
		}
		PriorityQueue<Integer> C = new PriorityQueue<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			C.add(Integer.parseInt(st.nextToken()));
		}
		PriorityQueue<Integer> check = new PriorityQueue<>();
		
		long ans =0;
		while(K>0 && !pq.isEmpty()) {
			int cnt =0; // 보석을 담을 수 있는 가방이 없는지를 체크
			int[] tmp = pq.peek();
			
			out : while(!C.isEmpty()) {
				int tmpC = C.poll();
				if(tmp[0]<=tmpC) {
					int[] j = new int[2];
					j = pq.poll();
					ans += j[1];
					K--;
					cnt =1; //담을 수 있는 가방이 있었으면 1로 바꿈
					break out;
				}else {
					check.add(tmpC);
				}
			}
			// 0 일때는 보석 담을 가방이 없으므로 그 보석은 뺀다
			if(cnt==0) {
				pq.poll();
			}
			// 임시로 빼뒀던 가방을 다시 넣어준다
			while(!check.isEmpty()) {
				int a = check.poll();
				C.add(a);
			}
			
		}
		System.out.println(ans);
		
		
	}//main

}
