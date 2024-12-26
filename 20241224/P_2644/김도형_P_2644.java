import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_2644_촌수계산 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //전체 사람 수
        int[][] arr = new int[n+1][n+1];
        int[] dist = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        
        //bfs로 거리를 start에서 end까지의 거리를 구하고, 이어져있지 않으면 -1출력
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int tmp = q.poll();

            if(tmp == end) break;

            for(int i=1; i<=n; i++){
                if(arr[tmp][i]==1 && dist[i]==0){ 
                    q.add(i);
                    dist[i] = dist[tmp]+1;
                }
            }
        }
        int ans = -1;
        if(dist[end]!=0)ans = dist[end];
        System.out.println(ans);
    }
}
