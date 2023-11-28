import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		long ans=Integer.MAX_VALUE;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(),"-");
		while(st.hasMoreTokens()) {
			int t=0;
			StringTokenizer st2=new StringTokenizer(st.nextToken(),"+");
			while(st2.hasMoreTokens()) t+=Integer.parseInt(st2.nextToken());
			if(ans==Integer.MAX_VALUE) ans=t;
			else ans-=t;
		}
		System.out.println(ans);
	}
}
