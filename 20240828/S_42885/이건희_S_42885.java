// 문제: 42885번 (구명보트)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885
// [풀이] 
// 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어진다. 혼자서 꽉 차는 경우는 없다.
// 구명보트는 최대 2명까지
// 50000 * 50000 = 25억 => 완탐 어려움, 투 포인터 값 비교
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); 
        int minIdx = 0;
        int maxIdx = people.length - 1;
        int answer = 0;
        // 정지 조건 => 교차
        while (maxIdx >= minIdx) {
            if (people[maxIdx] + people[minIdx] <= limit) {
                minIdx++;
            }
            maxIdx--;
            answer++;
        }
        return answer;
    }
}