import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N][M];
		int[] xx= {1,0,-1,0}, yy= {0,1,0,-1};
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int ans=0;
		while(true) {
			ans++;
			int[][] chk = new int[N][M];
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					for(int k=0;k<4;k++) if(arr[i][j]+chk[i][j]>0 && arr[i+xx[k]][j+yy[k]]==0) chk[i][j]--;
				}
			}
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					arr[i][j]+=chk[i][j];
				}
			}
			chk = new int[N][M];
			boolean f=false;  
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(arr[i][j]!=0 && chk[i][j]==0) {
						if(f) {
							System.out.println(ans);
							return;
						}
						f=true;
						Queue<int[]> Q = new LinkedList<>();
						Q.add(new int[] {i,j});
						chk[i][j]=1;
						while(!Q.isEmpty()) {
							int[] t=Q.poll();
							for(int k=0;k<4;k++) {
								if(arr[t[0]+xx[k]][t[1]+yy[k]]!=0 && chk[t[0]+xx[k]][t[1]+yy[k]]==0) {
									chk[t[0]+xx[k]][t[1]+yy[k]]=1;
									Q.add(new int[] {t[0]+xx[k],t[1]+yy[k]});
								}
							}
						}
					}
				}
			}
			if(!f) break;
		}
		System.out.println(0);
	}
}
