import java.util.*;
class Solution {
    public long solution(int[] weights) {
    	long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        int[] a = {1,2,1,3},b={1,3,2,4};
        for(int i : weights) {
            for(int j=0;j<4;j++) {
                double t = (double)i*a[j]/b[j];
                if(map.containsKey(t)) answer += map.get(t);
            }
    		map.put((double)i, map.getOrDefault((double)i,0)+1);
        }
        return answer;
    }
}
