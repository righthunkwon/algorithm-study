import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String []str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            str[i]=Integer.toString(numbers[i]); // 정수 -> 문자열형태로 변환
        }
        
        //두 수를 각각 앞뒤로 붙여봤을 때 값의 크기 비교를 통해 정렬
        Arrays.sort(str,(o1,o2)->Integer.parseInt(o1+o2)-Integer.parseInt(o2+o1)); 
        
        for(int i=str.length-1;i>=0;i--){
            sb.append(str[i]);
        }
        
        String answer = sb.toString();
        
        //numbers에 0만 여러개 있는 테스트 케이스 예외 처리
        if(answer.charAt(0)=='0')return "0";
        
        return answer;
    }
}
