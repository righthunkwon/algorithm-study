package _20231227;

import java.util.*;
import java.io.*;

public class _5427_불 {
    static int w, h, time;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            visited = new boolean[h][w];
            Queue<int[]> fireq = new LinkedList<>();
            Queue<int[]> playerq = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = s.charAt(j);
                    if (arr[i][j] == '*') {
                    	// 불의 위치를 queue에 저장한다
                    	fireq.add(new int[]{i, j});
                    } else if (arr[i][j] == '@') {
                    	// 상근이 위치를 queue에 저장하고, visited를 true로 한다
                    	playerq.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            time = 0;
            boolean escaped = false;
            // 상근이의 위치 queue가 비거나 탈출에 성공하면 while문은 끝난다
            out: while (!playerq.isEmpty()) {
            	// 문제에서 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 상근이는 이동할 수 없다고 하였으므로
            	// 불의 이동을 먼저 계산해야 한다
            	
            	// 불이 4방면으로 퍼진걸 계산해서 다시 queue에 넣어준다
                int fireSize = fireq.size();
                for (int i = 0; i < fireSize; i++) {
                    int[] fire = fireq.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = fire[0] + dr[dir];
                        int nc = fire[1] + dc[dir];
                        if (nr>=0 && nr<h && nc>=0 && nc<w && arr[nr][nc] == '.') {
                            arr[nr][nc] = '*';
                            fireq.add(new int[]{nr, nc});
                        }
                    }
                }
                
                // 상근이의 위치를 꺼내서 이동을 반영해준다
                int playerSize = playerq.size();
                for (int i = 0; i < playerSize; i++) {
                    int[] player = playerq.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = player[0] + dr[dir];
                        int nc = player[1] + dc[dir];
                        
                        // arr 배열 범위 내에 상근이가 없으면 탈출에 성공한 것이므로
                        // 시간을 추가해주고 탈출을 성공으로 바꿔주고 빠져나온다
                        if (nr<0 || nr>=h || nc<0 || nc>=w) {
                            time++;
                            escaped = true;
                            break out;
                        }
                        // 상근이가 이동할 수 있는 위치가 있다면 이동하고 그 위치를 다시 queue에 넣는다
                        // 이 때 더이상 이동할 공간이 없으면 playerq에 집어넣을 것이 없으므로
                        // while 문이 종료된다
                        if (nr>=0 && nr<h && nc>=0 && nc<w && arr[nr][nc] == '.' && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            playerq.add(new int[]{nr, nc});
                        }
                    }
                }
                // 탈출 못했으면 시간을 늘리고 다시 반복한다
                if (!playerq.isEmpty()) time++;
            }//while

            if (escaped) System.out.println(time);
            else System.out.println("IMPOSSIBLE");
        }
    }
}
