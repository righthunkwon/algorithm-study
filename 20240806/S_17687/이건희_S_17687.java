class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder nums = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        // 변환해서 전부 추가
        for (int i = 0; nums.length() < t * m; i++) {
            nums.append(Integer.toString(i, n).toUpperCase());
        }
        // 튜브의 순서 p에 맞는 숫자를 선택하여 answer 문자열에 추가
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(nums.charAt(i));
        }
        return answer.toString();
    }
}