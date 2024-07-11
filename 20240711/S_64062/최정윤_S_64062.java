import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        //k를 세트로 생각해보면 됨
        //앞에서부터 k개의 최댓값 중 최솟값 구하면 된다.     
        //for문으로 돌면 시간초과

        // for(int i=0;i<stones.length-k;i++){
        //     int max=0;
        //     for(int j=i;j<i+k;j++){
        //         max=Math.max(max,stones[j]);
        //     }
        //     answer=Math.min(max,answer);
        // }
        int answer = 1;    
        int st=1;
        int ed=200000000;
    
        
        while(st<=ed){
            int mid=(st+ed)/2;
            int cnt=0;
            for(int i=0;i<stones.length;i++){
                if(stones[i]-mid<0) cnt++; //못건너나는 돌
                else cnt=0;
                if(cnt>=k) {
                    ed=mid-1;
                    break;
                }
            }
            if(cnt<k){//break 해서 온게 아니라면
                answer=mid;
                st=mid+1;             
            }
            
        }

        return answer;
    }
}
