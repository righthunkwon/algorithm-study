import java.util.*;
class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean chk[];
    public String[] solution(String[][] tickets) {
        chk = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    static void dfs(int d, String s, String a, String[][] arr){
        if (d == arr.length) {
            list.add(a);
            return;
        }
        for (int i = 0; i < chk.length; i++) {
            if (!chk[i] && s.equals(arr[i][0])) {
                chk[i]=true;
                dfs(d+1,arr[i][1],a+" "+arr[i][1], arr);
                chk[i]=false;
            }
        }
    }
}
