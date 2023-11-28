import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> Q=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++){
			int t=Integer.parseInt(br.readLine());
			Q.add(t);
		}
		int cnt=0;
		while(m<=Q.peek() && cnt<c) {
			int t=Q.poll();
			t=Math.max(1,t/2);
			Q.add(t);
			cnt++;
		}
		if(m>Q.peek() && cnt<=c) System.out.println("YES\n"+cnt);
		else System.out.println("NO\n"+Q.peek());
	}
}
