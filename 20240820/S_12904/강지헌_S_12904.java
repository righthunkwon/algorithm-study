class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        for(int i=0;i<s.length();i++) {
            for(int t=1;i-t>=0 && i+t<s.length();t++) {
                if(s.charAt(i-t)!=s.charAt(i+t)) break;
                answer=Math.max(answer,t*2+1);
            }
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)) {
                answer=Math.max(2,answer);
                for(int t=1;i-t>=0 && i+t+1<s.length();t++) {
                    if(s.charAt(i-t)!=s.charAt(i+t+1)) break;
                    answer=Math.max(answer,t*2+2);
                }
            }
        }
        return answer;
    }
}
