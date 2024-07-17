class Solution {
    static int max;
    static int[] v , answer = {-1};
    public int[] solution(int n, int[] info) {
        v = new int[info.length];
        dfs(-1,n,info);
        return answer;
    }
    public void dfs(int d, int n, int[] info) {
        if(d == info.length-1 || n <= 0) {
            if(n > 0) v[10] = n;
            int ap = 0, ri = 0;
            for(int i = 0; i < v.length; i++) {
                if(v[i] > info[i]) ri += (10-i);
                else if(info[i] > 0) ap += (10-i);   
            }
            if(ri > ap) {
                if(max < ri-ap) {
                    answer = v.clone();
                    max = ri-ap;
                }
                else if(max == ri-ap) {
                    for(int i = 10; i >= 0; i--) {
                        if(answer[i] > v[i]) break;
                        else if(answer[i] < v[i]) {
                            answer = v.clone();
                            break;
                        }
                    }
                }
            }
            v[10] = 0;
            return;
        }
        for(int i = d+1; i < info.length; i++) {
            if(n > info[i]) {
                v[i] = info[i]+1;
                dfs(i,n-v[i],info);
                v[i] = 0;
            }
            else if(i+1==info.length) dfs(i,n,info);
        }
    }
}
