import java.io.*;
import java.util.*;

public class Main {
	static int[] chk=new int[100001];
	static int N,M;
	public static void main(String [] args) throws IOException {
		Queue<Node> Q=new LinkedList<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<=100000;i++) chk[i]=-1;
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		if(N==M) {System.out.println(0); System.out.println(N); return;}
		Q.add(new Node(N,0));
		while(!Q.isEmpty()) {
			Node t=Q.poll();
			if(t.x==M) {
				Stack<Integer> ans=new Stack<>();
				System.out.println(t.c);
				
				while(t.x!=N) {
					ans.push(t.x);
					t.x=chk[t.x];
				}
				ans.push(N);
				while(!ans.isEmpty()) System.out.print(ans.pop()+" ");
			}
			if(check(t.x-1,t.c+1,t.x)) Q.add(new Node(t.x-1,t.c+1));
			if(check(t.x+1,t.c+1,t.x)) Q.add(new Node(t.x+1,t.c+1));
			if(check(t.x*2,t.c+1,t.x)) Q.add(new Node(t.x*2,t.c+1));
		}
	}
	private static boolean check(int x,int c,int d) {
		if(x<0 || x>100000) return false;
		if(chk[x]!=-1) return false;
		chk[x]=d;
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
