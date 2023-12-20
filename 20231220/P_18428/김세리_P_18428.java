package _20231220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18428_감시피하기 {
    static int N;
    static String[][] map;
    static Queue<int[]> teachers= new LinkedList<>();
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) {
                    teachers.add(new int[]{i, j});
                }
            }
        }

        obstacles(0, 0);
        if(found) System.out.println("YES");
        else System.out.println("NO");
    }

    static void obstacles(int start, int count) {
        if (count == 3) {
        	// 학생이 감시되었을 때 check는 false
        	// 아닐때 true-> 감시를 피할 수 있다
            if (check()) {
            	//장애물이 3개이고 피할 수 있을 때만 found를 true로 변경
                found = true;
            }
            return;
        }
        // 장애물 설치할 수 있는 위치 모두 탐색
        for (int i=start; i<N*N; i++) {
            int x = i/N; //행
            int y = i%N; //열

            if (map[x][y].equals("X")) {
            	//장애물 설치 가능하므로 설치
                map[x][y] = "O";
                //다음 장애물 설치
                obstacles(i+1, count+1);
                map[x][y] = "X";
            }
            if (found) return;
        }
    }

    static boolean check() {
        for (int[] teacher : teachers) {
        	//현재 감시하는 선생님의 위치를 하나씩 가져온다
            for (int d = 0; d < 4; d++) {
            	// 네 방향으로 하나씩 감시해서 걸리는 학생이 있는지 본다
                if (!isSafe(teacher[0], teacher[1], d)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isSafe(int x, int y, int dir) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while (x>=0 && x<N && y>=0 && y<N) {
            if (map[x][y].equals("S")) {
            	//학생 만나면 false
                return false;
            }
            if (map[x][y].equals("O")) {
            	//장애물 만나면 막히는 거니까 그 이후에 볼 필요 없음
                break;
            }
            x += dx[dir];
            y += dy[dir];
        }
        return true;
    }
}
