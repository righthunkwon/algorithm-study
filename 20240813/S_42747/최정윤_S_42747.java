import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        //정렬 후 조건 만족하는 지 
        for(int i=citations.length-1;i>=0;i--){
            answer++;
            if(citations[i]<answer){
                answer--;
                break;
            }
        }
        return answer;
    }
}
