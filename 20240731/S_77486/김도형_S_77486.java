import java.util.*;
import java.io.*;

class Solution {
    
        //사람-이익
        HashMap<String, Integer> benefit = new HashMap<>();
        
        //사람-추천인
        HashMap<String, String> recommand = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        for(int i=0;i<enroll.length;i++){
            recommand.put(enroll[i],referral[i]); //추천인 입력
            benefit.put(enroll[i],0); //일단 모든 사람 이익 0으로 초기화
        }
        
        //이익 배분
        for(int i=0;i<seller.length;i++){
            distribute(seller[i],amount[i]*100);
        }
        
        //각 사람별 이익 결과 반환
        int[] answer = new int[enroll.length];
        
        for(int i=0;i<enroll.length;i++){
            answer[i]=benefit.get(enroll[i]);
        }
        return answer;
    }
    
    
    //이익 분배 메서드
    //10퍼센트씩 추천인이 가져감
    public void distribute(String seller, int amount){
        
        if(seller.equals("-")||amount==0)return; //기저조건
        
        String recommander = recommand.get(seller);
        int toRecommander = amount/10;
        int toSelf = amount- toRecommander;
            
        benefit.put(seller, benefit.get(seller)+toSelf);
        
        //다시 추천인의 이익을 배분
        distribute(recommander,toRecommander);
        
    }
}
