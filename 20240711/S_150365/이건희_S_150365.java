// 미로 라고는 하지만 장애물이 없다
// 미로의 크기가 최대 2500칸 
// k가 최단 경로 보다 크게 주어질 수 도 있어 보인다 모든 범위로 bfs 이동을 하되 k칸 이내로만 이동하게 설정
// 이동거리 k 만큼 이동을 해서 성공적으로 만들어진 모든 문자열을 한번에 비교 하는 것 보다 그때 그때 비교하는 함수를 만드는게 
// 효율적일 것 같다. 사실 큰 차이는 없어 보인다.
// 정답 문자열이 마지막까지 빈 문자열이면 "impossble" 출력
// 1,2차 BFS로 시도 했는데 계속 시간초과 발생해서 다시 고민해 보니
// 같은 장소 재방문이 가능하고, 이동 할 거리가 k로 정해져 있기 때문에 DFS로 변경해서 재시도
// 3차 시도 스택 기반 DFS로 진행 O(4^k)
// 맨해튼 거리라는 백트랙킹 조건 추가, 백트래킹 안해 주면 테케 1,2,9 ~ 31 에서 시간초과 발생
// 풀다보니 스택 큐 까지 쓸 필요도 없는 문제라는 생각이 들었다.
// 직접 경로를 작성하다보니 그리디로도 풀린다
// 4차시도 그리디
public class Solution {
    // 맨해튼 거리 계산 함수
    private int calcDist(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
        //     return "impossible";
        // }
        if ((k - calcDist(x, y, r, c)) % 2 != 0 || k < calcDist(x, y, r, c)) {
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();
        int move = 0;
        // 이동 우선 순위 => d l r u
        // 그러니까 전체 이동 코스에서 d랑 l을 최대한 앞에다 먼저 배치해야 한다.
        // 하단으로 최대한 댕기기
        while (x < n && (k - move) > calcDist(x, y, r, c)) {
            move++;
            x++;
            answer.append("d");
        }

        // 좌측으로 최대한 땡기기
        while (y > 1 && (k - move) > calcDist(x, y, r, c)) {
            move++;
            y--;
            answer.append("l");
        }
        // 맨하튼 거리 빼고 남은 k를 이걸로 태운다, 위치는 바뀌면 안되어서 우좌
        // Q. 왜 상하는 안되나?
        // 우좌 반복 이동
        while ((k - move) > calcDist(x, y, r, c)) {
            move += 2;
            answer.append("rl");
        }

        // 위치 조정
        if (x < r) answer.append("d".repeat(r - x));
        if (y > c) answer.append("l".repeat(y - c));
        if (y < c) answer.append("r".repeat(c - y));
        if (x > r) answer.append("u".repeat(x - r));
        return answer.toString();
    }
}

// 3차 시도 스택 기반 DFS로 진행 O(4^k)
import java.util.Stack;

class Solution {
    // private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 스택에서 팝 될거를 고려해서 순서를 역순 배열
    private static final int[] dx = {-1, 0, 0, 1}; // 상, 좌, 우, 하
    private static final int[] dy = {0, 1, -1, 0};
    private static final char[] dirChars = {'u', 'r', 'l', 'd'}; // 해당 방향을 문자로 매핑

    // 이동경로 관리 클래스 Path
    static class Path {
        int x, y, remainedDistance;
        String path; // 이동경로 문자열 저장

        Path(int x, int y, String path, int remainedDistance) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.remainedDistance = remainedDistance;
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 맨해튼 거리 기반으로 종료지점으로 k 안에 이동 가능 여부 체크
        if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
            return "impossible";
        }
        
        // 스택 기반으로 DFS 구현 을 위해 스택 선언, dfs-스택-bfs-큐
        Stack<Path> stack = new Stack<>();
        stack.push(new Path(x, y, "", k));

        while (!stack.isEmpty()) {
            Path current = stack.pop();
            
            if (current.remainedDistance == 0) {// 더 이동 못 하면
                if (current.x == r && current.y == c) {// 도착했는지 체크 하고, 도착했으면
                    return current.path;// 완성된 이동경로 문자열 반환
                    // 따로 경로 들 값 비교를 안해주는 이유는 스택에 추가되는 순서가 사전 역순으로 들어가므로
                    // 최초로 반환되는 이동경로 문자열이 사전 순으로 가장 빠른 문자열
                }
                continue;
            }
            // 도달 못 했으면 거리 -1 시키고 이제 각 방향으로 이동 시키기, 방향은 사전 순으로 가장 빠른 경로를 반환해야 하기에
            // 넣어 주는 순서가 중요
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int remaining = current.remainedDistance - 1;
                // 유효성 검증 - 범위 안인지, 목표지점까지 갈 수 있는지 체크 후
                // DFS 진행
                // 여기서 맨해튼 거리로 백트랙킹 안하면 시간 초과 발생
                if (isValid(n, m, nx, ny) && isAbleToArrive(remaining, r, c, nx, ny)) {
                    stack.push(new Path(nx, ny, current.path + dirChars[i], remaining));
                }
            }
        }

