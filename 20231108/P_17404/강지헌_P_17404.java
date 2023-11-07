import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][3];
		int[][] dy = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		int ans=999999999;
		for(int i=0;i<3;i++) {
			dy[0][i]=arr[0][i]; dy[0][(i+1)%3]=dy[0][(i+2)%3]=99999999;
			for(int j=1;j<N;j++) {
				for(int k=0;k<3;k++) dy[j][k]=Math.min(dy[j-1][(k+1)%3], dy[j-1][(k+2)%3])+arr[j][k];
			}
			for(int j=0;j<3;j++) if(j!=i) ans=Math.min(ans, dy[N-1][j]); 
		}
		System.out.println(ans);
	}
}
