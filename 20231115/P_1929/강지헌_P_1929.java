import java.io.*;
import java.util.*;

public class Main {
	static boolean[] pr = new boolean[1000001];
	static int N,M;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pr[1]=true;
		for(int i=2;i<=1000;i++) {
			for(int j=i*2;j<=1000000;j+=i) {
				pr[j]=true;
			}
		}
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		for(int i=N;i<=M;i++) {
			if(!pr[i]) bw.write(i+"\n");
		}
		bw.close();
	}
}
class Node {
	int x, y;
	Node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
