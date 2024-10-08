import java.util.*;
import java.io.*;

//프로그래머스 42884번 "단속카메라"와 거의 똑같은 문제
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
    
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);
            
        int recent_missile = targets[0][1];
        answer++;
        
        for(int i=1;i<targets.length;i++){
            if(recent_missile <= targets[i][0]){ // 여기만 달라짐 
                answer++;
                recent_missile = targets[i][1];
            }
        }
        
        return answer;
    }
}
