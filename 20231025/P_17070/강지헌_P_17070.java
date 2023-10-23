import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][][] dy=new int[N][N][3];
		int[][] arr=new int[N][N];
		for (int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		dy[0][1][0]=1;
		for (int i=0;i<N;i++) {
			for (int j=1;j<N;j++) {
				if ((i==0 && j<2) || arr[i][j]==1) continue;
				if (i-1>=0 && arr[i-1][j-1]!=1 && arr[i-1][j]!=1 && arr[i][j-1]!=1) dy[i][j][2]=dy[i-1][j-1][0]+dy[i-1][j-1][1]+dy[i-1][j-1][2];
				if (i-1>=0 && arr[i-1][j]!=1) dy[i][j][1]=dy[i-1][j][1]+dy[i-1][j][2];
				if (arr[i][j-1]!=1) dy[i][j][0]=dy[i][j-1][0]+dy[i][j-1][2];
				
			}
		}
		System.out.println(dy[N-1][N-1][0]+dy[N-1][N-1][1]+dy[N-1][N-1][2]);
	}
}
