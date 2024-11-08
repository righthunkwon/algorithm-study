class Solution {
    public int solution(int n) {
        int answer = 0;
        //false 면 소수, true면 소수아님
        boolean[]isPrime = new boolean [n+1];
        
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(!isPrime[i]){
                int num = i;
                num+=i;
                while(num<=n){
                    isPrime[num]=true;
                    num+=i;
                }
            }
        }
        
        for(int i=2;i<=n;i++){
            if(!isPrime[i])answer++;
        }
        
        return answer;
    }
}
