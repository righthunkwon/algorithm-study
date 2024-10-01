class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                answer[i]++;
                //i시점 가격보다 낮은 가격 등장할 때까지 더해줌
                if(prices[i]>prices[j])break;
            }
        }
        return answer;
    }
}
