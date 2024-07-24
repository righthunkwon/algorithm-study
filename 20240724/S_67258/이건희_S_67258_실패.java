// 투 포인터로 푸는 거구나!!! 는 생각이 났는데 
// 코드 생각이 안나가지고.....
// 구현 실패해서 코드 참고했습니다.
import java.util.*;
class Solution {
    public int[] solution(String[] 보석리스트) {
        // 실제 보석 종류 수 체크
        int 보석종류 = new HashSet<>(Arrays.asList(보석리스트)).size();
        // 정답 출력이 [시작,끝]이라
        int[] answer = new int[2];
        // 지금까지 찾은 최단구간길이 저장 할 변수
        int 최단길이 = Integer.MAX_VALUE, 시작 = 0;
        // 해당 보석이 몇개가 있는지 저장 할 맵 함수, 보석맵 길이로 보석 종류가 전부 갖춰 졌는지 판단
        Map<String, Integer> 보석맵 = new HashMap<>();
        for (int 끝 = 0; 끝 < 보석리스트.length; 끝++) {
            // 투 포인터 오른쪽(끝) 이동 탐색
            보석맵.put(보석리스트[끝], 보석맵.getOrDefault(보석리스트[끝], 0) + 1);
            // 투 포인터 왼쪽(시작) 이동 탐색
            while (보석맵.get(보석리스트[시작]) > 1) {
                보석맵.put(보석리스트[시작], 보석맵.get(보석리스트[시작]) - 1);
                시작++;
            }
            // 모든 보석 종류가 포함되었는지 체크 후 최단경로길이 업데이트
            if (보석맵.size() == 보석종류 && 최단길이 > (끝 - 시작)) {
                length = 끝 - 시작;
                answer[0] = 시작 + 1;
                answer[1] = 끝 + 1;
            }
        }
        return answer;
    }
}