// 언제푼지 모르겠는데... 풀려있네

class Solution {
    static int[] numbers;
    static int target;
    static int n;
    static int ans;
    public int solution(int[] numbers, int target) {
        // 2가지 방법 가능
        this.numbers = numbers;
        this.target = target;
        n = numbers.length;
        solve(0,0);
        
        return ans;
    }
    public static void solve(int index , int sum){
        if(index == n){
            if(sum == target){
                ans++;
            }
            return;
        }
        
        solve(index+1, sum+numbers[index]);
        solve(index+1, sum - numbers[index]);
        
    }
    
    
}
