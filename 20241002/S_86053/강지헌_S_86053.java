class Solution {
    public long solution(int a,int b,int[] g,int[] s,int[] w,int[] t) {
        long l=0,r=1000000000000000L;
        while (l+1<r) {
            long m=(l+r)/2;
            if(chk(m,a,b,g,s,w,t)) r=m;
            else l=m;
        }
        return r;
    }
    public boolean chk(long time,int a,int b,int[] g,int[] s,int[] w,int[] t) {
        long oh=0L, gh=0L, sh=0L;
        for(int i=0; i<g.length; i++) {
            long cnt=time/(2*t[i]);
            if(time%(2*t[i])>=t[i]) cnt++;
            long l=Math.min(cnt*w[i],g[i]+s[i]);
            oh+=l;
            gh+=Math.min(l,g[i]);
            sh+=Math.min(l,s[i]);
        }
        return (oh>=a+b) && (gh>=a) && (sh>=b);
    }
}
