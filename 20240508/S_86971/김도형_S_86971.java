import java.util.*;
import java.io.*;

class Solution {
    
    static int[][] arr; 
    public int solution(int n, int[][] wires) {
        int answer = 100; //n은 100이하니까
        
        arr = new int[n + 1][n + 1]; //인접 정보 저장
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        //전선 끊고 bfs 돌려서 답 갱신 후 다시 전선 복구
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;       
            answer = Math.min(answer, bfs(wires[i][0], n));
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }//solution
    
    public static int bfs(int st,int n){
         int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int i = 1; i < n + 1; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                }
            }
        }
        return Math.abs((2*cnt) - n);
    }//bfs
    
}
