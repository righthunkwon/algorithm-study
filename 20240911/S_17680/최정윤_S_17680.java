import java.io.*;
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0)return 5*cities.length;
        int answer = 0;
        //캐시하는 리스트
        List<String> save=new ArrayList();
        
        for(int i=0;i<cities.length;i++){
            int idx=save.indexOf(cities[i].toLowerCase());//대소문자 구분 X
            if(idx==-1){//없다면 
                answer+=5; 
                if(save.size()==cacheSize)save.remove(0);
           }
            else {//이미 있다면
                answer+=1;
                save.remove(idx);
            }
            save.add(cities[i].toLowerCase());
                
        }
        return answer;
    }
}
