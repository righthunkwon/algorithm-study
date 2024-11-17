class Solution {
    public long solution(int[] sequence) {
        //한 개 1 -1 1 -1
        long answer = 0;
        int[] one=new int[sequence.length];
        for(int i=0;i<sequence.length;i++){
            if(i%2==0) one[i]=sequence[i];
            else one[i]=-sequence[i];
        }
        long[] dp=new long[one.length];
        dp[0]=one[0];
        answer=one[0];
        //앞에꺼에 누적해서 나를 더할지 새로 시작할지
        for(int i=1;i<one.length;i++){
            dp[i]=Math.max(one[i],dp[i-1]+one[i]);
            answer=Math.max(answer,dp[i]);
        }
        //한 개 -1 1 -1 1
        int[] two=new int[sequence.length];
        for(int i=0;i<sequence.length;i++){
            if(i%2==0) two[i]=-sequence[i];
            else two[i]=sequence[i];
        }
        dp=new long[two.length];
        dp[0]=two[0];
        answer=Math.max(two[0],answer);
        for(int i=1;i<two.length;i++){
            dp[i]=Math.max(two[i],dp[i-1]+two[i]);
            answer=Math.max(answer,dp[i]);
        }
        return answer;
    }
}  
