import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 해당 가격이 유지된시간 --> 끝에서 부터 확인해서 해당 숫자보다 낮은 숫자가 나오지 않으면 그대로 기록
        // 우선 전부 스택에 넣어놓고
        // 하나씩 숫자를 뽑아서 최소인 숫자를 만날때마다 교체하고, 만약 교체가 안될떄에는 초 +!씩 기록
        int len = prices.length;
        int[] answer = new int[len];
        
        for(int i =0;i<len;i++){
            int tmp = 0;
            for(int j = i+1;j<len;j++){
                tmp ++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer[i] = tmp;
        }
        
        
        
        return answer;
    }
}
