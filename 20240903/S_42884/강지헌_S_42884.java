import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer=0;
        Arrays.sort(routes,(o1,o2) -> {
            return o1[1]-o2[1];
        });
        int t=Integer.MIN_VALUE;
        for(int[] r:routes) {
            if(t<r[0]) {
                t=r[1];
                answer++;
            }
        }
        return answer;
    }
}
