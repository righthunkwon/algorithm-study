import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        
        HashMap<String,Integer> hm1= toHash(str1);
        HashMap<String,Integer> hm2= toHash(str2);
        
        int intersection = 0; //교집합
        int union = 0; //합집합
        
        if(hm1.size()+hm2.size()==0)return 65536; //둘다 공집합이면 예외처리
        
        //모든 키들을 합집합에 추가해야되니까, hm1과 hm2의 키를 병합한 해시셋 만듦
        HashSet<String> allKeys = new HashSet<>(hm1.keySet());
        allKeys.addAll(hm2.keySet());
        
        //합집합,교집합 계산
        for (String key : allKeys) {
            int count1 = hm1.getOrDefault(key, 0);
            int count2 = hm2.getOrDefault(key, 0);
            
            //교집합(둘중 하나라도 0이면 안더해지고, 둘다 존재하면 둘중 적은 갯수 더함)
            intersection += Math.min(count1, count2);
            
            //합집합(둘중 하나라도 0이아니면 더해주고, 둘다 존재하면 둘중 큰 갯수 더함)
            union += Math.max(count1, count2);
        }

        //자카드 유사도 계산
        double jaccard = (double) intersection / union;
        
        //자카드 유사도에 65536을 곱하고 소수점을 버림
        return (int) (jaccard * 65536);
    }
    
    //두글자씩 끊어서 다중집합 만들기(공백,숫자,특수문자 포함된 원소 제외)
    //<문자,문자갯수> 로 hashmap 만듦
    public HashMap<String,Integer> toHash(String str){
        HashMap<String,Integer> hm = new HashMap<>();
        
        str=str.toUpperCase(); //대문자로
        
        for(int i=0;i<str.length()-1;i++){
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            //아스키코드 65~90이면 영문 알파벳
            if((int)a<65 ||(int)a>90 ||(int)b<65 ||(int)b>90)continue;
            String c = a+""+b;
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        return hm;
    }
}
