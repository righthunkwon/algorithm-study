import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack=new Stack();
        int[] answer = new int[numbers.length];
        answer[numbers.length-1] = -1; // 마지막 -1로 넣기
        stack.add(numbers[numbers.length-1]); // 제일 뒷 수 더하기
        a: for(int i=numbers.length-1;i>=0;i--){  // 거꾸로 돌기
                while(numbers[i]>=stack.peek()) { //내가 뒷 수보다 크면 빼기
                    stack.pop();
                    if(stack.isEmpty()){ //더 이상 뒷 수가 없다면 -1
                        answer[i]=-1;
                        stack.add(numbers[i]); 
                        continue a;
                    }
                }
                // 뒷 수가 나보다 크면 그거 출력하고 나 담기
                answer[i]=stack.peek();
                stack.add(numbers[i]);
            }
        return answer;
    }
}
