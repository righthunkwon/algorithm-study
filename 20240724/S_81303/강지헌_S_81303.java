import java.util.*;
class Solution {
    static List<List<Node>> arr = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) arr.add(new ArrayList<>());
        for (int[] i : fares) {
            arr.get(i[0]).add(new Node(i[1], i[2]));
            arr.get(i[1]).add(new Node(i[0], i[2]));
        }
        int[] aa=new int[n+1],bb=new int[n+1],cc=new int[n+1];
        for(int i=0;i<=n;i++) {
            aa[i]=Integer.MAX_VALUE;
            bb[i]=Integer.MAX_VALUE;
            cc[i]=Integer.MAX_VALUE;
        }
        aa = di(a, aa);
        bb = di(b, bb);
        cc = di(s, cc);
        for(int i=1;i<=n;i++) answer = Math.min(answer, aa[i]+bb[i]+cc[i]);
        return answer;
    }

    public int[] di(int s, int[] co) {
        PriorityQueue<Node> Q = new PriorityQueue<>((o1,o2) -> {
            return o1.c-o2.c;
        });
        Q.add(new Node(s, 0));
        co[s] = 0;
        while (!Q.isEmpty()) {
            Node t = Q.poll();
            if (t.c>co[t.x]) continue;
            List<Node> edges = arr.get(t.x);
            for (Node e : edges) {
                int tt = e.c + co[t.x];
                if (tt < co[e.x]) {
                    co[e.x] = tt;
                    Q.add(new Node(e.x, tt));
                }
            }
        }
        return co;
    }
}
class Node {
    int x;
    int c;
    Node(int x, int c) {
        this.x = x;
        this.c = c;
    }
}
