import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] sequence) {  
        long []dp1 = new long[sequence.length]; //짝수번째가 부호 바뀌는 경우
        long []dp2 = new long[sequence.length]; //홀수번째가 부호 바뀌는 경우
        dp1[0]=sequence[0];
        dp2[0]=sequence[0]*(-1);
        long answer = Math.max(dp1[0],dp2[0]);
        //누적된 최대값과 부호 반영된 현재 수를 더하는 것과
        //부호 반영된 현재 수로 시작하는 경우를 비교해 더 큰걸 저장
        for(int i=1;i<sequence.length;i++){    
            if(i%2==1){
                dp1[i]=Math.max(dp1[i-1]+sequence[i]*(-1),sequence[i]*(-1));
                dp2[i]=Math.max(dp2[i-1]+sequence[i],sequence[i]);
            }else{
                dp2[i]=Math.max(dp2[i-1]+sequence[i]*(-1),sequence[i]*(-1));
                dp1[i]=Math.max(dp1[i-1]+sequence[i],sequence[i]);   
            }
            long tmp = Math.max(dp1[i],dp2[i]);
            answer = Math.max(tmp,answer);
        }
        return answer;
    }
}
