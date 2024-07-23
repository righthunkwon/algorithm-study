import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        //처음에 다 돌고 투포인터 ,, 사용,, 
        Map<String, Integer> map=new HashMap();
        Set<String> set=new HashSet();
        for(int i=0;i<gems.length;i++){
           set.add(gems[i]);
        }
        int kind=set.size();
        int st=0;
        int ed=0;
        int min = 100001;
        int[] answer = new int[2];
        
        while(ed<gems.length){//오른쪽 포인트 잡기
            map.put(gems[ed], map.getOrDefault(gems[ed], 0) + 1);
            ed++;
             while (map.size() == kind) {//왼쪽 포인트 잡기
                if (ed - st < min) {
                    min = ed - st;
                    answer[0] = st+1;
                    answer[1] = ed; //플러스를 앞에서 해놨기 때문
                }
                if (map.get(gems[st]) == 1) { //왼쪽 땡기다가 종류없어질 것 같으면 그만하고 다시 오른쪽 땡겨라 
                    break;
                }
                map.put(gems[st], map.get(gems[st]) - 1);
                st++;
            }
        }
                
        return answer;
    }
}
