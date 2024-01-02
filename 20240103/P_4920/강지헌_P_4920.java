import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][][] find={
				{{0, 0, 0, 0}, {0, 1, 2, 3}},
				{{0, 1, 2, 3}, {0, 0, 0, 0}},
				{{0, 0, 1, 1}, {0, 1, 1, 2}},
				{{0, 1, 1, 2}, {0, 0, -1, -1}},
				{{0, 0, 0, 1}, {0, 1, 2, 2}},
				{{0, 1, 2, 2}, {0, 0, 0, -1}},
				{{0, 1, 1, 1}, {0, 0, 1, 2}},
				{{0, 0, 1, 2}, {0, 1, 0, 0}},
				{{0, 1, 1, 1}, {0, -1, 0, 1}},
				{{0, 1, 1, 2}, {0, 0, 1, 0}},
				{{0, 0, 0, 1}, {0, 1, 2, 1}},
				{{0, 1, 1, 2}, {0, -1, 0, 0}},
				{{0, 0, 1, 1}, {0, 1, 1, 0}},
		};
		int ans=1;
		for(;;) {
			int N=Integer.parseInt(br.readLine().trim());
			if(N==0) return;
			int[][] map=new int[N][N];
			int max=Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) map[i][j]=Integer.parseInt(st.nextToken().trim());
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<find.length;k++) {
						int sum=0;
						boolean f=false;
						for(int l=0;l<4;l++) {
							int dx=i+find[k][0][l], dy=j+find[k][1][l];
							if(dx>=0 && dx<N && dy>=0 && dy<N) sum+=map[dx][dy];
							else {
								f=true;
								break;
							}
						}
						if(!f) max=Math.max(max, sum);
					}
				}
			}
			System.out.println(ans+". "+max);
			ans++;
		}
	}
}
