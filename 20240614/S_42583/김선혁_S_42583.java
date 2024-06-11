import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 시간
        
        // 큐를 기준으로 하나씩 넣으면서
        // 안에 넣은것들의 무게를 체크하면서 해보자
        // 1. 큐가 비어있을 때 - 하나 넣고 시간증가
        // 2. 큐가 차있으면 2가지 경우
        //   - 1  다리길이와 같으면 하나 제거
        //   - 2 다리길이보다 작으면 추가인데 weight 넘는경우와 안넘는경우 2가지
        
        long sum = 0; // 범위안의 무게 합
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0 ;i<truck_weights.length;i++){
            int tmp = truck_weights[i];
                while(true){
                if(q.size() ==0){
                    // 하나추가하면서 시간하고 무게 추가
                    // 다음거 진행
                    q.add(tmp);
                    answer ++;
                    sum += tmp;
                    break;
                }
                else if(q.size() == bridge_length){
                    // 꽉찼다고 생각하면 
                    // 그냥 일단 하나 제거
                    sum -= q.poll();
                }    
                // 나머지 추가 및 제거
                else {
                    // 무게 넘치는 경우
                    // 0을넣고 시간 1+ (q가 사이즈 같아질떄까지)
                    if(sum + tmp > weight){
                        q.add(0);
                        answer++;
                    }
                    // 안넘치는 경우
                    else{
                       // 추가하고 시간이랑 무게 +
                        q.add(tmp);
                        answer++;
                        sum += tmp;
                        break;
                    }
                }
            }
        }
        

        return answer + bridge_length;
    }
}
