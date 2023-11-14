import java.io.*;
import java.util.*;

public class Main {
	static int N,M,C;
	static int[] arr,brr;
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[N];
		brr=new int[N];
		for(int i=0;i<M;i++) {
			int t=Integer.parseInt(br.readLine());
			arr[t]=1;
		}
		for(int i=0;i<C;i++) {
			brr[0]=(arr[1]+arr[N-1])%2;
			brr[N-1]=(arr[N-2]+arr[0])%2;
			for(int j=1;j<N-1;j++) brr[j]=(arr[j-1]+arr[j+1])%2;
			arr=brr.clone();
		}
		int ans=0;
		for(int i=0;i<N;i++) if(arr[i]==1) ans++;
		System.out.println(ans);
	}
}
