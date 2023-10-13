import java.io.*;
import java.util.*;

public class q9465 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int te=0;te<T;te++) {
			int N=Integer.parseInt(br.readLine());
			int[][] arr = new int[N+1][2],dy = new int[N+1][2];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					arr[j][i]=Integer.parseInt(st.nextToken());
				}
			}
			int ans=Math.max(arr[1][0], arr[1][1]);
			dy[1][0]=arr[1][0]; dy[1][1]=arr[1][1];
			for(int i=2;i<=N;i++) {
				dy[i][0]=Math.max(dy[i-1][1],Math.max(dy[i-2][0], dy[i-2][1]))+arr[i][0];
				dy[i][1]=Math.max(dy[i-1][0],Math.max(dy[i-2][0], dy[i-2][1]))+arr[i][1];
				ans=Math.max(ans, Math.max(dy[i][0], dy[i][1]));
			}
			System.out.println(ans);
		}
	}
}
