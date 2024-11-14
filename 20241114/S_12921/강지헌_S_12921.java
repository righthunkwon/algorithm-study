class Solution {
    public int solution(int n) {
        int[] a=new int[1000001];
        boolean[] pr=new boolean[1000001];
        for(int i=2;i<=1000;i++) {
            if(pr[i]) continue;
            for(int j=i*2;j<=1000000;j+=i) pr[j]=true;
        }
        for(int i=2;i<=1000000;i++) a[i]=pr[i]?a[i-1]:a[i-1]+1;
        return a[n];
    }
}
