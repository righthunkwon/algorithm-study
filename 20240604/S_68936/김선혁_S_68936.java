class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        
        // 하나의 사각형을 기준으로 dfs 돌리면서
        // 4개로나눠서 1,2,3,4분면으로 게속 돌림
        answer = new int[2];
        // 첫번째는 0, 두번째는 1 개수 
        solve(arr,0,0, arr.length-1 ,arr[0].length-1);
        
        return answer;
        
    }
    public static void solve(int[][] arr, int stx,int sty, int enx, int eny) {
        
        int tmp = arr[stx][sty];
        boolean visited = true;
        
        
        a : for(int i = stx; i < enx+1; i++){
            for(int j = sty; j < eny+1; j++){
                if(arr[i][j] != tmp){
                    visited = false;
                    break a;
                }
            }
        }
        
        if(visited){
            if(tmp == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
            return;
        }
        
        solve(arr, stx, sty, (stx+enx)/2, (sty+eny)/2); // 1사분면
        solve(arr, stx, (sty+eny)/2+1,(stx+enx)/2, eny);
        solve(arr, (stx+eny)/2+1, sty, enx, (sty+eny)/2);
        solve(arr, (stx+enx)/2+1, (sty+eny)/2, enx, eny);
        
    }
}
