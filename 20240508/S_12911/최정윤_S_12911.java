import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n) {
        int cnt=0;
        char[] arr= Integer.toBinaryString(n).toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1')cnt++;
        }
        int answer = n;
        while(true){
          answer++;
          int cnt2=0;  
          char[] arr2= Integer.toBinaryString(answer).toCharArray();
            for(int i=0;i<arr2.length;i++){
                if(arr2[i]=='1')cnt2++;
            }
            if(cnt==cnt2){
                break;    
            }  
        }
        return answer;
    }
}
