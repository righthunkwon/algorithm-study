import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1,o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);
        int t=targets[0][1]-1,d=1;
        for(int i=1;i<targets.length;i++) {
            if(targets[i][0]>t) {
                t=targets[i][1]-1;
                d++;
            }
        }
        return d;
    }
}
