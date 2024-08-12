class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer=0, t=0;
        if(h1*3600+m1*60+s1==0 || h1*3600+m1*60+s1==43200) t=1;
        return cnt(h2,m2,s2)-cnt(h1,m1,s1)+t;
    }
    public int cnt(int h, int m, int s) {
        int total = h*3600+m*60+s;
        int count = (total*59)/3600+(total*719)/43200;
        return h>=12?count-1:count;
    }
}
