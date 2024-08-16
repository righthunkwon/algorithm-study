class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001];
        long[] torque = new long[4001];
        for (int weight : weights) {
            long temp = count[weight];
            answer += temp;
            for(int i = 2; i <= 4; i++){
                int num = weight * i;
                if (temp > 0) {
                    answer += torque[num] - temp;
                }else{
                    answer += torque[num];
                }
                torque[num]++;
            }
            count[weight]++;
        }
        return answer;
    }
}