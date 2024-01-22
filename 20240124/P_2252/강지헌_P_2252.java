import java.util.*;
import java.io.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] gr = new ArrayList[N+1];
		for(int i=0;i<=N;i++) gr[i] = new ArrayList<Integer>();
		int[] check = new int[N+1];
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			gr[x].add(y);
			check[y]++;
		}
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1;i<=N;i++) if(check[i]==0) Q.add(i);
		List<Integer> ans = new ArrayList<>();
		while(!Q.isEmpty()) {
			int t=Q.poll();
			ans.add(t);
			for(int j : gr[t]) {
				check[j]--;
				if(check[j]==0) Q.add(j);
			}
		}
		for(int i : ans) {
			bw.write(String.valueOf(i)+" ");
		}
		bw.close();
	}
}
