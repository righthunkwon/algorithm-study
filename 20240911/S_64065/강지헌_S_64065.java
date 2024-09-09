import java.util.*;
class Solution {
    public Set<Integer> solution(String s) {
        Set <Integer> set = new LinkedHashSet<>();
        String[] str = s.split("[{|}]");
        Arrays.sort(str, (o1,o2)->o1.length()-o2.length());
        for(String a : str) {
            for(String b : a.split("(,)"))
                if(b.matches("[0-9]+")) set.add(Integer.parseInt(b));
        }
        return set;
    }
}
