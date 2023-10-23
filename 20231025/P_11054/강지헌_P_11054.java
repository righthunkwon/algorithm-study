import java.io.*;
import java.util.*;

public class Main {
	public static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int i,j;
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N],a1=new int[N],a2=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());

		for(i=0;i<N;i++) {
			a1[i]=1;
			for(j=0;j<i;j++) {
				if(arr[i]>arr[j] && a1[i]<a1[j]+1) a1[i]=a1[j]+1;
			}
		}
		for(i=N-1;i>=0;i--) {
			a2[i]=1;
			for(j=N-1;j>i;j--) {
				if(arr[i]>arr[j] && a2[i]<a2[j]+1) a2[i]=a2[j]+1;
			}
		}
		int max=0;
		for(i=0;i<N;i++) max=Math.max(max, a1[i]+a2[i]);
		System.out.println(max-1);
	}
}
