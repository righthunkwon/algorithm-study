class Solution {
    public int[][] solution(int n) {
        //1 1+1+1 3+1+3 7+1+7 =총개수
        int tot=1;
        for(int i=2;i<=n;i++){
            tot=tot+1+tot;
        }
        idx=0;
        answer = new int[tot][2];
        hanoi(n,1,3,2);
        return answer;
    
    }
    static int[][] answer;
    static int idx;
    //n=15이하 자연수니까 dp로 tot개수 계산해놓기
    
    public static void hanoi(int n, int start, int end, int mid){
        if(n==1){
            answer[idx][0]=start;
            answer[idx][1]=end;
            idx++;
            return;
        }
        hanoi(n-1,start, mid, end); //중간으로 n-1탑 쌓고
        answer[idx][0]=start;       //종료지점으로 젤 큰 원 옮기고
        answer[idx][1]=end;
        idx++;
        hanoi(n-1,mid,end,start);   //중간에서 종료지점으로 n-1탑 옮긴다
    }
}
