import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        // 이거 하나씩 넣은다음 
        // 맨위 문자열과 다음 문자열이 같으면 제거방식으로
        // 스택쓰면 될듯
        Stack<String> st = new Stack<String>();
        for(int i = 0 ; i<s.length();i++){
            String tmp = s.substring(i,i+1);
            // 비었으면 + , 안비었으면 판단해서 같으면 제거하고 다르면 +
            if(st.size() == 0){
                st.add(tmp);
            }
            else{
                if(tmp.equals(st.peek())){
                    st.pop();
                }
                else{
                    st.add(tmp);
                }
            }
        }
        // 끝났을 때 size가 0이면 1로 교체
        if(st.size() ==0){
            answer = 1;
        }
        
        

        return answer;
    }
}
