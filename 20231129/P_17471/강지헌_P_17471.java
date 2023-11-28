import java.io.*;
import java.util.*;
public class Main {
	static int N,map[][],arr[],ans=Integer.MAX_VALUE;
	static boolean chk[];
	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) map[i][Integer.parseInt(st.nextToken())]=1;
		}
		chk=new boolean[N+1];
		dfs(1);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
	private static void dfs(int t) {
		if(t==N+1) {
			if(check(true) && check(false)) {
				int a=0,b=0;
				for(int i=1;i<=N;i++) {
					if(chk[i]) a+=arr[i];
					else b+=arr[i];
				}
				ans=Math.min(ans,Math.abs(a-b));
			}
			return;
		}
		chk[t]=true;
		dfs(t+1);
		chk[t]=false;
		dfs(t+1);
	}
	private static boolean check(boolean flag) {
		boolean isVisited[]=new boolean[N+1];
		LinkedList<Integer> Q=new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(chk[i]==flag) {
				Q.addLast(i);
				isVisited[i]=true;
				break;
			}
		}
		while (!Q.isEmpty()) {
			int n=Q.pollFirst();
			for(int i=1;i<=N;i++) {
				if(isVisited[i] || flag != chk[i]) continue;
				if(map[n][i]==1) {
					Q.addLast(i);
					isVisited[i]=true;
				}
			}
		}
		for(int i=1;i<=N;i++) if(chk[i]==flag && !isVisited[i]) return false;
		return true;
	}
}
