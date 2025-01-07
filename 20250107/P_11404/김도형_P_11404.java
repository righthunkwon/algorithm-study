import java.io.*;
import java.util.*;

public class BOJ_G4_11404_플로이드 {
	
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		final int INF = 987654321; //MAX_VALUE 하면 int범위 벗어나서 오버플로우..
		int [][] arr = new int [n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(arr[i], INF);
			arr[i][i]=0; 
		}
		StringTokenizer st;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//출발
			int b = Integer.parseInt(st.nextToken());//도착
			int c = Integer.parseInt(st.nextToken());//비용
			arr[a][b]=Math.min(arr[a][b], c); //최소 비용 저장
		}
		
		//플로이드-워셜 알고리즘
		for(int i=1;i<=n;i++) { //경유
			for(int j=1;j<=n;j++) { //출발
				for(int k=1;k<=n;k++) { //도착
					if(arr[j][k]>arr[j][i]+arr[i][k])arr[j][k]=arr[j][i]+arr[i][k];
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==INF)arr[i][j]=0; //갈수 없는 경우는 0출력
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
