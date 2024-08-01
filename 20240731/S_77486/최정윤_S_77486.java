import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //위로는 한 줄이니까 연결만 잘 지어놓으면 될 것 같은디 
        //어차피 추천인은 한명이니까 map으로 만들어 놓으면 될 듯?
        //나 내 추천인
        map=new HashMap();
        //이름별로 인덱스 저장하는 map도 만들기
        name=new HashMap();
        for(int i=0;i<enroll.length;i++){
            name.put(enroll[i],i); //이름, 인덱스
            map.put(enroll[i],referral[i]); //나 ,내 추천인
        }
        answer = new int[enroll.length];
        for(int i=0;i<seller.length;i++){
            dfs(seller[i],amount[i]*100);
        }
        return answer;
    }
    
    public static void dfs(String seller,double amount){
        if(seller.equals("-")) return; //맨 꼭대기
        String recom=map.get(seller);
        Integer index=name.get(seller);
        if(amount<10) answer[index]+=amount; //10프로가 1미만
        else {
            answer[index]+=Math.ceil(amount*0.9); //90프로 1의자리까지 올림
            dfs(recom,Math.floor(amount*0.1)); //10프로 내림(정수로 만들기)
        }
    }
    
    static int[] answer;
    static Map<String, String> map;
    static Map<String, Integer> name;
}
