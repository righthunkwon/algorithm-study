import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class _2638_치즈3 {
    static int N,M;
    static int [][] map, cheese;
    static boolean [][] visited;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M]; // 주어진 모눈종이 크기
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(st.nextToken()); // 주어진 입력값을 map 배열에 저장
            }
        } // 입력끝
        
        int time=0;
        
        while(true) {
            visited = new boolean[N][M]; //방문체크
            cheese = new int[N][M]; // 외부공기와 닿은 변의 개수 입력
            
            dfs();
            
            if(cheeseMelt()) break; // true이면 다 녹아서 없다는 소리
            
            time++; // false이면 치즈 남아있어서 시간 추가
        }
        System.out.println(time);
    }
    
    public static void dfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        
        // 0,0부터 queue에 넣고 차례대로 탐색한다
        // 이렇게 하면 밖에서부터 탐색하므로, 치즈에 막혀 내부공기 쪽으론 들어오지 않게 된다.
        
        queue.offer(new int[] {0,0}); // 0,0은 무조건 외부공기이니까 여기서부터 큐에 넣고 탐색 시작
        visited[0][0]=true; // 방문체크도 해준다
        
        while(!queue.isEmpty()) { // 큐가 빌때까지 돌린다(외부공기 모두 탐색해서 치즈가 공기와 접촉한 변의 수를 센다)
            int[] temp = queue.poll(); // 외부공기 하나를 큐에서 빼고 temp에 저장한다
            
            for(int i=0;i<4;i++) { // 사방탐색 시작
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];
                
                if(range(nx,ny) && !visited[nx][ny] ) { // 범위 함수를 밑에서 돌려서 범위 내에 있고, 아직 방문하지 않았을 경우 진행 
                    if(map[nx][ny]==0) { // map이 0이면 외부공기, 다시 queue에 넣고 방문체크해준다
                        queue.offer(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                    else { // 1이면 치즈가 외부공기와 닿아있단 소리이므로 치즈 배열에서 1추가해준다(외부공기 카운트)
                        cheese[nx][ny]++;
                    }
                }
            }
        }
    }
    
    public static boolean range(int x, int y) {
        return x>=0 && y>=0 && x<N && y<M;
    }
    
    public static boolean cheeseMelt() {
        
        int count=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(cheese[i][j]>1) { // 치즈배열 값이 1 이상이면 map 배열에서 0으로 바꾼다(녹아서 없어짐)
                    map[i][j]=0;
                }
                else count++; // 치즈배열 값이 0일 땐 카운트를 해준다
            }
        }
        
        if(count==N*M) return true; // 카운트 값이 전체 map 크기와 같으면 다 녹았단 의미
        else return false;
    }
}


// 풀이법 출처: https://javaju.tistory.com/51
