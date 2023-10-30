import java.io.*;
import java.util.*;

public class Main {
	static int[] chk=new int[100001],p;
	static int N,M;
	public static void main(String [] args) throws IOException {
		Queue<Node> Q=new LinkedList<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		Q.add(new Node(N,0));
		int dist=Integer.MAX_VALUE,ans=0;
		while(!Q.isEmpty()) {
			Node t=Q.poll();
			if(t.x==M) dist=t.c;
			if(dist==t.c) {
				if(t.x==M) ans++;
				continue;
			}
			if(check(t.x-1,t.c+1)) Q.add(new Node(t.x-1,t.c+1));
			if(check(t.x+1,t.c+1)) Q.add(new Node(t.x+1,t.c+1));
			if(check(t.x*2,t.c+1)) Q.add(new Node(t.x*2,t.c+1));
		}
		System.out.println(dist+"\n"+ans);
	}
	private static boolean check(int x,int c) {
		if(x<0 || x>100000) return false;
		if(chk[x]!=0 && chk[x]!=c) return false;
		chk[x]=c;
		return true;
	}
}
class Node {
	int x,c;
	Node(int x,int c) {
		this.x=x;
		this.c=c;
	}
}
