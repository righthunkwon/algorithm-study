import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] chk = new boolean[words.length];
        Queue<data> q = new LinkedList<>();
        q.add(new data(begin, 0));
        while(!q.isEmpty()) {
            data t=q.poll();
            if(t.a.equals(target)) return t.b;
            for (int i=0;i<words.length;i++) {
                if (chk[i] || !isConvertable(t.a.toCharArray(), words[i].toCharArray())) continue;
                chk[i] = true;
                q.add(new data(words[i], t.b + 1));
            }
        }
        return 0;
    }
    public boolean isConvertable(char[] b, char[] t) {
        int c=0;
        for (int i=0;i<b.length;i++) if(b[i]!=t[i]) c++;
        return c==1;
    }
}
class data {
    String a;
    int b;
    data(String a, int b) {
        this.a = a;
        this.b = b;
    }
}
