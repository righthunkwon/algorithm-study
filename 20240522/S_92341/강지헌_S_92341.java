import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    private static Map<Integer, LocalTime> park = new HashMap<>(); 
    private static Map<Integer, Integer> time = new HashMap<>(); 
    public int[] solution(int[] fees, String[] records) {
        
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
        for (String str : records) {
            String[] arr = str.split(" ");
            LocalTime t = LocalTime.parse(arr[0], dt);
            int c = Integer.parseInt(arr[1]);
            if (park.containsKey(c)) {
                TimeCalc(c, t);
                park.remove(c);
            } else park.put(c, t);
        }

        if (!park.isEmpty()) {
            for (int k : park.keySet()) {
                TimeCalc(k, LocalTime.parse("23:59", dt));
                park.remove(k);
            }
        }

        List<Integer> key = new ArrayList<>(time.keySet());
        Collections.sort(key);

        int[] answer = new int[key.size()];
        for (int i = 0; i < key.size(); i++) {
            int t = time.get(key.get(i));
            if (t <= fees[0]) answer[i] = fees[1];
            else answer[i] = fees[1] + ((t - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
        }
        return answer;
    }

    private void TimeCalc(int c, LocalTime out) {
        LocalTime in = park.get(c);
        long value = Duration.between(in, out).toMinutes();
        time.put(c, time.getOrDefault(c, 0) + (int) value);
    }
}
