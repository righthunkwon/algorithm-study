import java.util.*;
import java.io.*;
public class Main {
	static int N,M,dmin=Integer.MAX_VALUE;
	static boolean[] chk;
	static List<Node> a,b;
	private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		a=new ArrayList<Node>();
		b=new ArrayList<Node>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int t=Integer.parseInt(st.nextToken());
				if(t==1) a.add(new Node(i,j));
				if(t==2) b.add(new Node(i,j));
			}
		}
		chk=new boolean[b.size()];
		dfs(0,0);
		System.out.println(dmin);
	}
	private static void dfs(int idx,int cnt) {
		if(idx==b.size()) {
			if(cnt==M) {
				int sum=0;
				for(int i=0;i<a.size();i++) {
					int min=Integer.MAX_VALUE;
					for(int j=0;j<b.size();j++) {
						if(!chk[j]) continue;
						min=Math.min(min, Math.abs(b.get(j).x-a.get(i).x)+Math.abs(b.get(j).y-a.get(i).y));
					}
					sum+=min;
                    if(sum>=dmin) break;
				}
				dmin=Math.min(sum, dmin);
			}
			return;
		}
		dfs(idx+1,cnt);
		chk[idx]=true;
		dfs(idx+1,cnt+1);
		chk[idx]=false;	
	}
}
class Node {
	int x,y;
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
