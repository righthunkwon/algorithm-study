import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        k--;
        for(int i = 1; i<= n; i++) {
            list.add(i);
            factorial *= i;
        }
        int index = 0;
        while(n > 0) {
            factorial /= (n--);
            answer[index++] = list.get((int) (k / factorial));
            list.remove((int) (k / factorial));
            k %= factorial;
        }
        return answer;
    }
}
