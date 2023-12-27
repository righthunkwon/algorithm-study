package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q2116_주사위_쌓기 {
	
	static int opposite_side[] = {5,3,4,1,2,0}; //반대편의 인덱스 저장(0-5, 1-3, 2-4)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //주사위 수
		
		int dices[][]=new int[N][6]; //주사위정보 저장용 배열
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++){
				dices[i][j]=Integer.parseInt(st.nextToken());
			}
		} //입력 끝
		
		int ans = 0;
		
		for(int i=0;i<6;i++) { //A,B,C,D,E,F 가 윗면일 경우 1번씩
			
			int total = 0;
			
			int idx=0; //첫번째 주사위부터..
			int downside=dices[idx][i]; //1층의 i번째 면이 맨 아랫면일 경우
			int upside=dices[idx][opposite_side[i]];
			boolean[][]visit = new boolean[N][7]; //윗면 아랫면이 되는 것만 true처리 해서 false중 가장 큰 거 더해주기
			visit[idx][downside]=true;
			visit[idx][upside]=true; //1층 윗면
			
			idx++;//다음 층 확인
			
			while(idx<N) {
				for(int x=0;x<6;x++) {
					if(dices[idx][x]==upside) {//아래층 주사위의 윗면과 같은 숫자가 이제 현재층의 아랫면이 됨
						downside=dices[idx][x];
						upside=dices[idx][opposite_side[x]];
						visit[idx][downside]=true;
						visit[idx][upside]=true; //1층 윗면
						break;
					}
				}
				idx++; //한층 위에 주사위로 이동
			}
      
			for(int j=0;j<N;j++) {
				for(int k=6;k>0;k--) { //각 층별로 visit이 false인 가장 큰 수만 더해줌
					if(!visit[j][k]) {
						total+=k; 
						break;
					}
				}
			}
			ans = Math.max(ans, total);
		}
		
		System.out.println(ans);
		
		
	}
}
