import java.util.*;

class Solution {
    public int[] solution(String s) {
        // map 만들어서 등장하는 숫자마다 횟수 +1하고
        // 많은 숫자부터 출력하면 될듯
        
        HashMap<String, Integer> hm = new HashMap<>();
        // 맨 끝의 {와 , }는 벗겨내고 
        // },{ 앞의 문자를 기준으로 split 진행해서 숫자만 남게함
        String line = s.substring(2, s.length()-2);
        String[] arr = line.split("},\\{");  // //를 붙여야 가능
        
        for(int i = 0;i<arr.length;i++){
            // 하나의 배열안에서 또 ,를 기준으로 split해야함
            String[] arr2 = arr[i].split(",");
            for(int j=0;j<arr2.length;j++){
                hm.put(arr2[j] , hm.getOrDefault(arr2[j], 0) +1);
            }
        }
        // 이렇게 하면 모두 개수 저장완료 
        // 이제 hm에서 큰순서대로 정렬해서 return하면됨
        
        // HashMap을 List로 변환한 후, 값을 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        // 정렬된 순서대로 숫자를 반환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i).getKey());
        }
        
        
        return answer;
    }
}
