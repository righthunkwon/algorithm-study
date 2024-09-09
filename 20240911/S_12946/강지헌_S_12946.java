import java.util.*;
class Solution {
    static List<int[]> arr = new ArrayList<>();
    public int[][] solution(int n) {
        move(n,1,2,3);
        int[][] answer=arr.stream().toArray(int[][]::new);
        return answer;
    }
    static void move(int t,int s,int m,int e) {
        if (t==0) return;
        move(t-1,s,e,m);
        arr.add(new int[]{s,e});
        move(t-1,m,s,e);
    }
}
