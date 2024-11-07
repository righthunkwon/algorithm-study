import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] sum = new int[N+2],ans=new int[N];
        for(int i=0;i<stages.length;i++) sum[stages[i]]++;
        for(int i=N;i>=1;i--) sum[i]+=sum[i+1];
        double[][] f = new double[N+1][2];
        for(int i=1;i<=N;i++) {
            f[i][0]=sum[i]==0?0:(double)(sum[i]-sum[i+1])/sum[i];
            f[i][1]=i;
        }
        int t=0;
        Arrays.sort(f,(o1,o2) -> o1[0]==o2[0]?o1[1]<o2[1]?-1:1:o1[0]<o2[0]?1:-1);
        for(int i=0;i<=N;i++) {
            if(f[i][1]!=0) ans[t++]=(int)f[i][1];
        }
        return ans;
    }
}
