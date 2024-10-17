import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int c = 1; c <= n; c++) {
                tmp += elements[(i + c - 1) % n];
                set.add(tmp);
            }
        }
        return set.size();
    }
}

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<Integer>();
        int n = elements.length;
        for(int c = 1; c <= n; c++){
            for(int i = 0; i < n; i++){
                int tmp = 0;
                for(int j = i; j < i+c; j++){
                    if(j < n){
                        tmp += elements[j];
                    }else{
                        tmp += elements[j-n];
                    }   
                }
                set.add(tmp);
            }
        }
        return set.size();
    }
}