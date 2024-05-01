import java.io.*;
import java.util.*;

public class Solution {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right - (int)left + 1];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long x = i / n;
            long y = i % n;
            //x,y중 큰값 +1 이 해당 자리 값 됨
            answer[idx++] = Math.max((int)x, (int)y) + 1;
        }
        
        return answer;
    }
}
