import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 입력 범위가 1000이라 쌩으로 돌려도 충분 할 것 같다.
        // map으로 풀면 간단할 것 같다.
        // 결국에는 교집합 합집하의 원소 갯수 비교다.
        // {1,1,2,2,3} {1,2,2,4,5}
        // 1:2  1:1
        // 2:2  2:2
        // 3:1  4:1
        //      5:1
        // 교집합은 어떻게? mapA 돌면서 mapB에 key값 검색
        // key값 존재하면 갯수 비교 후 cnt에 둘 중에 더 작은 수 +
        // key값 존재하지 않으면 패스 이렇게 하면 교집합 갯수 3이 바로 나온다.
        // 합집합은 어떻게?, 이게 문제다.
        // 방1. 빈map 하나 만들어서 mapA, mapB 둘다 추가 or 그냥 mapA 카피떠서 시작
        // 방2. 둘 중 한쪽으로 합치고 람다로 처리
        // mapA mapB 2개를 병합하고 람다식으로 Math.max로 큰 값만 살린다.
        // mapA.forEach((key, value) -> mapB.merge(key, value, (a, b) -> Math.max(a, b)))
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> mapA = new HashMap<>();
        HashMap<String, Integer> mapB = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String key = str1.substring(i, i + 2);
            if (key.matches("[a-z]{2}")) {
                mapA.put(key, mapA.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String key = str2.substring(i, i + 2);
            if (key.matches("[a-z]{2}")) {
                mapB.put(key, mapB.getOrDefault(key, 0) + 1);
            }
        }

        int inter = 0;
        int union = 0;

        for (String key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                inter += Math.min(mapA.get(key), mapB.get(key));
            }
        }

        HashMap<String, Integer> unionMap = new HashMap<>(mapB);
        for (String key : mapA.keySet()) {
            unionMap.put(key, Math.max(unionMap.getOrDefault(key, 0), mapA.get(key)));
        }
        for (int value : unionMap.values()) {
            union += value;
        }

        if (union == 0) return 65536;
        return (int) ((double) inter / union * 65536);
    }
    // 합집합 교집합 연산 과정을 한번에도 처리가 가능할 듯?, 필터링 직접 짜면 좀 걸리겠구나
    // 입력 범위가 더 길 때는 어떻게 해야 되지?
    // 체크 21:30 ~ 56:40
}