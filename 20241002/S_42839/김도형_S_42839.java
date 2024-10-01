import java.util.*;

class Solution {
    int N;
    boolean[] visit;
    String number;
    Set<Integer> set;

    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        number = numbers;
        visit = new boolean[N]; // dfs용
        set = new HashSet<>(); // 중복된 숫자 방지용
        
        //숫자를 다 쓸 필요 없음
        //숫자 길이별로 가능한 조합 구하기
        for (int i = 1; i <= N; i++) {
            comb(0, 0, i);
        }
        
        //저장된 숫자 중 소수 개수 카운트
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 숫자 조합
    public void comb(int depth, int num, int limit) {
        if (depth == limit) {
            set.add(num); // Set에 숫자 추가
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(depth + 1, num * 10 + (number.charAt(i) - '0'), limit);
                visit[i] = false;
            }
        }
    }
    
    // 소수인지 확인
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
