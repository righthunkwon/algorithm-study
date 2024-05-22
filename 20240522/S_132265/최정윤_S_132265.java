import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
            int answer = 0;
            HashMap<Integer,Integer> map1=new HashMap(); 
            HashMap<Integer,Integer> map2=new HashMap();
            for(int i=0;i<topping.length;i++){//첫번째 사람한테 다 넣어놓고 빼기
                map1.put(topping[i],map1.getOrDefault(topping[i],0)+1);
            }
            for(int i=0;i<topping.length;i++){
                int change = map1.get(topping[i])-1;//1번에서 빼고
                if(change==0)map1.remove(topping[i]);
                else{
                    map1.put(topping[i],change);
                }
                map2.put(topping[i],map2.getOrDefault(topping[i],0)+1);//2번한테 넣는다
                 if(map1.size()==map2.size()) answer++;
            }
           
        
        return answer;
    }
}
