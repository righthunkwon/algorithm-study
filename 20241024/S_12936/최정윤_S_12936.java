import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n + 1];  
        long tot = 1;  

        // (n-1)!
        for (int i=1; i< n; i++) {
            tot *= i;
        }
        int idx = 0;
        while (n > 0) {
            long num = (k - 1) / tot;  
            k = (k - 1) % tot + 1;  

            //tot 바꾸기
            if (n > 1) {
                tot /= (n - 1);
            }

            // num번째로 선택할 숫자
            for (int i = 1;i<=visited.length;i++){
                if (!visited[i]){
                    if (num==0){
                        answer[idx] = i;  // 결과
                        idx++;
                        visited[i] = true; 
                        break;
                    }
                    num--;
                }
            }
            n--;  // 다음 자리수로 이동
        }

        return answer;
    }
}
