import java.io.*;
import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list=new ArrayList();
        list.add(k);
        while(k>1){
        if(k%2==0)k/=2;
        else k=k*3+1;
        list.add(k);
        }
        double[] answer = new double[ranges.length];
        for(int i=0;i<ranges.length;i++){
            int st=ranges[i][0];
            int ed=ranges[i][1];
            double sum=0;

            if(st>list.size()-1+ed){
                answer[i]=-1;
            }
            else{
            for(int j=st;j<list.size()-1+ed;j++){
                int a=list.get(j);
                int b=list.get(j+1);

                double min=Math.min(Math.abs(a),Math.abs(b));
                double max=Math.max(Math.abs(a),Math.abs(b));
                sum+=min+(max-min)/2;     
            }
                 answer[i]=sum;
            }

        }

        return answer;
    }
}
