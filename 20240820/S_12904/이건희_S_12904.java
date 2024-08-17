// 문제: 12904번 (가장 긴 펠린드롬)
// 등급: Level 3
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12904
// [풀이] 
// 2500 * 2500? 완탐 가능
// 팰린드롬이 예시에는 홀수 종류만 나왔지만, 짝수 펠린드롬도 가능
// 문자열의 길이는 1~2500
// 2차 코드
class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;
        int answer = 1; // 최소 팰린드롬 길이는 1
        char[] input = s.toCharArray();

        for (int i = 0; i < n; i++) {
            // 홀수 길이 팰린드롬
            answer = Math.max(answer, cal(input, i, i));
            // 짝수 길이 팰린드롬
            if (i < n - 1 && input[i] == input[i + 1]) {
                answer = Math.max(answer, cal(input, i, i + 1));
            }
        }
        return answer;
    }
    private int cal(char[] input, int l, int r) {
        int length = 0;
        while (l - length >= 0 && r + length < input.length && input[l - length] == input[r + length]) {
            length++;
        }
        length--;
        return (r - l) + 2 * length; // 홀수 면 +1, 짝수면 +0
    }
}
// 1차 코드
class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;
        int answer = 1; // 최소 길이 1
        char[] input = s.toCharArray();
        for (int i = 0; i < n; i++) {
            // 짝수 길이 팰린드롬 체크
            if (i < n - 1 && input[i] == input[i + 1]) {
                int length = 0;
                boolean flag = false;
                while (!flag) {
                    if (i - length >= 0 && i + 1 + length < n && input[i - length] == input[i + 1 + length]) {
                        length++;
                    } else {
                        flag = true;
                        length--; 
                    }
                }
                answer = Math.max(answer, length * 2 + 2);
            }

            // 홀수 길이 팰린드롬 체크
            int length = 0;
            boolean flag = false;
            while (!flag) {
                if (i - length >= 0 && i + length < n && input[i - length] == input[i + length]) {
                    length++;
                } else {
                    flag = true;
                    length--;
                }
            }
            answer = Math.max(answer, length * 2 + 1);
        }
        return answer;
    }
}