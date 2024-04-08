import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		p = new int[N+1];
		for(int i=1;i<=N;i++) p[i]=i;
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				if(Integer.parseInt(st.nextToken())==1) union(i,j);
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		for(int i=1;i<M;i++) {
			int b = Integer.parseInt(st.nextToken());
			if(p[a] != p[b]) { System.out.println("NO"); return; }
		}
		System.out.println("YES");
	}

	static void union(int x,int y) {
		x=find(x); y=find(y);
		if(x>y) p[x]=y;
		else p[y]=x;
	}

	static int find(int a){
		return p[a]==a?a:(p[a]=find(p[a]));
	}
}
