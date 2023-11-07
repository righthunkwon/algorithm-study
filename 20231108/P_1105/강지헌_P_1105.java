import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a=st.nextToken();
		String b=st.nextToken();
		int c=0;
		if(a.length()==b.length()) {
			for(int i=0;i<a.length();i++) {
				if(a.charAt(i)!=b.charAt(i)) break;
				if(a.charAt(i)=='8') c++;
			}
		}
		System.out.println(c);
	}
}
