import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Long> sum = new HashMap<>();
        HashMap<String, ArrayList<int[]>> arr = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int size = plays.length;
        for(int i = 0; i < size; i++) {
            String name = genres[i];
            int play = plays[i];
            sum.put(name, sum.getOrDefault(name, 0L) + play);
            if(arr.containsKey(name)) arr.get(name).add(new int [] {i, play});
            else {
                ArrayList<int[]> t = new ArrayList<>();
                t.add(new int[] {i, play});
                arr.put(name, t);
            }
        }
        List<Map.Entry<String, Long>> c = sum.entrySet().stream().sorted((o1, o2) -> { return o2.getValue().compareTo(o1.getValue()); }).collect(Collectors.toList());
        for(int i = 0; i < sum.size(); i++) {
            Map.Entry<String, Long> entry = c.get(i);
            ArrayList<int[]> t = arr.get(entry.getKey());
            Collections.sort(t, (o1, o2) -> { return -(o1[1] - o2[1]); });
            for(int j = 0; j < t.size(); j++){
                if(j == 2) break;
                int [] check = t.get(j);
                list.add(check[0]);
            }
        }
        int[] answer = new int [list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}
