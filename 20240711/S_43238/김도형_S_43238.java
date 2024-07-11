import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int len = times.length; //심사관 수
        Arrays.sort(times); //이분탐색을 위해 심사 시간 오름차순 정렬
        
        long min = 0;
        long max = (long)times[len-1]*n;
        
        while(max>=min){
            long mid = (min + max) / 2;
            long cnt=0; //mid 시간동안 완료된 사람 수 카운트용
            
            for(int i=0;i<len;i++){
                cnt+= mid/times[i]; //각 심사관이 mid시간동안 심사 완료한 사람 수 더해줌
            }
            
            if(cnt<n){
                min=mid+1; //심사한 사람수가 더 많으면 max값 줄여줌
            }else{
                max=mid-1;
            }
        }
        
        return min;
    }
}
