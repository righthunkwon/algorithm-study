import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; sb.length() <= t*m;i++){ //sb길이가 튜브가 말할 숫자 수*사람수 될때까지
            sb.append(Integer.toString(i,n)); //i를 n진법으로 바꿔서 sb에 쌓기
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<t;i++){
            ans.append(sb.charAt(i*m+p-1)); //p-1부터 사람 수 만큼씩 건너뛰면서 정답에 쌓기
        }
        
        return ans.toString().toUpperCase(); //대문자로
        
        
    }
}
