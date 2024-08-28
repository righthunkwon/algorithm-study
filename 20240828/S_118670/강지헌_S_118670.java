import java.util.*;
class Solution {
    public static Deque<Integer> l = new LinkedList<>(), r = new LinkedList<>();
    public static Deque<Deque<Integer>> m = new LinkedList<>();
    public int[][] solution(int[][] rc, String[] operations) {
        int x=rc.length, y=rc[0].length;
        for(int i=0;i<x;i++) {
            m.addLast(new LinkedList<>());
            for(int j=0;j<y;j++) {
                if(j==0) l.add(rc[i][j]);
                else if(j==y-1) r.add(rc[i][j]);
                else m.peekLast().addLast(rc[i][j]);
            }
        }
        for(String o : operations) {
            if(o.equals("Rotate")) {
                m.peekFirst().addFirst(l.removeFirst());
                r.addFirst(m.peekFirst().removeLast());
                m.peekLast().addLast(r.removeLast());
                l.addLast(m.peekLast().removeFirst());
            }
            else {
                l.addFirst(l.removeLast());
                r.addFirst(r.removeLast());
                m.addFirst(m.removeLast());
            }
        }
        int[][] answer = new int[x][y];
        for(int i=0;i<x;i++) {
            int j=0;
            answer[i][j++]=l.pollFirst();
            for(int t : m.pollFirst()) answer[i][j++]=t;
            answer[i][j]=r.pollFirst();
        }
        return answer;
    }
}
