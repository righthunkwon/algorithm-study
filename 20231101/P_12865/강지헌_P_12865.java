import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] dy = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			for(int j=0;j<=M;j++) {
				dy[i][j]=dy[i-1][j];
				if(j-W>=0) dy[i][j]=Math.max(dy[i][j], dy[i-1][j-W]+V);
			}
		}
		int ans=0;
		for(int i=0;i<=M;i++) ans=Math.max(dy[N][i], ans);
		System.out.println(ans);
	}
}
