import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        //이분탐색인가?
        //level의 범위 diffs[0]~diffs max
        int max=0;
        for(int i=0;i<diffs.length;i++){
            max=Math.max(max,diffs[i]);
        }
        int answer = Integer.MAX_VALUE;
        int st=diffs[0];
        int ed=max;
        int mid;
        while(st<=ed){    
            mid=(st+ed)/2;
            //mid 숙련도로 했을 때 시간 구하기
            long sum= times[0];
            for(int i=1;i<diffs.length;i++){
                sum+=times[i];
                if(diffs[i]-mid>0) sum+=(diffs[i]-mid)*(times[i-1]+times[i]);
            }
            //제한시간보다 초과면 숙련도 높이기
            //아니면 정답저장해놓고 더 낮은 숙련도 찾기
            if(sum>limit){
                st=mid+1;
            }else{
                answer= Math.min(answer,mid);
                ed=mid-1;
            }
            
        }

        return answer;
    }
}
