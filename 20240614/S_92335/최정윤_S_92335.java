import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String change=Integer.toString(n,k);
        String[] arr=change.split("0");
        notPrime=new boolean[210000000];
        isPrime();
        int answer = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].trim().equals("1")||arr[i].trim().equals("")) continue;
            if(Long.parseLong(arr[i])<210000000){
                if(!notPrime[Integer.parseInt(arr[i])]) {
                    answer++;
                }
            }
            else{
                if(isPrime(Long.parseLong(arr[i]))) answer++;
            }
        }
        return answer;
    }
    static boolean[] notPrime;
    
    public static void isPrime(){ //에라토스테네스의 채 쓰려고 했는데 int 범위 넘어가서 사실상 필요없음
        for(int i=2; i<210000000; i++){
            if(!notPrime[i]){
                for(int j=i+i;j<210000000;j+=i){
                    notPrime[j] = true;
                }
            }
        }
    }
    public static boolean isPrime(Long n){
        for(int i=2; i<Math.sqrt(n); i++){
           if(n%i==0) return false;
        }
        return true;
    }
}
