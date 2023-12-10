import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] chk;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			arr=new int[N];
			chk=new boolean[N];
			if(N==0) return;
			for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
			dfs(0,0);
			System.out.println();
		}
	}
	static void dfs(int n,int c) {
		if(n==N) {
			if(c==6) {
				for(int i=0;i<N;i++) {
					if(chk[i]==true) System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		chk[n]=true;
		dfs(n+1,c+1);
		chk[n]=false;
		dfs(n+1,c);
	}
}
