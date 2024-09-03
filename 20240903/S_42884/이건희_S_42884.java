import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int camera = -30001;// 범위 밖

        for (int[] route : routes) {
            if (camera < route[0]) { 
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }
}