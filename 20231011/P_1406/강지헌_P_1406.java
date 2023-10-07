import java.io.*;
import java.util.*;
public class q1406 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> s1 = new Stack<>(),s2 = new Stack<>();
		for(char i:arr) s1.push(i);
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char s=st.nextToken().charAt(0);
			if(s=='P') s1.push(st.nextToken().charAt(0));
			else if(s=='L' && !s1.isEmpty()) s2.push(s1.pop());
			else if(s=='D' && !s2.isEmpty()) s1.push(s2.pop());
			else if(s=='B' && !s1.isEmpty()) s1.pop();
		}
		while(!s1.isEmpty()) s2.push(s1.pop());
		while(!s2.isEmpty()) bw.write(String.valueOf(s2.pop()));
		bw.close();
	}
}
