// 징검다리건너기
// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// 첫 시도
// 실제로 1명씩 다 건너게 시킴
// 정확성 성공, 효율성 실패
class Solution {
    public int solution(int[] stones, int k) {
        int count = 0; // 건널 수 있는 친구들의 수

        while (true) {
            int current = 0; // 현재 디딤돌의 위치
            int steps = 0; // 연속으로 넘어간 최대 거리

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > 0) { // 현재 디딤돌이 아직 밟을 수 있다면
                    stones[i]--; // 디딤돌 밟고 값을 줄임
                    steps = 0; // 연속 건너뛴 거리 초기화
                } else { // 현재 디딤돌을 밟을 수 없다면
                    steps++; // 건너뛰어야 하므로 거리 증가
                    if (steps == k) { // k만큼 연속으로 건너뛸 수 없다면
                        return count; // 현재까지 건넌 사람 수 반환
                    }
                }
            }

            count++; // 이번 라운드에서 한 명이 건넜으므로 카운트 증가
        }
    }
}
// 이차 시도
// 이진탐색 사용
// 정확성 성공, 효율성 성공
class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; // 최소 1명은 건널 수 있음
        int right = 200000000; // stones의 원소 최대값
        int answer = 0; // 최대 건널 수 있는 사람
        while (left <= right) {
            int mid = (left + right) / 2; // 중간값 계산, 현재 시도할 사람 수
            if (check(stones, k, mid)) {
                answer = mid; // 중간 값 이 건널 수 있으면, 답을 업데이트
                left = mid + 1; // 더 많은 사람도 시도해 볼 수 있으므로 범위를 늘림
            } else {
                right = mid - 1; // 중간 값 이 건널 수 없으면, 사람 수를 줄임
            }
        }
        return answer; // 계산된 최대 인원 반환
    }

    private boolean check(int[] stones, int k, int num) {
        int count = 0; // 연속된 디딤돌의 내구도가 num 명을 견디지 못하는 개수
        for (int stone : stones) {
            if (stone - num < 0) { // 디딤돌의 내구도가 num 명보다 작으면
                count++; // 연속 카운트 증가
            } else {
                count = 0; // 하나라도 견딜 수 있으면 리셋
            }
            if (count == k) return false; // k 개의 연속된 디딤돌이 모두 num 명을 견디지 못하면 건널 수 없음
        }
        return true; // 모든 검사를 통과하면 num 명이 건널 수 있음
    }
}
