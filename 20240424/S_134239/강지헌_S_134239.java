import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> arr = new ArrayList<>();
        List<Double> s = new ArrayList<>();
        arr.add(k);
        for(;;) {
            int t = (k%2==0)?(k/2):(k*3+1);
            arr.add(t);
            s.add((t+k)/2.0);
            if(t==1) break;
            k=t;
        }
        int N = arr.size();
        int M = ranges.length;
        double[] answer = new double[M];
        for(int i=0;i<M;i++) {
            double t=0;
            if(ranges[i][0]<=N-1+ranges[i][1]) {
                for(int j=ranges[i][0];j<N-1+ranges[i][1];j++) t+=s.get(j);
                answer[i]=t;
            }
            else answer[i]=-1;
            
        }
        return answer;
    }
}
