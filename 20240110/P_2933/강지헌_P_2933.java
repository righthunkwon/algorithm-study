
import java.io.*;
import java.util.*;
public class Main {
    static char map[][];
    static int[][] arr;
    static int R, C, N, dx[] = {0,0,-1,1}, dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0;i<R;i++) map[i]=br.readLine().toCharArray();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int t = Integer.parseInt(st.nextToken());
            if(i%2 == 0) {
                for(int j=0;j<C;j++) {
                    if(map[R-t][j] =='x') {
                        map[R-t][j] = '.';
                        break;
                    }
                }
            }
            else {
                for(int j=C-1;j>=0;j--) {
                    if(map[R-t][j] == 'x') {
                        map[R-t][j] = '.';
                        break;
                    }
                }
            }
            arr = new int[R][C];
            int cnt = 1;
l:          for(int ii=0;ii<R;ii++){
                for(int j=0;j<C;j++){
                    if(map[ii][j] == 'x' && arr[ii][j] == 0){
                        if(find(ii,j,cnt)) break l;
                    }
                    cnt++;
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++) System.out.print(map[i][j]);
            System.out.println();
        }
    }
    private static boolean find(int row, int col, int cnt) {
        int min = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> list = new ArrayList<>();
        queue.add(new Node(row,col));
        arr[row][col] = cnt;
        while(!queue.isEmpty()){
            Node t = queue.poll();
            min = Math.max(min, t.x);
            for(int d=0;d<4;d++){
                int nx = t.x + dx[d], ny = t.y + dy[d];
                if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
                if(arr[nx][ny] == 0 && map[nx][ny] == 'x'){
                    arr[nx][ny] = cnt;
                    queue.add(new Node(nx,ny));
                }
            }
            list.add(t);
        }
        if(min != R-1){
            dm(list);
            return true;
        }
        return false;
    }
    private static void dm(ArrayList<Node> list) {
        int d = 1;
        for(Node i : list) map[i.x][i.y] = '.';
tt:     while(true) {
            for(Node i : list) {
                if(i.x + d == R || map[i.x+d][i.y] =='x') {
                    d--;
                    break tt;
                }
            }
            d++;
        }
        for(Node i : list) {map[i.x+d][i.y] = 'x';}
    }
}
class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
