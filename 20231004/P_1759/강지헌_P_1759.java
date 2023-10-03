import java.io.*;
import java.util.*;

public class q1759 {
	static int N,M;
	static char[] arr;
	static boolean[] ch;
	static String mo = "aeiou";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new char[M];
		ch=new boolean[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0,0,0,"");
	}
	static void dfs(int j,int m,int t,String a) {
		if(t==M) {
			if(a.length()==N && j>=2 && m>=1) System.out.println(a);
			return;
		}
		if(mo.contains(Character.toString(arr[t]))) dfs(j,m+1,t+1,a+arr[t]);
		else dfs(j+1,m,t+1,a+arr[t]);
		dfs(j,m,t+1,a);
	}
}
