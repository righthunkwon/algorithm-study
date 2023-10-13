import java.io.*;
import java.util.*;
public class q29813 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Queue<Node> Q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a=st.nextToken();
			int b=Integer.parseInt(st.nextToken());
			Q.add(new Node(a,b));
		}
		while(true) {
			Node t = Q.poll();
			if(Q.isEmpty()) {
				System.out.println(t.name);
				return;
			}
			for(int i=1;i<t.num;i++) Q.add(Q.poll());
			Q.poll();
		}
	}
}
class Node {
	String name;
	int num;
	Node(String name,int num) {
		this.name=name;
		this.num=num;
	}
}
