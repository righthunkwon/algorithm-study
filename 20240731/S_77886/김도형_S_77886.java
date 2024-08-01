import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        
        //110을 일단 전부 찾아서 개수 카운트
        //중간에 110을 빼면 새로 110이 만들어질 수도 있음
        //스택으로 관리하면서 새로 110이 생기면 카운트해줌
        //110을 다 빼고 남은 수에서 가장 뒤에 있는 0 뒤에 110을 다 삽입하면 됨
        //0이 없으면 맨 앞에 삽입
        
        for(int i=0;i<s.length;i++){
            String str = s[i];
            
            //110이 처음부터 없으면 그대로 정답에 넣고 패스
            if(!str.contains("110")){
                answer[i]=str;
                continue;
            }
            
            Stack<Character>st = new Stack<>();
            
            StringBuilder sb = new StringBuilder();
            
            int cnt = 0; // 110의 갯수
            
            for(int j=0;j<str.length();j++){
                
                char now = str.charAt(j);
                
                //스택에 아직 2개 안쌓여있거나 now가 1이면 무조건 삽입
                if(st.size()<2 || now=='1'){
                    st.push(now);
                }else{
                    char a = st.pop();
                    char b = st.pop();
                    
                    if(a=='1'&&b=='1'){
                        cnt++;
                    }else{
                        st.push(b);
                        st.push(a);
                        st.push(now);
                    }
                }

            } //for j
            
            boolean flag = false; //110삽입 여부 확인용
            
            while(!st.isEmpty()){
                char a = st.pop();
                //아직 110 삽입 안했으면
                if(!flag){
                    if(a=='0'){
                        flag=true;
                        while(cnt>0){
                            sb.insert(0,"110");
                            cnt--;
                        }
                    }
                    sb.insert(0,a); 
                }else{
                    sb.insert(0,a);
                }
            }
            
            //0이 안남아있었으면
            if(!flag){
                while(cnt>0){
                   sb.insert(0,"110");
                   cnt--;
                }
            }
            
            answer[i]=sb.toString();
            
        }//for i

        return answer;
    }
}
