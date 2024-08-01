import java.util.*;
class Solution {
    public int[] solution (String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String,String> r = new HashMap<>();
        Map<String,Integer> sum = new HashMap<>();
        for(int i=0;i<enroll.length;i++) {
            if(referral[i].equals("-")) r.put(enroll[i],"center");
            else r.put(enroll[i],referral[i]);
            sum.put(enroll[i],0);
        }
        for(int i=0;i<seller.length;i++) {
            String c = seller[i], p = r.get(seller[i]);
            int m = amount[i]*100;
            while(true) {
                sum.put(c,sum.get(c) + m - m / 10);
                m /= 10;
                if(m == 0 || p.equals("center")) break;
                c = p;
                p = r.get(c);
            }
        }
        for(int i=0;i<enroll.length;i++) answer[i] = sum.get(enroll[i]);
        return answer;
    }
}
