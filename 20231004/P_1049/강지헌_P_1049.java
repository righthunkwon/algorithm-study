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
			if(m6>a) m6=a; //6개 구매 최소값 갱신
			if(m1>b) m1=b; //1개 구매 최소값 갱신
		}
		
		if(m1*6<m6) System.out.println(m1*N); //1개 6번 구매하는게 6개구매보다 싸면 1개로만 구매
		else if((N%6)*m1>m6) System.out.println(m6*(N/6+1)); //6개씩 구매하고 남은걸 1개씩 구매하는것보다 6개 구매하는게 싸면 6개로만 구매
		else System.out.println(m6*(N/6)+m1*(N%6)); //6개로 구매하고 남은건 1개로 구매하기
	}
}
