import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for(int i = 0; i < citations.length; i++){
            index = citations[i];
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= index) count++;
            }
            if(index <= count){
                return index;
            }
        }
        return 0;
    }
}
