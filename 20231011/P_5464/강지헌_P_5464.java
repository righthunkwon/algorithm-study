import java.io.*;
import java.util.*;
public class q5464 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] c=new int[N+1],arr=new int[N+1],w=new int[M+1];
		for(int i=1;i<=N;i++) c[i]=Integer.parseInt(br.readLine());
		for(int i=1;i<=M;i++) w[i]=Integer.parseInt(br.readLine());
		int ans=0;
		Queue<Integer> Q=new LinkedList<>();
l: 		for(int i=0;i<M*2;i++) {
			int t=Integer.parseInt(br.readLine());
			if(t>=0) {
				for(int j=1;j<N+1;j++) {
					if(arr[j]==0) {
						arr[j]=t;
						continue l;
					}
				}
				Q.add(t);
			}
			else {
				for(int j=1;j<N+1;j++) {
					if(arr[j]==-t) {
						arr[j]=0;
						if(!Q.isEmpty()) arr[j]=Q.poll();
						ans+=c[j]*w[-t];
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
