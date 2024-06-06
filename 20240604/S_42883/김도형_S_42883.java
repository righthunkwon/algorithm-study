import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        //숫자의 오른쪽에서 k-1 개를 제외한 앞부분 중 가장 큰 수를 고른다.
        //가장 큰 수 뒷부분 중에서 이제 오른쪽 k-2개를 제외한 앞부분에서 가장 큰 수를 고름
        //반복
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int idx = 0;
        System.out.println(len);
        
        for(int i=0;i<len-k;i++){
            int max = 0;
            for(int j=idx;j<=i+k;j++){
                if(max<number.charAt(j)-'0'){
                    max = number.charAt(j)-'0'; //가장 큰 수 갱신
                    idx=j+1; //인덱스 갱신
                }
            }
            answer.append(max);
        }
       
        return answer.toString();
    }
    
    
}
