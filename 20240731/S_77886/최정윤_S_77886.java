import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        //0이 있는 순간 앞에는 11이 없었다는 걸 입증
        //마지막 0뒤에 붙이면 된다.
        //0이 없고 앞에 1이 있다면 그 앞으로 가면된다.
        //11110001
        String[] answer = new String[s.length];
        StringBuilder sb;
        for(int i=0;i<s.length;i++){
            sb=new StringBuilder();
            int cnt=0;
            //110 몇개인지 카운트
            for(int j=0; j<s[i].length(); j++){
                Character c = s[i].charAt(j);
                if(sb.length()>=2 && c=='0' && sb.charAt(sb.length()-2)=='1' && sb.charAt(sb.length()-1)=='1'){
                    cnt++;
                    sb.delete(sb.length()-2, sb.length());
                }
                else{
                    sb.append(c);
                }
            } 
           //넣을 위치 찾기
            if(sb.indexOf("0")==-1){
                for(int j=0;j<cnt;j++){
                    sb.insert(0,"110");
                }
            }else{
                int lo=sb.lastIndexOf("0");
                for(int j=0;j<cnt;j++){
                    sb.insert(lo+1,"110");
                }
            }
            
            answer[i]=sb.toString();
            
        }
        
        return answer;
    }
}
