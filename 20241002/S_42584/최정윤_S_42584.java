import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack=new Stack();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty()){
                if(stack.peek()[1]<=prices[i]) break; //전 가격이 나보다 작으면 바로 넣기
                int[] ex=stack.pop(); //나보다 크면 가격이 떨어진 것이니까 정답 갱신 
                answer[ex[0]]=i-ex[0];
            }
            stack.add(new int[]{i,prices[i]});
        }
        while(!stack.isEmpty()){ //남은 것은 가장 끝 초를 기준으로 정답 저장
            int[] ex2=stack.pop();
            answer[ex2[0]]=prices.length-1-ex2[0];
        }
        return answer;
        
    }
}
