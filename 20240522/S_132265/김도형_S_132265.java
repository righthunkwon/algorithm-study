import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int [] left = new int[100001];
        int [] right = new int[100001];
        int lcnt = 0; //왼쪽 토핑개수
        int rcnt = 0; //오른쪽 토핑개수
        
        int len = topping.length;
        
        //일단 오른쪽에 몰아서 토핑 개수 카운트
        for(int i=0;i<len;i++){
            int a = topping[i];
            if(right[a]==0){ //최초 등장 토핑이면
                right[a]++;
                rcnt++;
            }else{
                right[a]++;
            }
        }
        
        for(int i=0;i<len;i++){
            int a = topping[i];
            
            //오른쪽꺼 하나 왼쪽으로
            if(left[a]==0){
                left[a]++;
                lcnt++;
            }else{
                left[a]++;
            }
            
            if(right[a]==1){
                right[a]--;
                rcnt--;
            }else{
                right[a]--;
            }
            
            if(lcnt==rcnt)answer++;
            if(lcnt>rcnt)break; //왼쪽부분 토핑개수 더 많아지면 더 할필요X
        }
        
        return answer;
    }
}
