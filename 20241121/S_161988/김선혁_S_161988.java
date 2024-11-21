import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long max = Long.MIN_VALUE;
        // 구하는 방법은 두가지가 있다.
        // 1. -1, 1 , -1 순서   // 2. 1 , -1 , 1 순서
        int[] tmp = Arrays.copyOf(sequence, sequence.length);
        // tmp 배열을 이용하여 각각 짝수번일때랑 홀수번일때 진행
        for(int i=0;i<tmp.length;i++){
            if(i%2 == 0){
                tmp[i] = tmp[i]*(-1);
            }
        }
        int idx = 0;
        long sum = 0;
        // tmp배열에서 idx를 기준으로 계속 누적합을 해서 구한다.
        while(idx<tmp.length){
            sum += tmp[idx];
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
            idx++;
        }
        // 이렇게 진행한 후에 홀수번일 떄도 진행
        for(int i=0;i<tmp.length;i++){
            if(i%2 == 1){
                tmp[i] = tmp[i]*(-1);
            }
        }
        idx = 0;
        sum = 0;
        while(idx<tmp.length){
            sum += tmp[idx];
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
            idx++;
        }
        
        return max;
    }
}
