import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
         StringBuilder answer = new StringBuilder();
        int[] arr=new int[10];
        int cnt = number.length()-k;
        for(String a : number.split("")){
            arr[Integer.parseInt(a)]++;
        }
        for(int i=9;i>=0;i--){
            if(cnt>=arr[i]){
                 for (int j = 0; j < arr[i]; j++) {
                    answer.append(i);
                }
                cnt-=arr[i];
            }else{
                for (int j = 0; j < cnt; j++) {
                    answer.append(i);
                }
                break;
            }
        }
     
        return answer.toString();
    }
}
