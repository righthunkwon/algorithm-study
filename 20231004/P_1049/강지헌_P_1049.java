import java.io.*;
import java.util.*;

public class q1049 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int m6=Integer.MAX_VALUE,m1=Integer.MAX_VALUE;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(m6>a) m6=a;
			if(m1>b) m1=b; 
		}
		
		if(m1*6<m6) System.out.println(m1*N);
		else if((N%6)*m1>m6) System.out.println(m6*(N/6+1));
		else System.out.println(m6*(N/6)+m1*(N%6));
	}
}
