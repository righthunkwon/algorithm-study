import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, Integer> posCount = new HashMap<>();// 로봇 수 카운트
        Map<Integer, int[]> pointMap = new HashMap<>();// 포인트 번호, 좌표 매핑
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }
        // 이동처리
        for (int i = 0; i < routes.length; i++) {
            move(pointMap, routes[i], posCount);
        }
        // 위험 상황 계산
        for (int count : posCount.values()) {
            if (count >= 2) answer += 1; 
        }
        return answer;
    }
    
    private void move(Map<Integer, int[]> pointMap, int[] route, Map<String, Integer> posCount) {
        int time = 0;
        int[] currentPos = pointMap.get(route[0]).clone();
        recordPos(time, currentPos, posCount);// 시작, 시간0
        for (int i = 1; i < route.length; i++) {
            int[] nextPos = pointMap.get(route[i]);
            //r 좌표 먼저 이동
            while (currentPos[0] != nextPos[0]) {
                if (currentPos[0] < nextPos[0]) {
                    currentPos[0]++;
                } else {
                    currentPos[0]--;
                }
                time++;
                recordPos(time, currentPos, posCount);
            }
            //c 좌표 이동
            while (currentPos[1] != nextPos[1]) {
                if (currentPos[1] < nextPos[1]) {
                    currentPos[1]++;
                } else {
                    currentPos[1]--;
                }
                time++;
                recordPos(time, currentPos, posCount);
            }
            // 마지막 포인트 정지
        }
    }
    // key 값 처리
    private void recordPos(int time, int[] Pos, Map<String, Integer> posCount) {
        String key = time + "_" + Pos[0] + "_" + Pos[1];
        posCount.put(key, posCount.getOrDefault(key, 0) + 1);
    }
    // 이 방법 보다는 객체 선언해서 
    // Objects.hash(r, c);
    // 해서 해쉬 값으로 구분하는게 맞는 듯
    // 1. 물류 센터 내의 포인트 번호와 좌표 매핑
    // 2. move로 posCount에 이동 시간과 좌표 매칭
    // 3. 키값 구분되도록 값 3개 사용해서 유일하게 만들기
    // 4. 나중에 같은 시간에 같은 좌표에 몇 대의 로봇이 있었는지를 누적 계산
    // 5. 2대 이상의 로봇이 모였다면 위험 상황이 발생
    // 6. 그 갯수 모아서 반환
}