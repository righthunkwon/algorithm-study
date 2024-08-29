// 문제: 12909번 (올바른괄호)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909
class Solution {
    boolean solution(String s) {
        char[] input = s.toCharArray();
        int open = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                open++;
            } else {
                open--;
                if (open < 0) {
                    return false; // ')'가 먼저 나오는 경우
                }
            }
        }
        return open == 0;
    }
}