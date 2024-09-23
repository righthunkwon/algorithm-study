import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks); //오름차순 정렬
        
        //이분탐색
        int st = 0;
        int ed = distance;
        int mid;
        int cnt;
        int prev_rock; //이전 돌 좌표(출발지)
        
        while(st<=ed){
            mid = (st+ed)/2;
            cnt = 0; //제거한 돌 개수 카운트용
            prev_rock=0; //출발지 초기화
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-prev_rock<mid){ //현재 mid보다 더 작은 거리일 경우
                    if(cnt<=n){ //제거할 돌 여유 되면 제거
                        cnt++;
                    }else{ //제거할 돌 여유 안되면 현재 mid보다 작아져야만 함
                        ed = mid - 1;
                        break;
                    }
                }else{
                    prev_rock = rocks[i];
                }
            }//for i
            
            //맨 마지막 구간 처리
            if(distance-prev_rock < mid){
                cnt++;
            }
            
            if(cnt<=n){
                answer = mid;
                st = mid+1;
            }else{
                ed = mid-1;
            }
        }//while
        
        return answer;
    }
}
