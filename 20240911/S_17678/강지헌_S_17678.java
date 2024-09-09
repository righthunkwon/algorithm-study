import java.util.*;
class Solution {
    PriorityQueue<Integer> Q = new PriorityQueue<>();
    public String solution(int n, int t, int m, String[] tt) {
        for (String time : tt) {
            String[] st=time.split(":");
            Q.add(Integer.parseInt(st[0])*60+Integer.parseInt(st[1]));
        }
        int busTime=540, lastCrew=0, cnt=0, myTime=0;
        for (int i=0;i<n;i++) {
            cnt=0;
            while (!Q.isEmpty() && Q.peek()<=busTime && cnt!=m) {
                cnt++;
                lastCrew=Q.poll();
            }
            busTime+=t;
        }
        if (cnt==m) myTime=lastCrew-1;
        else myTime=busTime-t;
        return String.format("%02d", myTime/60)+":"+String.format("%02d", myTime%60);
    }
}
