class Solution {
    static boolean[] flag;
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        // n = 1일때 1 , 2일때 2 , 3일때 6 , 4일때 24 -> 6x4 이런식
        // 총개수의 경우에는 dp방식으로 증가하고 그 안에서 하나씩 찾으면 된다.
        long[] dp = new long[21];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <=20;i++){
            dp[i] = dp[i-1] * (long)i;
        }
        // 여기서 어디에 속하는지 확인해서 for문을 통해 들어가자
        flag = new boolean[n+1]; // 1~n까지 활용
        int index = 0;
        k--;
        while(true){
            long tmp = k/dp[n-1-index];
            k %= dp[n-1-index];
            // tmp개수번째에 있는 숫자가 index번째 들어갈 숫자임
            long cnt = 0;
            for(int i = 1;i<=flag.length;i++){
                if(!flag[i]){
                    if(cnt == tmp){
                        flag[i] = true;
                        answer[index++] = i;
                        break;
                    }
                    cnt++;
                }
            }
            if(index == n){
                break;
            }            
        }
        
        
        return answer;
    }
}
