import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        // 110을 스택에 넣어서 찾고
        // 사전순으로 앞에오게 배치하면 끝날듯
        
        //먼저 문자열에서 "110"을 전부 추출한다. 그후 남은 문자열에 0이 없으면, 
        // 맨 앞에 110이 와야 사전 순으로 제일 앞에 오게 된다.
        // 문자열에 0이 포함되어 있다면 가장 마지막 0의 위치를 찾은 후, 
        // 그 다음부터 추출한 문자열을 넣어줘야 한다.
        
        StringBuilder sb = new StringBuilder();  

        for(int i=0; i<s.length; i++) { // 테스트 케이스 하나씩   
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            // 매 횟수마다 110 개수세서 cnt에 저장하고
            // 나머진 스택에 넣기
            for(int j=0; j<str.length(); j++) {
                char z = str.charAt(j);
                // 우선 z를 스택에 넣는데
                // 만약 이미 스택에 2개가 있으면
                // 110인지확인
                if(stack.size()>=2) {
                    char y = stack.pop();
                    char x = stack.pop();

                    if(x=='1' && y=='1' && z=='0') {
                        cnt++;
                    } else {
                        // 아니면 3개모두 다시 스택에 넣음
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                } else {
                    stack.push(z);
                }
            }
            // 이제 110개수 확인은 끝
            int idx = stack.size();
            boolean flag = false;
            sb = new StringBuilder();
            while(!stack.isEmpty()) {
                if(!flag && stack.peek()=='1') {
                    idx--;
                }
                
                if(!flag && stack.peek()=='0') {
                    flag = true;
                }
                // 0이 있는지 확인한후 그대로 sb에 넣어줌
                sb.insert(0, stack.pop());
            }
            // 110이 없으면 그대로 answer에 넣고
            // 있다면 개수만큼 앞에다 넣고 시작
            if(cnt>0) {
                while(cnt>0) {
                    sb.insert(idx, "110");
                    idx += 3;
                    cnt--;
                }
                answer[i] = sb.toString();
            } else {
                answer[i] = s[i];
            }
        }
        return answer; 
    }
}
