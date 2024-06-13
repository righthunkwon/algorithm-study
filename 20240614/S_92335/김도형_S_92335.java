import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        
        //일단 n을 k진수로 변환
        String str = Integer.toString(n,k);
        System.out.println(str);
        
        //0으로 쪼갬
        StringTokenizer st = new StringTokenizer(str,"0");
        
        int answer = 0;
        
        while(st.hasMoreTokens()){
            long num = Long.parseLong(st.nextToken());
            System.out.println(num);
            if(check(num)){
                answer++;
            }
        }
        return answer;
    }
    
    //소수인지 체크
    public static boolean check(long num){
        
        if(num==0 || num==1){
            return false;
        }
        
        if(num==2){
            return true;
        }
        
        //제곱근까지 나눠보고 나눠지면 소수 아님
        for(long i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }else continue;
        }
        return true;
        
    }
    
}
