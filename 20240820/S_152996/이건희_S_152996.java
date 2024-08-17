// 문제: 152996번 (시소 짝꿍)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/152996
// [풀이] 
// 100,000 N2완탐으로는 불가능
// 토크로 환산해서 N:1 경우의 수 누적으로 풀기
// 2차 코드
class Solution {
    public long solution(int[] weights) {
        long result = 0;
        long[] torque = new long[4001];
        for (int weight : weights) {
            result += torque[weight];// 1:1
            result += torque[weight * 2];// 4:2
            if (weight % 2 == 0) result += torque[weight / 2];// 2: 4
            if (weight % 3 == 0) result += torque[weight * 2 / 3];// 2:3
            if (weight % 2 == 0) result += torque[weight * 3 / 2];// 3:2
            if (weight % 4 == 0) result += torque[weight * 3 / 4];// 3:4
            if (weight % 3 == 0) result += torque[weight * 4 / 3];// 4:3
            torque[weight]++;
        }
        return result;
    }
}
// 1차 코드
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001];
        long[] torque = new long[4001];
        for (int weight : weights) {
            long tmp = count[weight];
            answer += tmp;
            for(int i = 2; i <= 4; i++){
                int num = weight * i;
                answer += torque[num];
                if (tmp > 0) {
                    answer -= tmp;
                }
                torque[num]++;
            }
            count[weight]++;
        }
        return answer;
    }
}