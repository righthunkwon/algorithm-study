import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> li=new ArrayList<>();
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int ans=M;
		ArrayList<Integer>[] arr=new ArrayList[M];
		for(int i=0;i<M;i++) arr[i]=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		int p=Integer.parseInt(st.nextToken());
		Queue<Integer> Q=new LinkedList<>();
		for(int i=0;i<p;i++) li.add(Integer.parseInt(st.nextToken()));
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			p=Integer.parseInt(st.nextToken());
			for(int j=0;j<p;j++) arr[i].add(Integer.parseInt(st.nextToken()));
		}
		
		int[] pachk=new int[M];
		int[] pechk=new int[N+1];
		for(int i=0;i<li.size();i++) {
			Q.add(li.get(i));
			pechk[li.get(i)]=1;
		}
		while(!Q.isEmpty()) {
			int t=Q.poll();
			for(int i=0;i<M;i++) {
				if(pachk[i]==1) continue;
				if(!arr[i].contains(t)) continue;
				for(int j=0;j<arr[i].size();j++) {
					int next=arr[i].get(j);
					if(pechk[next]==1) continue;
					pechk[next]=1;
					Q.add(next);
				}
				pachk[i]=1;
				ans--;
			}
		}
		System.out.println(ans);
	}
}
