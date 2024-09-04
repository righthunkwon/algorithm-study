import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String s) {
        
        //s의 맨앞과 뒤의 {,} 를 제거
        s = s.substring(1,s.length()-1);
        
        //원소별로 합을 저장
        List<Integer>list = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                int sum = 0;
                String st = "";
                i++;
                l:while(s.charAt(i)!='}'){
                    if(s.charAt(i)==','){
                        sum+=Integer.parseInt(st);
                        st="";
                        i++;
                    }else{
                        st=st+s.charAt(i);
                        i++;
                    }
                }
                sum+=Integer.parseInt(st);
                list.add(sum);
            }
        }
        
        //오름차순 정렬
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        answer[0]=list.get(0);
        
        //누적합을 통해 순서대로 튜플의 원소 저장
        if(list.size()>1){ 
            for(int i=1;i<list.size();i++){
                answer[i]=list.get(i)-list.get(i-1);
            }
        }
        
        return answer;
    }
}
