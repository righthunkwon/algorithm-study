class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001];
        long[] torque = new long[4001];
        for (int weight : weights) {
            long tmp = count[weight];
            answer += tmp;
            for(int i = 2; i <= 4; i++){
                int num = weight * i;
                answer += torque[num];
                if (tmp > 0) {
                    answer -= tmp;
                }
                torque[num]++;
            }
            count[weight]++;
        }
        return answer;
    }
}