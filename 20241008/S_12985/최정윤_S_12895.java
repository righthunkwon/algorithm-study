class Solution
{
    public int solution(int n, int a, int b)
    {
        //2로 나눠보면서 같은 범위에 있을 때 dep저장
        //총 라운드 수
        cnt=0;
        this.a=a;
        this.b=b;
        int n1=n;
        while(n1>1){ //2의 몇제곱인지 
            n1=n1/2;
            cnt++;
        }
        answer = cnt;
        max_dep=0;
        dfs(1,n,0,n);
        return answer-max_dep;
    }
    public static void dfs(int st,int ed,int dep,int n){
        if(n<1||st>=ed) return;
        if(a>=st&&a<=ed&&b>=st&&b<=ed){
            max_dep=Math.max(max_dep,dep); //같은 범위에 포함되는 최대 dep 구하기
        }
        dfs(st,st+n/2-1,dep+1,n/2);
        dfs(ed-n/2+1,ed,dep+1,n/2);              
    }
    static int answer,a,b,cnt,max_dep;
}
