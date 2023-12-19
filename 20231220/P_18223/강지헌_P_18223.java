import java.io.*;
import java.util.*;

public class Main {
	static List<int[]>[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		map=new List[n+1];
		for(int i=0;i<=n;i++) map[i]=new LinkedList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			map[a].add(new int[]{b,w});
			map[b].add(new int[]{a,w});
		}
		if(di(1,n,n)==di(1,c,n)+di(c,n,n)) System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
	}
	
	private static int di(int st, int en,int v) {
		boolean[] chk=new boolean[v+1];
		int[] di=new int[v+1];
		Arrays.fill(di,987654321);
		di[st]=0;
		for(int i=1;i<=v;i++){
			int min=987654321,t=0;
			for(int j=1;j<=v;j++){
				if(!chk[j] && min>di[j]){
					t=j;
					min=di[j];
				}
			}
			chk[t]=true;
			if(t==en) return di[t];
			for(int[] n:map[t]) if(!chk[n[0]] && di[n[0]]>min+n[1]) di[n[0]]=min+n[1];
		}
		return -999;
	}
}
