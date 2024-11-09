class Solution {
    public int solution(int n) {
        int answer = 0;
        // 먼저 각 소수마다 체크해놓고 
        // 입력되는 n을 기준으로 계산
        for(int i = 2 ; i<= n;i++){
            // 2부터 해당 수가 소수인지 확인하고
            // 만약 이 수가 소수라면 +1
            if(flag(i)){
                answer ++;
            }
        }
        
        
        
        return answer;
    }
    // 2부터 쭉 나눠지는수가 있는지 확인
    public static boolean flag(int n){
        for(int i = 2;i <= Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
}
