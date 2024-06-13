import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // 일단 k진수로 변환한 후에
        // 왼쪽에서부터
        // 짤라서 0이나올때까지 소수 판정
        
        // 소수확인을 위해서는 2가지가 필요함
        // 1. 1보다 큰 자연수인지
        // 2. 1이외의 수로 안나눠져야함
        
        // 일단 변환하고 수로 나눠서 확인
        String word = change(n,k);
        // word에서 이제 나누는과정 ㄱ
        int j = 0;
        for (int i = 0; i < word.length() - 1; i = j) {
            // 하나씩 시작점을 잡고 0을 제외하고 단어를 1자리에서 j전까지 자름
            // 그 숫자가 소수인지 확인
            for (j = i + 1; j < word.length() && word.charAt(j) != '0'; j++) ;
            if (solve(Long.parseLong(word.substring(i, j))))
                answer++;
        }
        return answer;
    }
    
    
    public static String change(int n, int k){
         StringBuilder str = new StringBuilder();
        // n으로 계속 나눈 나머지를 하나씩 더하면서
        // k진수로 변환
        while (n > 0) {
            str.append(n % k);
            n /= k;
        }
        // 리버스해서 리턴
        return str.reverse().toString();
    }
    // 소수판단
    // 2에서 현재 숫자까지 나눠떨어지면 안됨 !!
    public static boolean solve(long num){
        if (num <= 1) {
            return false;
        }
        // numb이 1이면 종료
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
}
