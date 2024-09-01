class Solution {
    static int N;
    static int number;
    static int min;
    public int solution(int N, int number) {
        // 초기 수에서 dfs를 통해
        // number가 나올때의 최소값 리턴
        // 그 과정중에 8번 넘으면 -1 return하고
        // 방식중에 사칙연산 4개랑 n*10 + n하는 과정도 추가해서 구함
        min = 987654321;
        this.N = N;
        this.number = number;
        
        solve(0,0);
        if(min == 987654321){
            return -1;
        }
        return min;
    }
    public static void solve(int cnt, int nowNumber){
        // 8번이 넘거나 min보다 이미 크면 return
        if(cnt > 8 || cnt > min){
            return;
        }
        // 정답숫자 나오면 min 교체
        if(nowNumber == number){
            min = Math.min(min, cnt);
            return;
        }
        int tmp = N;
        // 만약 n이 5이면 5만 계산하는게 아닌 55를 이용해서 구할수도 있음
        for(int i = 0 ;i<8-cnt;i++){
            // tmp의 숫자가 5가 아니고 55일경우에 2개를 더해야해서
            solve(cnt+1+i, nowNumber + tmp);
            solve(cnt+1+i, nowNumber - tmp);
            solve(cnt+1+i, nowNumber * tmp);
            solve(cnt+1+i, nowNumber / tmp);
            // 4가지 과정 거친후에 
            // 해당 n이 2번쓰이는 경우도 계산
            tmp = tmp *10 + N;
        }
    }
    
}
