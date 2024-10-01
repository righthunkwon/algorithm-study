import java.util.*;

class Solution {
    public int solution(String numbers) {
        // 문제를 어떻게 풀것인가
        // 가능한 모든 조합을 문자열로 만든다, 입력 숫자의 길이가 짧다.
        // 만들어진 문자열을 int로 변환한다.
        // 일단 여기까지 먼저 만들어보자
        // 앞에 0붙은 것은 잘 처리하자
        // 소수 판별 함수를 만들어야 한다.
        int n = numbers.length();
        int[] number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = numbers.charAt(i) - '0';
        }
        boolean[] visited = new boolean[n]; 
        Set<Integer> set = new HashSet<>();
        dfs(number, visited, 0, set);
        return set.size();
    }
    
    private boolean check(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    private void dfs(int[] number, boolean[] visited, int current, Set<Integer> set) {
        if (current != 0) {
            if (check(current)) {
                set.add(current);
            }
        }

        for (int i = 0; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(number, visited, current * 10 + number[i], set);
                visited[i] = false;
            }
        }
    }
}