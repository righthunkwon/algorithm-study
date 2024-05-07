import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        if(s.length()%2==1){ //길이가 홀수면 일단 불가능
            return 0;
        }
        
        Stack<Character>stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(stack.isEmpty()){ //스택 비었으면 스택에 추가
                stack.add(a);
            }else{
                if(stack.peek()==a){ //스택 비어있지 않은데 스택 맨 위와 같으면 pop
                    stack.pop();
                }else{
                    stack.add(a); //스택 비어있지 않고 다르면 스택에 추가
                }
            }
        }
        
        if(stack.size()==0){ //남은거 없으면 가능
            answer=1;
        }else{
            answer=0; //남으면 불가능
        }

        return answer;
    }
}
