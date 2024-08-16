import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 2 3 4 하나씩 있다는 것은 1:1 or 1 : 1.5 or 1  : 2 or 3: 4일때 가능
        // 정렬해서 하나씩 
        // ex 3이면 3 4.5 6 4 : 해당수에서 끝냄
        Arrays.sort(weights);
        // 해쉬맵에 저장해놓고 
        // 하나씩 꺼내는거도 괜찮을듯
        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        for(int i = weights.length-1;i>=0;i--){
            // 숫자를 하나씩 넣을때 넣기전에
            // 높은숫자부터 시작하면서
            // 그 숫자에 해당하는 높은숫자가 있으면
            // 하나의 쌍이라 생각해서 그 수만큼 +해줌
            // 다 더한 후에 그 숫자 맵에 +해줌
            double a = weights[i]*1.0;
            double b = (weights[i] * 3.0)/2.0;
            double c = weights[i] * 2.0;
            double d = (weights[i] * 4.0) / 3.0;
            // 위숫자에 해당하는 숫자 찾음
            answer += hm.getOrDefault(a, 0) + hm.getOrDefault(b, 0) + hm.getOrDefault(c, 0) + hm.getOrDefault(d, 0);
            // 다 더했으면 이제 해당숫자 맵에 추가
            int tmp = hm.getOrDefault(a,0);
            hm.put(a, tmp+1);
            
        }

    
        return answer;
    }
}
