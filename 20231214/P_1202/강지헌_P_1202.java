import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		List<je> J=new ArrayList<>();
		List<Integer> B=new ArrayList<>();
		PriorityQueue<Integer> Q=new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			J.add(new je(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int i=0;i<k;i++) B.add(Integer.parseInt(br.readLine()));
		Collections.sort(B);
		Collections.sort(J,(o1,o2) -> {
			return o1.w-o2.w;
		});
		int t=0;
		long ans=0;
		for(int i:B) {
			while(t<n && J.get(t).w<=i) Q.add(J.get(t++).p);
			if(!Q.isEmpty()) ans+=Q.poll();
		}
		System.out.println(ans);
	}
}

class je{
	int w,p;
	public je(int w, int p){
		this.w=w;
		this.p=p;
	}
}
