import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, gems);
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, l = 0, r = 0, a = 0, b = 0;
        while(true) {
            if(set.size() == map.size()) {
                map.put(gems[l], map.get(gems[l])-1);
                if(map.get(gems[l])==0) map.remove(gems[l]);
                l++;
            }
            else if(r==gems.length) break;
            else {
                map.put(gems[r], map.getOrDefault(gems[r], 0)+1);
                r++;
            }
            if(set.size() == map.size() && r-l < min) {
                min = r-l;
                a = l+1;
                b = r;
            }
        }
        return new int[]{a,b};
    }
}
