import java.util.*;

class Solution {
    static class node implements Comparable<node> {
        int num;
        int x;
        int y;
        class node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;            
        }
        public int compareTo(node o){
            this.num - o.num;
        }
    }
    static PriorityQueue<node> pq = new PriorityQueue<node>();
    static int[][] board;
    static int r;
    static int c;
    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        // 카드 두장 뒤집어서 2개가 같으면 사라지고
        // 틀리면 다시 원래대로 뒤집음 
        
        // 하나에서 시작해서 dfs를 통해서 그림 순서를 정하고
        // 현재위치에서 그림지점까지 모든 좌표의 번호를 큐랑 리스트에다가 넣는다.
        // 큐에서는 각 지점마다 두개 카드의 움직임 개수를 구해서 넣어놓고 
        // 정해진 카드 순서마다 리스트에서 좌표를 뽑아 계산
        // 최소값 갱신방법으로...
        this.board = board;
        this.r = r;
        this.c = c;
        for(int i = 0;i<board.lenght;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] >0){
                    // 카드 발견하면 그대로 큐에 넣기
                    pq.add(new node(board[i][j] , i, j));
                }   
            }
        }
        
        return answer;
    }
}
