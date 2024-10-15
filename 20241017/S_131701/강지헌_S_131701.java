import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> a = new HashSet<>();
        for(int i=0;i<elements.length;i++) {
            int t=0;
            for(int j=0;j<elements.length;j++) {
                t+=elements[(i+j)%elements.length];
                a.add(t);
            }
        }
        return a.size();
    }
}
