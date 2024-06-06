import java.util.*;
class Solution {
    static String[] sh = {"C#", "D#", "F#", "G#", "A#"};
    static String[] lc = {"c", "d", "f", "g", "a"};
    public String solution(String m, String[] musicinfos) {
        String ans = "(None)";
        m = parse(m);
        ArrayList<String[]> ls = new ArrayList<>();
        int t = 0;
        for (String i : musicinfos) {
            String[] in = i.split(",");
            in[3] = parse(in[3]);
            int tt = time(in[1].split(":")) - time(in[0].split(":"));
            String ts = ch(tt, in[3]);
            if (find(ts, m)) ls.add(new String[]{String.valueOf(tt), in[2], String.valueOf(t++)});
        }
        if (ls.size() != 0) {
            Collections.sort(ls, (o1,o2) -> {
                if (o1[0]==o2[0]) return Integer.valueOf(o1[2]) - Integer.valueOf(o2[2]);
                return Integer.valueOf(o2[0]) - Integer.valueOf(o1[0]);
            });
            ans = ls.get(0)[1];
        }
        return ans;
    }
    static String parse(String m) {
        for (int i = 0; i < sh.length; i++) m = m.replace(sh[i], lc[i]);
        return m;
    }
    static boolean find(String ts, String m) {
        for (int en = m.length(),s=0; en <= ts.length(); en++,s++) {
            String t = ts.substring(s, en);
            if (t.equals(m)) return true;
        }
        return false;
    }
    static int time(String[] t) {
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
    static String ch(int t, String s) {
        String res = "";
        for (int i = 0; i < t / s.length(); i++) res += s;
        res += s.substring(0, t % s.length());
        return res;
    }
}
