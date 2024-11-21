class Solution {
    public long solution(int[] sequence) {
        boolean f=true;
        long a=0,b=0,answer=0;
        for(int i:sequence) {
            a+=f?i:-i;
            b+=f?-i:i;
            a=Math.max(0,a);
            b=Math.max(0,b);
            answer=Math.max(answer,Math.max(a,b));
            f=!f;
        }
        return answer;
    }
}
