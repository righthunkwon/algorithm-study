import java.util.*;
 
class Solution {
    int[][] result;
    int t1=0,t2=0;
    public int[][] solution(int[][] nodeinfo) {
        Node[] n = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) n[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        Arrays.sort(n, (o1,o2) -> {
            if(o1.y==o2.y) return o1.x-o2.x;
            return o2.y-o1.y;
        });
        
        Node root = n[0];
        for(int i = 1; i < n.length; i++) ins(root, n[i]); 
        result = new int[2][nodeinfo.length];
        dfs(root);
        return result;
    }
    
    public void ins(Node p, Node no) {
        if(p.x > no.x) {
            if(p.l == null) p.l = no;
            else ins(p.l, no);
        }
        else {
            if(p.r == null) p.r = no;
            else ins(p.r, no);
        }
    }
    

    public void dfs(Node root) {
        if(root != null) {
            result[0][t1++] = root.c;
            dfs(root.l);
            dfs(root.r);
            result[1][t2++] = root.c;
        }
    }
    public class Node {
        int x, y, c;
        Node l, r;
        public Node(int x, int y, int c, Node l, Node r) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.l = l;
            this.r = r;
        }
    }
}
