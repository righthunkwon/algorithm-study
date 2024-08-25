class Solution {
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        this.numbers = numbers;
        dfs(0,0);
        return answer;
    }
    public static void dfs(int idx, int sum){
        if(idx==numbers.length){ //비교
            if(sum==target)answer++;
            return;
        }
        dfs(idx+1,sum+numbers[idx]); //더하기
        dfs(idx+1,sum-numbers[idx]); //빼기
    }
    static int target,answer;
    static int[] numbers;
}
