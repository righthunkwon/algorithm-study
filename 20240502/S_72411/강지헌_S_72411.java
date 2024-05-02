import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : orders) {
            char[] t = s.toCharArray();
            Arrays.sort(t);
            Map<String, Integer> tmap = dfs(new String(t));
            tmap.forEach((a, b) -> map.merge(a, b, (v1, v2) -> v1 + v2));
        }
        
        Set<String> set = new TreeSet<>();
        for(int c : course) {
            int max = 2;
            Set<String> tset = new TreeSet<>();
            for(String s : map.keySet()) {
                if(s.length() == c) {
                    if(map.get(s) > max) {
                        tset.clear();
                        tset.add(s);
                        max = map.get(s);
                    }
                    else if (map.get(s) == max) tset.add(s);    
                }
            }
            set.addAll(tset);
        }
        
        String[] answer = set.toArray(new String[set.size()]);
        return answer;
        
    }
    
    public Map<String, Integer> dfs(String st) {
        Map<String, Integer> map;
        if(st.length() <= 1) {
            map = new HashMap<>();
            map.put("", 1);
            map.put(st, 1);
        }
        else {
            map = dfs(st.substring(1));
            Map<String, Integer> tmap = new HashMap<>();
            for(String s : map.keySet()) tmap.put(st.substring(0, 1) + s, 1);
            map.putAll(tmap);
        }
        return map;
    }
}
