class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int ans=0;
        int t=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') t++;
            else ans++;
        }
        int cnt=1;
        for(;;cnt++) {
            if(t==1) break;
            int t2=0;
            while(t!=0) {
                if(t%2==1) t2++;
                else ans++;
                t/=2;
            }
            t=t2;
        }
        
        return new int[]{cnt,ans};
    }
}
