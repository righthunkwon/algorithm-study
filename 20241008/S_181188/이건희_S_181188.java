import java.util.*;
// 단속카메라랑 비슷한 문제, 풀어 보기 => https://school.programmers.co.kr/learn/courses/30/lessons/42884
class Solution {
    public int solution(int[][] targets) {
        // 이런 입력 범위면 N으로 풀어야 하니 DP or greedy 여기서는 greedy
        // 폭격 미사일 구간을 어떻게 정렬하면 좋을지?
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        // 요격 미사일을 어디에 발사해야 가장 많은 요격 미사일을 요격할 수 있을까?
        // 범위 맨끝으로 발사하는 방식으로 그리디
        int answer = 0;
        int co = 0;
        for(int[] el : targets){
            if(co > el[0]) continue;// 위에서 정렬이 끝나서 좌표보다 큰 범위는 없어도 될듯
            answer++;
            co = el[1];
            // 문제에서 양 끝 좌표에서는 미사일 안나간다고 하기는 했는데, el[1]-0.00000001 이거 할 필요 없이 el[1] 때려도 문제 없다.
            // 일단 주어진 테게에서는 문제 없음
        }
        return answer;
    }
}