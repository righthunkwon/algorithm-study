import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 전체 스테이지 머문환자를 기준으로 +해놓고
        // 해당 +된 수를 역으로 총 도전자의 수를 계산
        double[] num = new double[N+1];
        // 정렬해서 해당숫자에 해당하는 사람들의 수를 count
        // -> 전체수를 미리 구하고 해당 라운드 인원이 정해지면 다음 라운드는 전체수에서 빼서기록 
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            // 현재 스테이지에 머무르고 있는 플레이어 수
            int count = 0; 
            // 우선 현재 스테이지에 머무른 유저수를 count해서
            // 전체수를 비교해 실패율 계산
            for (int stage : stages) {
                if (stage == i) {
                    count++;
                }
            }
            // 실패율 계산
            if (total > 0) {
                num[i] = (double) count / total;
                total -= count; 
                // 다음 스테이지에서는 현재 스테이지에 머문 플레이어를 제외
            } else {
                num[i] = 0;
            }
        }
        // 이제 각 라운드마다 실패율을 비교하여 순서 정하면된다.
        List<Integer> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            stageList.add(i);
        }
        // 순서를 비교해서 정렬해 몇번째인지 확인
        stageList.sort((a, b) -> Double.compare(num[b], num[a]));

        // 정렬된 스테이지 번호를 answer 배열에 복사
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i);
        }
        
        return answer;
    }
}
