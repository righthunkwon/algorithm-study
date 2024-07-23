import java.util.*;

class Solution {
    static int index =0;
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> st = new Stack<>();
        index = n;
        // 이전 노드, 다음 노드 정보를 갖고 있는 Node를 LinkedList로 구현하는 방식 -> 이유모르겠는데 시간초과 뜸
      
        // c 나올때마다 stack에 넣고 z로 복구되면 스택에서 뽑음 index도 c면 - Z면 +
        // U와 D는 k를 조절하면서 계속 조종
        for(int i = 0 ;i<cmd.length;i++){
            String word = cmd[i].substring(0,1);
            if(word.equals("U")){
                int cnt = Integer.parseInt(cmd[i].substring(2,cmd[i].length()));
                k -= cnt;
            }
            else if(word.equals("D")){
                int cnt = Integer.parseInt(cmd[i].substring(2,cmd[i].length()));
                k += cnt;
            }
            else if(word.equals("C")){
                // 현재위치 k를 스택에 넣고
                // 전체 개수 -1한 후에 만약 끝점일 경우 커서는 -1
                st.push(k);
                index --;
                if(index == k){
                    k--;
                }
            }
            else{
                // 우선 index+1해주고 st에서 하나꺼내는데 
                // 현재 커서위치가 꺼낸점보다 뒤에있으면 커서 +1
                index ++;
                int tmp = st.pop();
                if(tmp <= k) {
                    k++;
                }
            }
        }
        // 이제 전체 확인
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<index;i++){
            sb.append("O");
        }
        while(st.size()>0){
            int tmp = st.pop();
            sb.insert(tmp, "X");
        }
        return sb.toString();
    }
}
