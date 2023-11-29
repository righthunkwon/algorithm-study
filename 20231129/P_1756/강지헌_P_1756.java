import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int arr[]=new int[M];
		int[] p=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i!=0 && arr[i-1]<arr[i]) arr[i]=arr[i-1];
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) p[i]=Integer.parseInt(st.nextToken());
		int t=0,ans=0,j=M-1;
		for(int i=0;i<N;i++) {
			for(;j>=0;j--) {
				if(arr[j]>=p[i]) {
					ans=j+1;
					t++;
					j--;
					break;
				}
			}
		}
		System.out.println(t!=N?0:ans);
	}
}
