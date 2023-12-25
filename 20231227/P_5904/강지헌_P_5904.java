import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		dfs(Integer.parseInt(br.readLine()));
	}
	public static void dfs(int cnt) {
		int s=3,c=0;
		while(cnt>s) {
			s=c+4+s*2;
			c++;
		}
		int t=(s-c-3)/2;
		if(s-t+1<=cnt) dfs(cnt-s+t);
		else if(cnt==t+1) System.out.println("m");
		else System.out.println("o");
	}
}
