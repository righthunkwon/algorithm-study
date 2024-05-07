import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmp = n+1;
        String a = Integer.toBinaryString(n); //2진수로
        char[]arr = a.toCharArray(); 
        int aCnt =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1')aCnt++; //1개수 카운트
        }
        
        l:while(true){
            int bCnt = 0;
            String b = Integer.toBinaryString(tmp); //2진수로
            char[]brr = b.toCharArray();
            for(int i=0;i<brr.length;i++){
                if(brr[i]=='1')bCnt++; //1개수 카운트
            }
            if(bCnt == aCnt){ //같으면 정답
                answer = tmp;
                break l;
            }else{
                tmp++; //아니면 1더하기
            }
            
        }

        return answer;
    }
}
