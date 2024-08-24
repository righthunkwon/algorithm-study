class Solution {
    static int answer;
    public int solution(int[] numbers, int target) { 
        answer = 0;
        dfs(0,0,numbers,target); 
        return answer;
    }
    public void dfs(int depth,int total,int[]numbers,int target){
        if(depth==numbers.length){
            if(total == target){
                answer++;
                return;
            }
            return;
        }
        //더한경우 뺀경우로 나눠서 dfs
        dfs(depth+1,total+numbers[depth],numbers,target);
        dfs(depth+1,total-numbers[depth],numbers,target);
    }
}
