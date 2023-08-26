package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken()); // row 가로
		int C = Integer.parseInt(st.nextToken()); // col 세로
		int K = Integer.parseInt(br.readLine()); // 대기 번호
		// 달팽이 반시계방향으로 생각
		int[][] map = new int[C][L];
		int[][] delta = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} }; // 남동북서
		
		int p = 1; // 배정될 좌석 번호 1 ~ C*L
		int c = -1; // col 좌표 초기값
		int l = 0; // row 좌표 초기값
		int idx = 0; // delta 컨트롤용 0 : 남, 1 : 동, 2 : 북, 3 : 서
		int tmpC = C; // 세로 방향이 되면 하나씩 빼줄거야
		int tmpL = L; // 가로 방향이 되면 하나씩 뺴줄거야
		int resX = 0; // 결과값 저장
		int resY = 0;
		
		loop:
		while(p <= C * L) {
			if(idx == 0 || idx == 2) {
				for(int i = 0; i < tmpC; i++) {
					c = c + delta[idx][0];
                    l = l + delta[idx][1];
                    if(p == K) {
                    	resX = l + 1;
                    	resY = c + 1;
                    	break loop;
                    }
                    map[c][l] = p++;
				}
				tmpC--;
			}
			if(idx == 1 || idx == 3) {
				--tmpL;
				for(int i = 0; i < tmpL; i++) {
					c = c + delta[idx][0];
                    l = l + delta[idx][1];
                    if(p == K) {
                    	resX = l + 1;
                    	resY = c + 1;
                    	break loop;
                    }
                    map[c][l] = p++;
				}
			}
			idx = (idx + 1) % 4; // 방향 컨트롤러는 0 1 2 3 계속 돌아야하니
		}
		
		if(K > C * L) System.out.println(0);
		else {
			System.out.println(resX + " " + resY);
		}
		
//		// 출력 테스트
//		for(int i = 0; i < C; i++) {
//            for(int j = 0; j < L; j++) {
//                System.out.print(map[i][j]+ " ");
//            }
//            System.out.println();
//        }
	}
}
