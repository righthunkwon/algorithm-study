import java.io.*;
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        //무엇을 기준으로 이분탐색?
        //return 값 기준 이분탐색
        //최댓값 = 도착지점까지의 거리
        //최솟값 각 바위사이의 거리 중 최솟값
        int answer = 0;
        Arrays.sort(rocks);
        int st=Integer.MAX_VALUE;
        for(int i=0;i<rocks.length-1;i++){
            st=Math.min(st,rocks[i+1]-rocks[i]);
        }
        st=Math.min(st,rocks[0]);
        st=Math.min(st,distance-rocks[rocks.length-1]);
        int ed=distance;
        //최솟값 mid로 설정하고
        while(st<=ed){//이분탐색
            int mid=(st+ed)/2;
            int cnt=0;
            int idx=0;
            int ex=0;
            //거리의 최솟값 mid로 할 때 저거해야하는 바위 개수 구하기
            while(idx<=rocks.length){
                if(idx==rocks.length){
                    if(distance-ex<mid){
                        cnt++;
                    }   
                }else{
                    if(rocks[idx]-ex<mid){
                        cnt++;
                    }else{
                        ex=rocks[idx];
                    }
                }
                idx++;
            }
            if(cnt<=n) {//n개 이하를 제거했는 데 최소값으로 성립한다면 정답 저장 가능
                answer=Math.max(answer,mid);
                st=mid+1;
            }else{
                ed=mid-1;
            }
        }        
       
        return answer;
    }
}
