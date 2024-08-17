import java.io.*;
import java.util.*;
//757 75 8 66
//8 75 7571
//8 7571 75
class Solution {
    public String solution(int[] numbers) {
        List<String> list=new ArrayList();
        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, (o1,o2)->((o2+o1).compareTo(o1+o2)));
        StringBuilder sb=new StringBuilder();
        if(list.get(0).equals("0")) return "0";
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        String answer = sb.toString();
        return answer;
    }
}
