import java.util.*;

public class Main {
	static int N;
	static int M;
	static String[][] arr;
	static int[][] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// U인 경우에는 (r-1, c)로 이동
		// R인 경우에는 (r, c+1)로 이동
		// D인 경우에는 (r+1, c)로 이동
		// L인 경우에는 (r, c-1)로 이동
		
		// 각모든 칸에서 시작했을 때 탈출 가능한지 확인
		// 모든 블럭을 실행마다 방문처리로 무한루프 안돌게
		arr = new String[N][M];
		flag = new int[N][M];
		
		for(int i = 0 ; i < N;i++) {
			String line = sc.next();
			for(int j = 0 ; j < M;j++) {
				arr[i][j] = line.substring(j,j+1);
				flag[i][j] = -1;
			}
		}
		
		int answer = 0;
		for(int i = 0 ; i< N;i++) {
			for(int j = 0 ;j<M;j++) {
				if(escape(i,j)) {
					answer++;
				}
			}
		}
		System.out.println(answer);
		
	}
	static boolean escape(int x , int y ) {
		// 범위 벗어나면 끝내고
		// flag에 각각 -1, 0, 1이 상태가
		// 방문 x , 방문했지만 정답x, 방문 + 정답일때를 담는다.
		if (x < 0 || x >= N || y < 0 || y >= M) {
            return true; 
        }
		// 아직 방문안했으면 방문처리한것으로 return
        if (flag[x][y] != -1) {
            return flag[x][y] == 1;
        }

        flag[x][y] = 0;

        int dir = direction(arr[x][y]);
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        // dfs를 통해서 해당 지점이 탈출할 수 있는지 확인하고
        // 탈출할 수 있으면 true 출력
        if (escape(nx, ny)) {
        	flag[x][y] = 1;
            return true;
        } else {
        	flag[x][y] = 0; 
            return false;
        }
	}
	
	
	
	
    static int[] dx = {-1, 0, 1, 0}; // U, R, D, L
    static int[] dy = {0, 1, 0, -1}; // U, R, D, L
    static int direction(String c) {
        if(c.equals("U")) {
        	return 0;
        }
        else if(c.equals("R")) {
        	return 1;
        }
        else if(c.equals("D")) {
        	return 2;
        }
        else {
        	return 3;
        }
    }
    
}
