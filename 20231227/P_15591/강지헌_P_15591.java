import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		int ans;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		ArrayList<int[]>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++) arr[i]=new ArrayList<>();
		for(int i=1;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			arr[a].add(new int[] {b,c});
			arr[b].add(new int[] {a,c});
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			boolean[] chk=new boolean[N+1];
			chk[v]=true;
			Queue<Integer> Q=new LinkedList<>();
			Q.add(v);
			ans=0;
			while(!Q.isEmpty()) {
				int t=Q.poll();
				for(int[] j : arr[t]) {
					if(!chk[j[0]] && j[1]>=k) {
						Q.add(j[0]);
						chk[j[0]]=true;
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
