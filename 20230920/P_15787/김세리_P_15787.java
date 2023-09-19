import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _15787_기차가어둠을헤치고은하수를 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int order[]=new int[3];
		int train[][]=new int[N+1][20+1];
		boolean visited[]=new boolean[20+1];
		
		//명령 M번 반복한다
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//명령배열에서 첫번째 값이 1,2 일땐 세번째 수도 있다
			order[0]=Integer.parseInt(st.nextToken());
			order[1]=Integer.parseInt(st.nextToken());
			if(order[0]==1||order[0]==2)
				order[2]=Integer.parseInt(st.nextToken());
			
			//if문을 통해 각각 명령일 때 주어진 명령을 수행한다
			if(order[0]==1 && train[order[1]][order[2]]==0)
				train[order[1]][order[2]]=1;
			if(order[0]==2 && train[order[1]][order[2]]==1)
				train[order[1]][order[2]]=0;
			if(order[0]==3) {
				for(int j=20;j>=2;j--) {
					train[order[1]][j]=train[order[1]][j-1];
				}
				train[order[1]][1]=0;
			}
			if(order[0]==4) {
				for(int j=1;j<=19;j++) {
					train[order[1]][j]=train[order[1]][j+1];
				}
				train[order[1]][20]=0;
			}
		}//M
		
		//HashSet을 이용해서 중복을 판단한다
		Set<String>set = new HashSet<>();
		for(int i=1;i<=N;i++) {
			String tmp ="";
			for(int j=1;j<21;j++) {
				if(train[i][j]==1) tmp+='1';
				tmp+='0';
			}
			set.add(tmp);
		}
		System.out.println(set.size());
	}//main

}

