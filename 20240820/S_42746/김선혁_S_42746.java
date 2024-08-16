import java.util.*;

class Solution {
    static int n;
    public String solution(int[] numbers) {
        
        n = numbers.length;
        String[] result = new String[n]; 
        
        for(int i = 0; i < n; i++){
            result[i] = numbers[i] + "";
        }
        Comparator<String> com = (s1, s2) -> (s2 + s1).compareTo(s1+ s2);
        
        // String Array 정렬
        Arrays.sort(result, com);
               
        String answer = "";
        for(String s : result){
            answer += s;
        }
        
        if(answer.charAt(0) == '0'){
            return "0";
        }
        
        return answer;
    }

    
}
