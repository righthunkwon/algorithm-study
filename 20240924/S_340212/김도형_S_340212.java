import java.util.*;
import java.io.*;
class Solution {
    static int[]dif,tim;
    static long lim;
    static long ans;
    public int solution(int[] diffs, int[] times, long limit) {
        ans = Long.MAX_VALUE;
        dif = diffs;
        tim = times;
        lim = limit;
        
        //이분탐색
        long st = 1;
        long ed = Long.MAX_VALUE;
        while(st<=ed){
            long mid = (st+ed)/2;    
            if(isPossible(mid)){ //해당 숙련도로 제한시간 내에 해결 가능여부 확인
                ans=Math.min(ans,mid);
                ed=mid-1;
            }else{
                st=mid+1;
            }
        }
        return (int)ans;
    }
    
    
    public static boolean isPossible(long lv){
        long sum = 0; //누적 소요시간
        
        if(lv <= 0)return false; //예외처리 (이거 안하니까 14번 테스트케이스 틀림)
        
        for(int i=0;i<dif.length;i++){
            if(dif[i] <= lv){
                sum += tim[i];
            }else{
                long cnt = dif[i] - lv; //틀리는 횟수
                if(i == 0){ //첫문제면
                    sum += tim[i] * cnt + tim[i];
                }else{
                    sum += (tim[i] + tim[i-1] ) * cnt + tim[i];
                }
            }
            if(sum > lim){ //제한시간 넘기면 false 리턴
                return false;
            }
        }
        return true;
    }
}
