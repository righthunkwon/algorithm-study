import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[2];
        int changes = 0; //이진 변환의 횟수
        int zero = 0; //제거된 0의 개수
        
        while(!s.equals("1")){ //s가 1이될때까지 반복
            int len = s.length();
            int cnt = 0; //0의 개수 카운트용
            changes++; //변환횟수 +1
            for(int i=0;i<len;i++){
                if(s.charAt(i)=='0'){
                    cnt++;
                    zero++; //0제거 횟수+1
                }
            }
            int c = len - cnt; //0을 제거한 길이
            
            s = Integer.toBinaryString(c); //2진수로 바꾸기
            
        }
        
        answer[0]=changes;
        answer[1]=zero;
        
        return answer;
    }
}
