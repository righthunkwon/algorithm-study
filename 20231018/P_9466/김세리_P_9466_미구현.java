package _20231018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9466_텀프로젝트2 {
	// 시간초과 난 코드임
	static int n;
	static int[] stu;
	static int cnt; // 프로젝트 팀에 속한 학생들 카운트
	static boolean[] visited;
	static boolean[] finish;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			stu = new int [n+1];
			visited = new boolean [n+1];
			finish = new boolean [n+1];
			String st = br.readLine();
			
			for(int i=1;i<n+1;i++) {
				stu[i] = Integer.parseInt(st.split(" ")[i-1]);
//				if(stu[i]==i) stu[i]=0; cnt++;
			} //입력끝
			
			cnt=0;
			 
			for(int i=1;i<n+1;i++) {
				if(!finish[i])	dfs(i);
			}
			System.out.println(n-cnt);
		}//T
		

	}//main
	static void dfs(int x) {
		visited[x] = true; // 방문 체크
		int next = stu[x]; // 다음 사람
		if(!visited[next]) {
			dfs(next);
		} else if(!finish[next]) {
			for(int i=next;i!=x;i = stu[i]) {
				cnt++;
			}
			cnt++;
		}
		finish[x]=true;
		
	}//dfs
	
	
	

}
