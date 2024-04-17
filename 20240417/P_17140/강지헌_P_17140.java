import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] arr = new int[100][100];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		if(arr[n-1][m-1]==c) {
			System.out.println(0);
			return;
		}
		int x=3,y=3;
		for(int T=1;T<=100;T++) {
			int[][] narr = new int[100][100];
			int max=Math.min(x,y);
			for(int i = 0; i<Math.max(x, y); i++) {
				int[][] chk = new int[101][2];
				for(int j=0;j<=100;j++) chk[j][0]=j;
				for(int j=0;j<y;j++) {
					if(x>=y) chk[arr[i][j]][1]++;
					else chk[arr[j][i]][1]++;
				}
				Arrays.sort(chk,((o1, o2) -> {
					if(o1[1]==o2[1]) return o1[0]-o2[0];
					return o1[1]-o2[1];
				}));
				int t=0;
				for(int j=0;j<=100;j++) {
					if (chk[j][1] != 0 && chk[j][0]!=0) {
						if (t > 99) break;
						if(x>=y) {
							narr[i][t++] = chk[j][0];
							narr[i][t++] = chk[j][1];
						}
						else {
							narr[t++][i] = chk[j][0];
							narr[t++][i] = chk[j][1];
						}
					}
				}
				max = Math.max(max, t);
			}
			if(narr[n-1][m-1]==c) {
				System.out.println(T);
				return;
			}
			if(x>=y) y=max;
			else x=max;

			for(int i=0;i<Math.max(x,y);i++) {
				for(int j=0;j<Math.max(x,y);j++) arr[i][j]=narr[i][j];
			}
		}
		System.out.println(-1);
	}
}
