import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Deque<Integer> d=new ArrayDeque<>(), s=new ArrayDeque<>(),dg=new ArrayDeque<>(), sg=new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			d.addFirst(Integer.parseInt(st.nextToken()));
			s.addFirst(Integer.parseInt(st.nextToken()));
		}
		int i=0;
		while(true) {
			dg.addFirst(d.pollFirst());
			if(d.isEmpty()) break;
			if(dg.peekFirst()==5) {
				while(!sg.isEmpty()) d.addLast(sg.pollLast());
				while(!dg.isEmpty()) d.addLast(dg.pollLast());
			}
			if(!sg.isEmpty() && sg.peekFirst()+dg.peekFirst()==5) {
				while(!dg.isEmpty()) s.addLast(dg.pollLast());
				while(!sg.isEmpty()) s.addLast(sg.pollLast());
			}
			if(++i==M) break;
			sg.addFirst(s.pollFirst());
			if(s.isEmpty()) break;
			if(sg.peekFirst()==5) {
				while(!sg.isEmpty()) d.addLast(sg.pollLast());
				while(!dg.isEmpty()) d.addLast(dg.pollLast());
			}
			if(!dg.isEmpty() && sg.peekFirst()+dg.peekFirst()==5) {
				while(!dg.isEmpty()) s.addLast(dg.pollLast());
				while(!sg.isEmpty()) s.addLast(sg.pollLast());
			}
			if(++i==M) break;
		}
		System.out.println(s.size()==d.size()?"dosu":(s.size()>d.size()?"su":"do"));
	}
}
