import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        //100000 * 100000 시간초과 
        Arrays.sort(weights);
        long answer = 0;
        //int로 하게되면 33.333과 33이 같아짐
        Map<Double,Integer> map=new HashMap();
        double[] arr={1.0,1.0/2,2.0/3,3.0/4};
        for(int i=0;i<weights.length;i++){
            for(int j=0;j<4;j++){
                if(map.containsKey(weights[i]*arr[j])){
                    answer+=map.get(weights[i]*arr[j]);
                };
            }
            map.put((double)weights[i],map.getOrDefault((double)weights[i],0)+1);
        }

        return answer;
    }
}
