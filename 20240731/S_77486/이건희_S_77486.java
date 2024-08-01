// 오늘의 단어
// 추천인 -referrer
import java.util.*;
// 트리 밑에서 부터 읽어오면 되는 구조 같은디
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> profitMap = new HashMap<>();  // 판매원별 총 이익을 저장할 맵
        Map<String, String> referrerlMap = new HashMap<>(); // 판매원별 추천인을 저장할 맵

        // 주어진 데이터 값 Map에 전부 주입
        for (int i = 0; i < enroll.length; i++) {
            referrerlMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }

        // 이익은 DFS로 타고 올라오기
        for (int i = 0; i < seller.length; i++) {
            int profit = amount[i] * 100;  // 판매로 인한 총 이익 계산
            dfsProfit(profitMap, referrerlMap, seller[i], profit);
        }

        // 계산된 이익은 결과 배열에 추가
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }

    // 이익을 분배하는 함수
    private void dfsProfit(Map<String, Integer> profitMap, Map<String, String> referrerlMap, String seller, int profit) {
        // 추천인이 없는 경우(막내)도 있어서 DFS 정지 조건
        if (seller.equals("-")) {
            return;
        }
        int commission = profit / 10;  // 추천인에게 줄 커미션 (10%)
        profit -= commission;  // 판매원이 가질 이익

        profitMap.put(seller, profitMap.getOrDefault(seller, 0) + profit); // 현재 판매원의 이익 갱신
        // 추천인에게 커미션 분배
        String referrer = referrerlMap.get(seller);
        if (referrer != null && !referrer.equals("-") && commission > 0) {
            dfsProfit(profitMap, referrerlMap, referrer, commission);
        }
    }
}
// 그냥 반복문으로 푼 사람도 있음
// https://wellbell.tistory.com/159