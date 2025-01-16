import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    public static class now implements Comparable<now>{
        int x;
        int y;
        int count;
        int nex;
        public now(int x, int y, int count, int nex) {
            super();
            this.x = x;
            this.y = y;
            this.count = count;
            this.nex = nex;
        }
        @Override
        public int compareTo(now o) {
            // TODO Auto-generated method stub
            if(this.count>o.count) {
                return 1;
            }
            else if(this.count==o.count) {
                return this.nex-o.nex;
            }
            return -1;
        }

    }
        static int n, m, sx, sy, fx, fy, ansa, ansb;
        static PriorityQueue<now> pq;
        static String[] arr;
        static boolean[][] flag;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        // S는 형택이와 여자친구의 데이트 시작장소를, F는 꽃이 있는 위치, g는 쓰레기가 있는 위치, .은 깨끗한 위치
        // 한번에 한칸 씩 가로나 세로로 움직일 수 있다.

        // 만약 되도록 적게 지나가는 경우의 수가 여러개라면, 쓰레기 옆을 지나가는 칸의 개수를 최소화
        // 출발지점과 꽃 지점은 쓰레기 주변으로 인식안함!


        // 푸는 방법
        // 쓰레기를 가장 적게 밟은 것 중에 적게 옆을 지나간 횟수의 위치를 큐에서 꺼내고
        // 주변 탐색 후 이동할 칸에 쓰레기가 유뮤에 따라 카운트 증가시켜 큐에 넣기
        //꽃 볼때까지 진행

            // 입력 받기
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();  // 개행문자 처리
            arr = new String[n];
            flag = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    if (arr[i].charAt(j) == 'F') {
                        fx = i;
                        fy = j;
                    } else if (arr[i].charAt(j) == 'S') {
                        sx = i;
                        sy = j;
                    }
                }
            }

            // 시작점 큐에 삽입
            pq = new PriorityQueue<>();
            pq.add(new now(sx, sy, 0, 0));

            bfs();
            System.out.println(ansa + " " + ansb);
        }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
        private static void bfs() {
            while (!pq.isEmpty()) {
                now next = pq.remove();

                // 방문한 곳은 skip
                if (flag[next.x][next.y]) {
                    continue;
                }
                flag[next.x][next.y] = true;
                
                
                    for (int i = 0; i < 4; i++) {
                    int x1 = next.x + dx[i];
                    int y1 = next.y + dy[i];

                    // 유효한 범위인지 체크
                    if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || flag[x1][y1]) {
                        continue;
                    }

                    // 목표 지점에 도달하면 결과 저장하고 종료
                    if (x1 == fx && y1 == fy) {
                        ansa = next.count;
                        ansb = next.nex;
                        return;
                    }

                    // 쓰레기 위치일 경우
                    if (arr[x1].charAt(y1) == 'g') {
                        pq.add(new now(x1, y1, next.count + 1, next.nex));
                    } else {
                        boolean flag = true;

                        // 주변에 쓰레기가 있는지 확인
                        for (int j = 0; j < 4; j++) {
                            int x2 = x1 + dx[j];
                            int y2 = y1 + dy[j];
                            if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) {
                                continue;
                            }
                            if (arr[x2].charAt(y2) == 'g') {
                                pq.add(new now(x1, y1, next.count, next.nex + 1));
                                flag = false;
                                break;
                            }
                        }

                        // 쓰레기 근처가 아니라면
                        // 큐에 넣고 다시 진행
                        if (flag)
                            pq.add(new now(x1, y1, next.count, next.nex));
                    }
            }
        }
}
}
