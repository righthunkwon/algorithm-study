import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); //오름차순 정렬
        //이분탐색
        int st = 0;
        int ed = 10000; 
        int answer = 0;
        while (st <= ed) {
            int mid = (st + ed) / 2; 
            if (check(mid, citations)) { //mid가 h조건 만족하면 답 갱신
                answer = mid;
                st = mid + 1;
            } else
                ed = mid - 1;
        }
        return answer;
    }
    
    public boolean check(int mid, int[]citations){
        for(int i=0;i<citations.length-1;i++){
            if(citations[i]>=mid){
                int cnt = citations.length-i; //mid번 이상 인용된 논문 갯수
                if(cnt>=mid)return true;
                break;
            }   
        }
        return false;
    }    
}
