import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        //길이 1000
        //누적합으로 elements.length*2까지 해놓기
        len=elements.length;
        sum=new int[len*2]; 
        sum[0]=elements[0];
        for(int i=1;i<len*2;i++){
            sum[i]=sum[i-1]+elements[i%len];
        }
        set=new HashSet();
        for(int i=1;i<=elements.length;i++){
            cal(i);
        }
        int answer = set.size();
        return answer;
    }
    public static void cal(int num){//누적합으로 개수 별 합 구하기
        for(int i=0;i<len;i++){
            set.add(sum[i+num]-sum[i]);
        }
    }
    static Set<Integer> set;
    static int[] sum;
    static int len;
}
