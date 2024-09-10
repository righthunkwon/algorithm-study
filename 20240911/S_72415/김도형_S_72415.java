import java.util.*;
import java.io.*;
class Solution {
    
    static int[]dr={-1,0,1,0};
    static int[]dc={0,1,0,-1};
    static int answer,n,R,C;
    static int order[][];
    static int map[][];
    static boolean used[];
    static Map<Integer,int[][]>card; //각 숫자카드의 위치 저장하는 맵
    public int solution(int[][] board, int r, int c) {
        card = new HashMap<>();
        answer = Integer.MAX_VALUE;
        n=0; //카드 쌍의 갯수
        R=r;
        C=c;
        map=board;
        
        //숫자카드 쌍의 위치 저장하기
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j]==0)continue;
                //처음 등장한 숫자카드
                if(!card.containsKey(board[i][j])){
                    card.put(board[i][j],new int[2][2]);
                    card.get(board[i][j])[0][0]=i;
                    card.get(board[i][j])[0][1]=j;
                    n++;
                }else{//등장했던 카드면 2번째에 저장
                    card.get(board[i][j])[1][0]=i;
                    card.get(board[i][j])[1][1]=j;
                }
            }
        }
        
        order = new int[2*n][];
        used = new boolean[n+1];
        dfs(0); 
        
        return answer;
    }
    
    //카드 뒤집을 순서 구하기
    public static void dfs(int depth){
        if(depth==n){
            answer = Math.min(answer,findCard());
            return;
        }
                
        for(int i=1;i<=n;i++){
            if(used[i])continue;
            used[i]=true;
            //i번 숫자 첫카드->두번째카드 
            order[depth*2]=card.get(i)[0];
            order[depth*2+1]=card.get(i)[1];
            dfs(depth+1);
            //i번 숫자 두번째 카드 -> 첫카드
            order[depth*2]=card.get(i)[1];
            order[depth*2+1]=card.get(i)[0];
            dfs(depth+1);
            used[i]=false;
        }
    }//dfs
    
    //bfs로 order에 맞게 카드를 뒤집는 최단 비용 계산
    public static int findCard(){
        // map 복사 (뒤집은 카드 0으로 만들어야하니까)
		int[][] copy = new int[4][4];
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				copy[i][j] = map[i][j];
            }
        }
        
        int[]start = {R,C,0};
        int cost = 0; //조작횟수 누적용
        
        for(int[]next : order){
            Queue<int[]>q = new ArrayDeque<>();
            boolean[][]visited = new boolean[4][4];
            q.add(start);
            visited[start[0]][start[1]]=true;
            
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int w = cur[2];
                
                //목표 카드 위치에 도착했으면 1더해주고(enter입력)하고 cost에 더해줌
                if(r==next[0]&&c==next[1]){
                    cost += w+1;
                    copy[r][c]=0; //카드 뒤집기
                    break;
                }
                
                //일반 커서 이동
                for(int i=0;i<4;i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];                
                    if(nr<0||nc<0||nr>=4||nc>=4)continue;
                    if(visited[nr][nc])continue;
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc,w+1});
                }
                
                //ctrl 커서 이동
                for(int i=0;i<4;i++){
                    int nr = r;
                    int nc = c;
                    
                    while(true){
                        //경로에 카드가 없으면
                        if (nr + dr[i] < 0 || nc + dc[i] < 0 || nr + dr[i] >= 4 || nc + dc[i] >= 4) {
							              if (!visited[nr][nc]) {
								              visited[nr][nc] = true;
								              q.offer(new int[] { nr, nc, w + 1 });
						          	    }
							              break;
						            }
                        
                        nr+=dr[i];
                        nc+=dc[i];
                        
                        //카드 만나면
                        if(copy[nr][nc]!=0){
                            if(visited[nr][nc])break;
                            visited[nr][nc]=true;
                            q.add(new int[]{nr,nc,w+1});
                            break;
                        }
                        
                    }
                    
                }
                 
            }
            
            //목표 좌표에 도착했으니 다시 거기서 출발
            start[0]=next[0];
            start[1]=next[1];
            start[2]=0;
            
            
        }//for order
        
        return cost;
        
        
        
    }//findCard
    
}
