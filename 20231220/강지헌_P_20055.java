import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		int ans;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] map=new int[N*2];
		int[] rob=new int[N*2];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N*2;i++) map[i]=Integer.parseInt(st.nextToken());
		for(ans=1;;ans++) {
			int cnt=0,t=map[N*2-1];
			for(int i=N*2-1;i>0;i--) {
				map[i]=map[i-1];
				rob[i]=rob[i-1];
			}
			rob[0]=0;
			map[0]=t;
			rob[N-1]=0;
			for(int i=N-2;i>=0;i--) {
				if(rob[i]==1 && map[i+1]>0 && rob[i+1]==0) {
					rob[i+1]=1;
					rob[i]=0;
					map[i+1]--;
				}
			}
			if(map[0]>0) {
				map[0]--;
				rob[0]=1;
			}
			for(int i=0;i<N*2;i++) if(map[i]==0) cnt++;
			if(cnt>=M) break;
		}
		System.out.println(ans);
	}
}
