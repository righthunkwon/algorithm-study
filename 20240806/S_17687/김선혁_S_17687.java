import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        // 16진수까지 
        // 0부터 t*m개를 모두 큐에 넣은다음
        // p번째 순서만 출력하면 될듯
        Queue<Character> q = new LinkedList<>();
        StringBuilder answer = new StringBuilder();

        // 0부터 t * m까지 모든 숫자를 n진법으로 변환 후 nums 큐에 추가
        for (int i = 0; q.size() < t * m; i++) {
            String tmp = Integer.toString(i, n).toUpperCase();
            for (char c : tmp.toCharArray()) {
                q.add(c);
            }
        }

        // 현재 큐에서 몇 번째 문자인지 추적
        int index = 0; 
        while (true) {
            // t개만큼 다 들어가면 끝
            if(answer.length()== t){
                break;
            }
            // 큐에서 하나씩 꺼내서
            // p-1번째 순서일 때에만
            // sb에 넣음
            char tmp = q.poll(); 
            if (index % m == (p - 1)) {
                answer.append(tmp);
            }
            index++;
        }
        
        return answer.toString();
    }
}
