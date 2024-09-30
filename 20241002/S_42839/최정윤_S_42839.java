import java.util.*;
import java.io.*;

class Solution {
    public int solution(String numbers) {
        set=new HashSet();
        num=numbers.split("");
        for(int i=0;i<num.length;i++){//순열의 수 정하기
            len=i;
            StringBuilder sb=new StringBuilder();
            visited=new boolean[num.length];
            select(0,sb);
        }
        int answer = set.size();
        return answer;
    }

    public static void select(int sidx,StringBuilder sb){//순열
        if(sidx>len){
            // System.out.println(Integer.parseInt(sb.toString()));
            if(isPrime(Integer.parseInt(sb.toString()))){
                set.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        for(int i=0;i<num.length;i++){
            if(visited[i])continue;
            visited[i]=true;
            StringBuilder sb2=new StringBuilder(sb);
            select(sidx+1,sb2.append(num[i]));
            visited[i]=false;
        }
        
    }
    public static boolean isPrime(int number){ //소수판별식
        if(number==0||number==1) return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0) return false;
        }
        return true;
    }
    static Set<Integer> set;
    static int len;
    static String[] num;
    static boolean[] visited;
}
