class Solution {
    boolean[] pn;
    char[] arr;
    int n,answer;
    public int solution(String numbers) {
        pn = new boolean[10000000];
        pn[0]=true;
        pn[1]=true;
        for(int i=2;i<=1000;i++) {
            if(pn[i]) continue;
            for(int j=i*2;j<10000000;j+=i) pn[j]=true; 
        }
        arr = numbers.toCharArray();
        n=numbers.length();
        dfs(0,0,new boolean[n]);
        return answer;
    }
    void dfs(int l,int t, boolean chk[]) {
        if(l==n) {
            if(!pn[t]) {
                pn[t]=true;
                answer++;
            }
            return;
        }
        for(int i=0;i<n;i++) {
            if(!chk[i]) {
                chk[i]=true;
                dfs(l+1,t*10+arr[i]-'0',chk);
                dfs(l+1,t,chk);
                chk[i]=false;
            }
        }
    }
}
