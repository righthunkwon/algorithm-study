import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        
        // 최대숫자 구하기
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3;i<=1000;i++){
            dp[i] = i*i - dp[i-1];
        }
        
        // n=4 일때 4 3 2 1 
        // 5면 5 4 3 2 1
        int x = 0;
        int y = 0;
        // 한쪽으로 밀어서 직각 삼각형으로 생각해보면
        int number = 1;
        int index = 0; // 0~2까지 반복
        while(true){
            // 달팽이 모양으로 숫자로 세로, 가로, 왼쪽위 대각선 순으로 
            // 쭉 기록하면 직각삼각형완료
            answer[x][y] = number++;
            x += dx[index];
            y += dy[index];
            if(x>= n || y >= n || answer[x][y] !=0){
                x-= dx[index];
                y -= dy[index];
                index ++;
                if(index== 3){
                    index = 0;
                }
                x += dx[index];
                y += dy[index];
            }
            if(number > dp[n]){
                break;
            }
        }
        
//         for(int i = 0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(answer[i][j]+" ");
//             }
//             System.out.println();
            
//         }
        
        int[] ans = new int[dp[n]];
        int pos =0;
            int tmp = 1;
        for(int i = 0;i<n;i++){
            for(int j =0;j<tmp;j++){
                ans[pos++] = answer[i][j];
            }
            tmp++;
        }
        
        return ans;
    }
    // 순서는 세로, 가로 ,대각선 왼쪽위 이순서
    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,-1};
    
}
