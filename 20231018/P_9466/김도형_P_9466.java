package AlgoStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q9466_텀_프로젝트 {

	static int n; //학생의 수
	static boolean visit[]; // 방문 확인용
	static int order[][]; // 연결 됐는지 확인용..
	static int[] arr; // 희망 팀원 배열
	static int teamFail; //팀에 속하지 못한 학생 수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //테케 수 입력

		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine()); //학생 수 입력
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			//학생 번호와 인덱스 맞추기 위해 배열 크기 n+1로 만듦
			arr = new int[n + 1]; 
			visit = new boolean[n + 1]; // 방문확인용 배열 초기화
			order = new int[2][n + 1]; // order[0][] => 어디서 처음 시작한 탐색인지  / order[1][] => 이번 탐색 내에서 몇번째 학생인지
			teamFail = 0; //조 못이루는 학생 수

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); //희망 팀원 배열 입력
			}
			//입력 끝
			
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {  // 한번 visit 처리된 학생은 다시 보지 않는다
					dfs(i, 0, i);  
				}
			}

			System.out.println(teamFail);

		}

	}// main

	

	
	// num : 학생 번호 / count : 현재탐색 내에서 몇번째 학생 탐색중인지 / idx는 처음 탐색 시작위치! 중복될수 없고 해당 탐색 도중 변하지 않음
	public static void dfs(int num, int count, int idx) {

		if (visit[num]) { //방문한적 있으면..

			if (order[0][num] == idx) { // 방문했던 곳인데, 이번 탐색에 해당하면 한바퀴 돌아온 것
				teamFail += order[1][num] ; // 조 이룰 수 없는 친구들 카운트

			} else { //방문했던 곳인데, 이번 탐색에 해당하지 않을 경우
				teamFail += count ; // 이번 탐색에 포함된 애들은 다 조 이룰 수 없는 친구들
			}

		}else { //처음 방문하는거면
			
			visit[num] = true; //방문처리하고
			order[0][num] = idx; //이번 탐색의 시작위치 입력
			order[1][num] = count; //이번 탐색의 몇번째 학생에 해당하는지 입력

			dfs(arr[num], count + 1,idx); 
		}
		

	}// dfs

}// class
