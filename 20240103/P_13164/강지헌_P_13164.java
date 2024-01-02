import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] arr=new int[N+1], t=new int[N-1];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());       	
        for(int i=0;i<N-1;i++) t[i]=arr[i+1]-arr[i];
        Arrays.sort(t);
        int min=0;		
	    for (int i=0;i<N-K;i++) min+=t[i];
		System.out.println(min);
	}
}