        return "impossible";
    }
    // 범위 벗어나는 것 방지하는 함수 - 깔끔하게 하고 싶어서 분리
    private boolean isValid(int n, int m, int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }
    // 맨해튼 거리 기반 도착 가능성 체크
    private boolean isAbleToArrive(int remainedDistance, int destX, int destY, int x, int y) {
        int manhattan = Math.abs(destX - x) + Math.abs(destY - y);
        return manhattan <= remainedDistance && (remainedDistance - manhattan) % 2 == 0;
    }
}

// 2차 시도, 우선순위 큐, bfs => 시간 초과
// 여기서 다시 생각해보니까 K만큼 가는게 고정이니 DFS+백트랙킹하는게 맞는게 아닌가 하는 생각이 들었다
import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
    private static String bestPath = null; // 사전 순으로 가장 작은 경로를 저장할 변수

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        bestPath = null; // 정적 변수 초기화
        if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
            return "impossible";
        }
        bfs(n, m, x, y, r, c, k);
        return bestPath == null ? "impossible" : bestPath;
    }

    private void bfs(int n, int m, int startX, int startY, int endX, int endY, int k) {
        PriorityQueue<PathState> queue = new PriorityQueue<>(Comparator.comparing(s -> s.path));
        queue.offer(new PathState(startX, startY, "", 0));

        while (!queue.isEmpty()) {
            PathState currentState = queue.poll();
            
            if (currentState.steps == k) {
                if (currentState.x == endX && currentState.y == endY) {
                    bestPath = currentState.path;
                    break;
                }
                continue;
            }

            for (int[] direction : DIRECTIONS) {
                int nextX = currentState.x + direction[0];
                int nextY = currentState.y + direction[1];
                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m) {
                    char moveChar = getDirectionChar(direction);
                    queue.offer(new PathState(nextX, nextY, currentState.path + moveChar, currentState.steps + 1));
                }
            }
        }
    }

    private char getDirectionChar(int[] direction) {
        if (direction[0] == -1 && direction[1] == 0) return 'u'; // up
        if (direction[0] == 1 && direction[1] == 0) return 'd'; // down
        if (direction[0] == 0 && direction[1] == -1) return 'l'; // left
        if (direction[0] == 0 && direction[1] == 1) return 'r'; // right
        return ' ';
    }

    static class PathState {
        int x, y, steps;
        String path;

        PathState(int x, int y, String path, int steps) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.steps = steps;
        }
    }
}
// 1차 시도, 큐, bfs => 시간초과
import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left
    private static String bestPath = null; // 사전 순으로 가장 작은 경로를 저장할 변수

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        bestPath = null; // 정적 변수 초기화
        if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
            return "impossible";
        }
        bfs(n, m, x, y, r, c, k);
        return bestPath == null ? "impossible" : bestPath;
    }

    private void bfs(int n, int m, int startX, int startY, int endX, int endY, int k) {
        Queue<PathState> queue = new LinkedList<>();
        queue.offer(new PathState(startX, startY, "", 0));

        while (!queue.isEmpty()) {
            PathState currentState = queue.poll();
            
            if (currentState.steps == k) {
                if (currentState.x == endX && currentState.y == endY) {
                    if (bestPath == null || currentState.path.compareTo(bestPath) < 0) {
                        bestPath = currentState.path;
                    }
                }
                continue;
            }

            for (int[] direction : DIRECTIONS) {
                int nextX = currentState.x + direction[0];
                int nextY = currentState.y + direction[1];
                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m) {
                    char moveChar = getDirectionChar(direction);
                    queue.offer(new PathState(nextX, nextY, currentState.path + moveChar, currentState.steps + 1));
                }
            }
        }
    }

    private char getDirectionChar(int[] direction) {
        if (direction[0] == -1 && direction[1] == 0) return 'u'; // up
        if (direction[0] == 0 && direction[1] == 1) return 'r'; // right
        if (direction[0] == 1 && direction[1] == 0) return 'd'; // down
        if (direction[0] == 0 && direction[1] == -1) return 'l'; // left
        return ' ';
    }

    static class PathState {
        int x, y, steps;
        String path;

        PathState(int x, int y, String path, int steps) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.steps = steps;
        }
    }
}