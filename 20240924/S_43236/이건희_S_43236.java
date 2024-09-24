// 다시 풀기
import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);// 돌들의 위치를 정렬
        int start = 0;// 이분 탐색의 최소 값
        int end = distance;// 이분 탐색의 최대 값
        // 이분 탐색을 거리 기준으로 실행
        while (start <= end) {
            int mid = (start + end) / 2;// 중간 거리 값
            int current = 0;// 현재 위치
            int cnt = 0;// 제거한 돌의 개수
            // 돌들을 순회하면서 mid 값 기준으로 처리
            for (int rock : rocks) {
                int diff = rock - current;// 현재 위치에서 돌과의 거리차
                if (diff < mid) {// 현재 돌과의 거리가 mid보다 작으면 돌을 제거
                    cnt++;
                    if (cnt > n) break;// 돌을 너무 많이 제거했으면 중단
                } else {// 거리가 mid 이상이면 현재 위치를 갱신하고 최소 거리 계산
                    current = rock;
                }
            }
            if (distance - current < mid) cnt++;// 마지막 거리도 고려
            if (cnt > n) {// 제거한 돌의 개수가 n보다 많으면 거리를 줄임
                end = mid - 1;
            } else {// 돌의 개수가 n 이하이면 최소 거리를 늘림
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }
}