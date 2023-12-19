import java.io.*;
import java.util.*;

public class Main {
	static int[] brr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
		
		int m=Integer.parseInt(br.readLine());
		brr=new int[m];
		for(int i=0;i<m;i++) brr[i]=Integer.parseInt(br.readLine());
		
		System.out.println(dfs(0,a,b));
	}
	static int dfs(int cnt,int a,int b) {
		if(cnt == brr.length) return 0;
		return Math.min(Math.abs(a-brr[cnt])+dfs(cnt+1,b,brr[cnt]),Math.abs(b-brr[cnt])+dfs(cnt+1,a,brr[cnt]));
	}
}
