import java.io.*;
import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][]map = new char[m][n];
        for(int i=0;i<m;i++)map[i]=board[i].toCharArray();
        
        while(true){
            Queue<int[]>delete_blocks = new LinkedList<>(); //지울 블록 좌표 저장용
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(map[i][j]!='X'&&map[i][j]==map[i][j+1]&&map[i][j]==map[i+1][j]&&map[i][j]==map[i+1][j+1]){
                        delete_blocks.add(new int[]{i,j}); //지워질 4개 블록중 왼쪽 상단 블록 좌표 저장
                    }
                }
            }
            if(delete_blocks.isEmpty())break; //지워질 블록 없으면 끝내기
            
            //블록 지우기
            while(!delete_blocks.isEmpty()){
                int[]pos = delete_blocks.poll();
                int x = pos[0];
                int y = pos[1];
                if(map[x][y]!='X'){
                    map[x][y]='X';
                    answer++;
                }
                if(map[x+1][y]!='X'){
                    map[x+1][y]='X';
                    answer++;
                }
                if(map[x][y+1]!='X'){
                    map[x][y+1]='X';
                    answer++;
                }
                if(map[x+1][y+1]!='X'){
                    map[x+1][y+1]='X';
                    answer++;
                }
            }
            
            // 블록 내리기
            for (int j = 0; j < n; j++) { 
                for (int i = m - 1; i > 0; i--) { // 아래에서 위로 탐색
                    if (map[i][j] == 'X') { //빈 칸이면
                        // 위쪽에 있는 블록 찾기
                        int k = i - 1;
                        while (k >= 0 && map[k][j] == 'X') {
                            k--; // 가장 가까운 블록 위치 찾기
                        }
                        if (k >= 0) { // 블록을 찾았으면 교체
                            map[i][j] = map[k][j];
                            map[k][j] = 'X';
                        }
                    }
                }
            }

        }
        
        return answer;
    }
}
