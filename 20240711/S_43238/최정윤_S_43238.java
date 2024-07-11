import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        //이분탐색 끝 범위 못잡겠음 ,,
        long st=1;
        // long ed=Long.MAX_VALUE;//오버플로우나서 틀림
        long ed = 1000000000000000000L;//L은 long임을 표시하는 것
        long mid;
        while(st<=ed){
            mid=(st+ed)/2;
            long tot=0;
            for(int i=0;i<times.length;i++){
                tot+=mid/times[i];    
            }
            if(tot>=n){//==될 때 따로 빼서 break 했더니 오답 , 더 최소의 값이 있을 수 있어서
                answer=mid;
                ed=mid-1;
            }else{
                st=mid+1;
            }
        }
        
        return answer;
    }
}
