// 중복되는 원소가 없다고 가정했기 때문에 간단하게 풀 수 있다.
// 입력된 숫자의 갯수를 누적하면 그게 결과 순서다
// "{{2},{2,1},{2,1,3},{2,1,3,4}}" => 2 4개 1 3개 3 2개 4 1개
// 결과 {2,1,3,4}
// map으로 풀기
import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] tmp = s.replaceAll("[{}]", "").split(",");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < tmp.length; i++){
            map.put(tmp[i],map.getOrDefault(tmp[i],0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b).compareTo(map.get(a)));
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}