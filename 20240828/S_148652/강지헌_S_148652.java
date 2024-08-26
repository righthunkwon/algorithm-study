class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for (long i=l-1;i<r;i++) if (check(i)) answer++;
        return answer;
    }

    boolean check(long l) {
        if (l<5 && l!=2) return true;
        if ((l-2)%5==0) return false;
        return check(l/5);
    }
}
