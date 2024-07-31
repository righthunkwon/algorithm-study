import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[genres.length];
        int n = genres.length;
        // 맵두개써서 하나는 장르랑 총 개수
        // 나머지 하나는 장르랑 index 번호
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        Map<String, List<int[]>> index = new HashMap<>();
        
        // 먼저 장르별로 재생횟수 다 넣어놓음
        // 추가로 리스트도 넣음
         for(int i=0; i<genres.length; i++){
            cnt.put(genres[i] , cnt.getOrDefault(genres[i],0)+plays[i]);
            // 리스트 하나 선언해놓고 장르별로 하나씩 추가             
            List<int[]> arr = index.get(genres[i]);
            if(arr == null){
                arr = new ArrayList<>();
            } 
            arr.add(new int[]{i, plays[i]});
            index.put(genres[i], arr);
        }
        // 일단 이제 다 추가했으니
        // 정렬을 시켜야함
        // 맵하나 더만들어서 옮기면서 정렬해보자
        
        Map<String, Integer> sorted = sortTotalPlay(cnt);
        List<Integer> result = new ArrayList<>();
        
        for(String genre : sorted.keySet()) {
            List<int[]> entry = index.get(genre);
            entry.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] > o2[1]) return -1;
                    else if (o1[1] < o2[1]) return 1;
                    else {
                        return Integer.compare(o1[0], o2[0]);
                    }
                }
            });
            result.add(entry.get(0)[0]);
            if(entry.size() > 1) {
                result.add(entry.get(1)[0]);
            }
        }
 
        // Re-type.
        answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }
 
        return answer;
    }
 
    public static LinkedHashMap<String, Integer> sortTotalPlay (Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entry = new LinkedList<>(map.entrySet());
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
 
        entry.sort((o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
 
        for (Map.Entry<String, Integer> iter : entry) {
            result.put(iter.getKey(), iter.getValue());
        }
 
        return result;
    }

}
