import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long a=Long.parseLong(st.nextToken());
		long b=Long.parseLong(st.nextToken());
		long c=Long.parseLong(st.nextToken());
		long d=Long.parseLong(st.nextToken());
		long ans=Long.MAX_VALUE;
		if (b*c<d*a) {
			long t;
			t=a; a=c; c=t;
			t=b; b=d; d=t;
		}
		for (int i=0;i<c;++i) {
			long t=(long)Math.ceil((double)(n-i*a)/c);
			if (t<0) t=0;
			ans=Math.min(ans,i*b+t*d);
			if (t==0) break;
		}
		System.out.println(ans);
	}
}
