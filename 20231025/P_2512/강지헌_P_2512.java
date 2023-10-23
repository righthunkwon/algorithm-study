import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int s=0,e=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			e=Math.max(e, arr[i]);
		}
		long M=Integer.parseInt(br.readLine());
		while(s<=e) {
			int m=(s+e)/2;
			long t=0;
			for(int i=0;i<N;i++) t+=m>=arr[i]?arr[i]:m;
			if(t<=M) s=m+1;
			else e=m-1;
		}
		System.out.println(e);
	}
}
