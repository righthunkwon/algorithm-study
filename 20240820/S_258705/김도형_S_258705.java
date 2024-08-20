class Solution {
    public int solution(int n, int[] tops) {
        
        int MOD = 10007;
        
        int []dp1 = new int[n+1]; //역삼각형+오른쪽정삼각형 마름모 사용
        int []dp2 = new int[n+1]; //그 외 경우
        
        dp1[0]=0;
        dp2[0]=1;
        
        for(int i=1;i<=n;i++){
            dp1[i]= (dp1[i-1]+dp2[i-1])%MOD;
            if(tops[i-1]==1){ //이번 차례에 위쪽정삼각형 있으면
                dp2[i]= (dp1[i-1]*2 + dp2[i-1]*3)%MOD;
            }else{
                dp2[i]= (dp1[i-1] + dp2[i-1]*2)%MOD;
            }
        }
        
       
        return (dp1[n]+dp2[n])%MOD;
    }
}
