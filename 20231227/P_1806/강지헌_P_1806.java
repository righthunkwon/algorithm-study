import java.io.*;
import java.util.*;
public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		int s=0,e=-1,sum=0,min=Integer.MAX_VALUE;
		if(arr[0]>=M) min=1;
		while(s<N-1 && e<N-1) {
			while(e+1<N && sum<=M) sum+=arr[++e];
			if(sum>=M && e-s+1<min) min=e-s+1;
			while(sum>M) {
				sum-=arr[s++];
				if(sum>=M && e-s+1<min) min=e-s+1;
			}
		}
		System.out.println((min==Integer.MAX_VALUE?0:min));
	}
}
