import java.util.*;

class Solution {
    static int[][] arr;
    
    public int solution(int n, int[][] wires) {
        int answer = 987654321;
        arr = new int[n+1][n+1];
        // 일단 모두 arr에 1로 기록하고
        // 하나씩 끊은 다음 dfs 돌아서 개수 세서
        // min값 갱신 하는 방향으로
        for(int i = 0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        // 이제 하나 끊자
        for(int i = 0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a][b] = 0;
            arr[b][a] = 0;
            
            int ans = solve(n,a);
            answer = Math.min(ans,answer);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        return answer;
    }
    public static int solve(int n, int st){
         int[] flag= new int[n+1];
        int cnt=1;
        
        Queue<Integer> q= new LinkedList<>();
        q.add(st);
        // 현재 시작점에서 이어지는 점들의
        // 개수를 count해서
        // 전체 점에서 이어지지 않은 선들과의 차를 return
        while(true){
            if(q.size() ==0){
                break;
            }
            int tmp= q.poll();
            flag[tmp]= 1;
            
            for(int i=1; i<=n; i++){ 
                if(flag[i]==1){
                 continue;
                }
                if(arr[tmp][i]==1) {
                    q.add(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt); 
    }
    
}
