import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Stack <Integer> st = new Stack<>();
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i=len-1;i>=0;i--){
            int num = numbers[i];
            answer[i]=-1; //일단 -1로 초기설정
            while(!st.isEmpty()){ 
                int a = st.peek();
                if(a>num){
                    answer[i]=a; //스택 맨위에 있는게 더 크면 뒷 큰수
                    break;
                }else{
                    st.pop(); //맨위에 있는게 더 작으면 빼버림
                }
            }
            st.add(num); //스택에 삽입
        }
        
        return answer;
    }
}
