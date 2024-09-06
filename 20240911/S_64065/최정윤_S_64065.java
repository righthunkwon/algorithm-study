import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        //Map에 넣기
        Map<String,Integer> map=new HashMap();
        String[] arr=s.split("[{},]");
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()==0)continue;
            int cnt=map.getOrDefault(arr[i],0);
            map.put(arr[i],cnt+1);
        }
        
        int size=map.size();
        int[] answer = new int[size];
        //개수대로 인덱스 지정
        for(String key:map.keySet()){
            answer[size-map.get(key)]=Integer.parseInt(key);
        }
        
        return answer;
    }
}
