import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 대소문자 구분 X 다 대문자로 입력
        //Map에 넣고 세기
        Map<String,Integer> map=new HashMap();
        int tot=0;
        for(int i=0;i<str1.length()-1;i++){
            String str=str1.substring(i,i+2).toUpperCase();
            char[] arr=str.toCharArray();
            //영어아니면 map에 넣지 X
            if(arr[0]-'A'<0||arr[0]-'Z'>0||arr[1]-'A'<0||arr[1]-'Z'>0) continue;
            int cnt=map.getOrDefault(str,0);
            //겹치는 것은 map에 들어가버리므로 tot따로 계산
            tot++;
            map.put(str,cnt+1);
        }
        int same=0;
        for(int i=0;i<str2.length()-1;i++){
            String str=str2.substring(i,i+2).toUpperCase();
            char[] arr=str.toCharArray();
            if(arr[0]-'A'<0||arr[0]-'Z'>0||arr[1]-'A'<0||arr[1]-'Z'>0) continue;
            int cnt=map.getOrDefault(str,0);
            if(cnt>0)same++; //str1에서 이미 있는 것이면 교집합 수++
            tot++;
            map.put(str,cnt-1); //사용한 것은 빼주기 원소의 중복을 허용하기 때문 
        }
        if(tot-same==0)return 65536;
        int answer = (int)Math.floor(((double)same/(tot-same))*65536);
        return answer;
    }
}
