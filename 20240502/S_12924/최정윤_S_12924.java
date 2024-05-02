class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int st=1;st<=n;st++){ //시작 수
            int sum=st;
            int num=1;
            while(sum<=n){
                if(sum==n)answer++;
                sum+=st+num;
                num++;
                
            }
            
        }
        return answer;
    }
}
