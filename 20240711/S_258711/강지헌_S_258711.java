import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer,Integer> out = new HashMap<>(), in = new HashMap<>();
        int[] ans=new int[4];
        for (int[] i:edges) {
            out.put(i[0],out.getOrDefault(i[0],0)+1);
            in.put(i[1],in.getOrDefault(i[1],0)+1);
        }
        for(int i:out.keySet()) {
            if(out.get(i)>1) {
                if(!in.containsKey(i)) ans[0]=i;
                else ans[3]+=1;
            }
        }
        for (int i:in.keySet()) {
            if (!out.containsKey(i)) ans[2] += 1;
        }
        ans[1]=out.get(ans[0])-ans[2]-ans[3];
        return ans;
    }
}
