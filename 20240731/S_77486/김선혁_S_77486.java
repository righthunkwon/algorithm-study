import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // 자신이90프로 위로 10프로씩 쭉 올라가는 방식
        // -> map써서 나랑 내부모 저장 1개, 나랑 내index 저장 1개해서
        // seller돌면서 dfs방식처럼 올라가면서 계산해야할듯
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        
        for(int i = 0;i<enroll.length;i++){
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        
        
        for(int i = 0;i<seller.length;i++){
            int price = amount[i] * 100;
            // 부모찾고 90프로 가지고 부모로 쭉 10프로씩 가지는방식
            String human = seller[i];
            while(true){
                int parentPrice = price/10;
                int myPrice = price - parentPrice;
                // 내가 90프로 가지고 다음사람이 가지고
                // 센터는 출력안해도되서 ㄱㅊ
                
                answer[index.get(human)] += myPrice;
                price /= 10;
                human = parent.get(human);
                
                // 백트래킹으로 어차피 1원이하거나 -이면 끝내도됨
                if(human.equals("-") || price<1){
                    break;
                }
            }
        }
        
        
        return answer;
    }
}
