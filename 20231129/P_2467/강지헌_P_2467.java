import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		int max=Integer.MAX_VALUE,d1=0,d2=0;
		for(int i=0;i<n;i++) {
			int l=i+1;
			int r=n-1;
			while(l<=r) {
				int m=(l+r)/2;
				int sum=arr[i]+arr[m];
				if(Math.abs(sum)<max) {
					d1=arr[i];
					d2=arr[m];
					max=Math.abs(sum);
				}
				if(sum<0) l=m+1;
				else r=m-1;
			}
		}
		System.out.println(d1+" "+d2);
	}
}
