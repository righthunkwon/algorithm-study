import java.io.*;
import java.util.*;
public class Main {
	static int N,ans=0;
	static int[][] arr;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int t) {
		if(t>10000) {
			check(t);
			return;
		}
		for(int i=1;i<=4;i++) dfs(t*10+i);
	}
	private static void check(int t) {
		Deque<Integer> li = new ArrayDeque<>();
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) map[i][j]=arr[i][j];
		}
		for(int d=t%10;d!=0;t/=10,d=t%10) {
			int[][] tmp=new int[N][N];
			for(int i=0;i<N;i++) {
				boolean f=false;
				for(int j=0;j<N;j++) {
					int di=i,dj=j;
					if(d%2==0) dj=N-j-1;
					if(d==3 || d==4) {
						di=dj;
						dj=i;
					}
					if(map[di][dj]!=0) {
						if(!li.isEmpty() && li.peekLast()==map[di][dj] && !f) {
							li.addLast(li.pollLast()*2);
							f=true;
						}
						else {
							li.addLast(map[di][dj]);
							f=false;
						}
					}
				}
				int j=0;
				if(d%2==0) j=N-1;
				while(!li.isEmpty()) {
					if(d==1) tmp[i][j++]=li.pollFirst();
					else if(d==2) tmp[i][j--]=li.pollFirst();
					else if(d==3) tmp[j++][i]=li.pollFirst();
					else if(d==4) tmp[j--][i]=li.pollFirst();
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) map[i][j]=tmp[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) ans=Math.max(ans, map[i][j]);
		}
	}
}
