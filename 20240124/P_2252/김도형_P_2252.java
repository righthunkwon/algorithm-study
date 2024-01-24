package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //학생 수  N
		int M = Integer.parseInt(st.nextToken()); //비교횟수 M
		ArrayList<Integer>[]list = new ArrayList[N+1];
		for(int i =1;i<N+1;i++) {
			list[i]=new ArrayList<>();
		}
		int [] arr = new int[N+1];
		boolean [] visit = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); //a의 뒤에 서야될 사람 목록들 list[a]에 추가
			arr[b]++; //b앞에 서야 될 사람 생길때마다 카운트해줌
		}
		Queue<Integer>q=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(arr[i]==0) {
				q.add(i); //자기 앞에 서야되는 사람이 없는 사람 큐에 넣기
			}
		}
		StringBuilder sb = new StringBuilder();
		int idx = 0; //N개 뽑을때까지 반복하기 위한 idx
		while(idx<N) {
			int x = q.poll(); 
			visit[x]=true; //방문처리
			sb.append(x+" "); //줄 세우기
			idx++; //하나 뽑았으니까 idx+1
			int L = list[x].size(); //x보다 뒤에 서야되는 사람들
			for(int i=0;i<L;i++) {
				int y=list[x].get(i);
				arr[y]--; //y앞에 서야하는 사람 수 -1
				if(arr[y]==0 && !visit[y]) {
					q.add(y); //더이상 앞에 서야될 사람 안남았으면 q에 넣기
				}
			}
		}
		System.out.println(sb.toString());
	}//main
}//class
