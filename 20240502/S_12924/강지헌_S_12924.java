class Solution {
    public int solution(int n) {
        int answer = 0;
        int s=1,e=1,m=1;
        while(s<=n) {
            if(m==n) answer++;
            if(m>n) m-=s++;
            else m+=++e;
        }
        return answer;
    }
}
