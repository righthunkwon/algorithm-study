import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        int select = k; //선택된 행
        int nowLen = n; //현재 표의 크기 
        Stack<Integer> st = new Stack<>();//삭제된 행 저장해둘 스택

        //명령 수행
        for(int i=0;i<cmd.length;i++){
            char x = cmd[i].charAt(0);
            if(x=='U'){
                select-=Integer.parseInt(cmd[i].substring(2));
            }else if(x=='D'){
                select+=Integer.parseInt(cmd[i].substring(2));
            }else if(x=='C'){
                st.add(select);
                nowLen--;//표 크기 1 감소
                if(select==nowLen)select--;//맨끝삭제하면 위로 이동
            }else if(x=='Z'){
                nowLen++;//표 크기 다시 1 증가시키고
                if(st.pop()<=select)select++; //지금 선택된 곳 보다 위쪽이 복구됐으면 선택된 행 위치 +1
            }
        }
        
        
        //정답 출력
        StringBuilder sb = new StringBuilder();
        
        //일단 남아있는 행 갯수만큼 O로 문자열 만들고
        for(int i=0;i<nowLen;i++){
            sb.append("O");
        }
        while(!st.isEmpty()){
            sb.insert(st.pop(),"X"); //문자열에 삭제된 행 끼워넣기
        }
        
        String answer = sb.toString();
        return answer;
    }
}
