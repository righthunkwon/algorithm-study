class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dfs(arr, 0, arr.length-1, 0, arr[0].length-1);
        return answer;
    }
    
    public void dfs(int[][] arr, int sx, int ex, int sy, int ey){
        int t = arr[sx][sy];
        boolean f = true;
        l:
        for(int i = sx; i < ex+1; i++) {
            for(int j = sy; j < ey+1; j++) {
                if(arr[i][j] != t) {
                    f = false;
                    break l;
                }
            }
        }
        if(f) {
            if(t == 0) answer[0]++;
            else answer[1]++;
            return;
        }
        dfs(arr, sx, (sx+ex)/2, sy, (sy+ey)/2);
        dfs(arr, sx, (sx+ex)/2, (sy+ey)/2+1, ey);
        dfs(arr, (sx+ex)/2+1, ex, sy, (sy+ey)/2);
        dfs(arr, (sx+ex)/2+1, ex, (sy+ey)/2+1, ey);
    }
}
