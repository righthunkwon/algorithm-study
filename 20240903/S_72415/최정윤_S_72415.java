import java.io.*;
import java.util.*;
//중복코드 많은데 손대기 무섭다,,
//먼저 카드 숫자 순서를 순열로 만들기
//그 카드 숫자중에서도 N-1,N-2번을 정하고 최소를 찾아야함 ,,
//가까운 것부터 가면 틀림 ,,
//dfs 통해서 순열 후 
//dfs통해서 N-1부터 갈건지 N-2부터 갈건지 정하고
//bfs 돌리기로 ... 하긴 했음 
class Solution {
    static int r, c, min;
    static int[] turn,dr,dc;
    static boolean[] s_visited,card;
    static Queue<Cursor> q;
    static int[][] board;
    static boolean[][] visited;
    static List<Cursor>[] number;
    static class Cursor{
        int r,c,depth;
        public Cursor(int r,int c,int depth){
            this.r=r;
            this.c=c;
            this.depth=depth;
        }
    }
    public int solution(int[][] board, int r, int c) {
        //4*4, 키의 최솟값=> bfs로 접근
        //방문배열에 관한 문제...
        //선택순서를 조합으로 만들어놓고 접근? 6!
        this.board=board;
        this.r=r;
        this.c=c;
        dr=new int[]{-1,1,0,0};
        dc=new int[]{0,0,-1,1};
        card=new boolean[7];
        int cnt=0;
        min=Integer.MAX_VALUE;
        number=new ArrayList[7];
        for(int i=1;i<7;i++){
            number[i]=new ArrayList();
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j]!=0) {
                    card[board[i][j]]=true;
                    number[board[i][j]].add(new Cursor(i,j,0));
                    cnt++;
                }
            }
        }
        
        turn=new int[cnt/2];
        s_visited=new boolean[7];
        select(0);    
        int answer = min+cnt ;
        return answer;
    }

    public static void select(int sidx){
        if(sidx>=turn.length){
            // System.out.println("배열"+Arrays.toString(turn));
            //순서대로 bfs 돌려보자
            dfs(0,0,r,c);
            return;
        }
        for(int i=1;i<7;i++){
            if(!card[i])continue;
            if(s_visited[i])continue;
            turn[sidx]=i;
            s_visited[i]=true;
            select(sidx+1);
            s_visited[i]=false;
        }
    }
    public static void dfs(int idx,int sum,int nr,int nc){//dfs를 통해 bfs로 가는 것 ...
        if(idx>=turn.length){
            min=Math.min(sum,min);
            return;
        }
        Cursor c1=number[turn[idx]].get(0);
        Cursor c2=number[turn[idx]].get(1);
        //출발지-> 1-1번 접근 ->1-2번 접근
        int count=0;
        q=new LinkedList();
        visited=new boolean[board.length][board[0].length];
        visited[nr][nc]=true;
        q.add(new Cursor(nr,nc,0));
        //bfs로 출발지 ->N-1 최단거리 측정
        Cursor curr= bfs(c1);
        count+=curr.depth;
        q=new LinkedList();
        visited=new boolean[board.length][board[0].length];
        visited[c1.r][c1.c]=true;
        q.add(new Cursor(c1.r,c1.c,0));
        //bfs로 N-1->N-2 최단거리 측정
        curr= bfs(c2);
        count+=curr.depth; 
        //카드 없애기
        board[c1.r][c1.c]=0;
        board[c2.r][c2.c]=0;
        
        dfs(idx+1,sum+count,c2.r,c2.c);
        //카드 다시 생성
        board[c1.r][c1.c]=turn[idx];
        board[c2.r][c2.c]=turn[idx];
        //출발지-> 1-2번 접근 ->1-1번 접근
        count=0;
        q=new LinkedList();
        visited=new boolean[board.length][board[0].length];
        visited[nr][nc]=true;
        q.add(new Cursor(nr,nc,0));
        //bfs로 출발지 ->N-2 최단거리 측정
        curr= bfs(c2);
        count+=curr.depth;
        q=new LinkedList();
        visited=new boolean[board.length][board[0].length];
        visited[c2.r][c2.c]=true;
        q.add(new Cursor(c2.r,c2.c,0));
        //bfs로 N-2->N-1 최단거리 측정
        curr= bfs(c1);
        board[c1.r][c1.c]=0;
        board[c2.r][c2.c]=0;
        count+=curr.depth;    
        
        dfs(idx+1,sum+count,c1.r,c1.c);
        
        board[c1.r][c1.c]=turn[idx];
        board[c2.r][c2.c]=turn[idx];
    }

    public static Cursor bfs(Cursor find){
        while(!q.isEmpty()){ 
            Cursor curr=q.poll();
            if(curr.r==find.r&&curr.c==find.c){ //선택해야하는 카드라면
                return curr;
            }
            //상하좌우
            for(int i=0;i<4;i++){
                int nr=curr.r+dr[i];
                int nc=curr.c+dc[i];
                if(nr<0||nc<0||nr>=4||nc>=4||visited[nr][nc])continue;
                q.add(new Cursor(nr,nc,curr.depth+1));
                visited[nr][nc]=true;
            }
            //컨트롤 상하좌우
            for(int i=0;i<4;i++){
                int nr=curr.r;
                int nc=curr.c;
                while(true){
                    nr+=dr[i];
                    nc+=dc[i];
                    if(nr<0||nc<0||nr>=4||nc>=4){
                        nr-=dr[i];
                        nc-=dc[i];
                        if(!visited[nr][nc]){
                            q.add(new Cursor(nr,nc,curr.depth+1));
                            visited[nr][nc]=true;
                        }
                        break;
                    }
                    if(board[nr][nc]!=0){
                        if(!visited[nr][nc]){
                            q.add(new Cursor(nr,nc,curr.depth+1));
                            visited[nr][nc]=true;
                        }
                        break;
                    }
                }
            }
            
            
        }
        return null;
    }
}
