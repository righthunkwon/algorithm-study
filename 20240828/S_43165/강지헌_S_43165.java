import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,0,target);
        return answer;
    }
    public void dfs(int[] arr, int t, int n, int g) {
        if(arr.length==t) {
            if(n>=1 && n==g) answer++;
            return;
        }
        dfs(arr,t+1,n+arr[t],g);
        dfs(arr,t+1,n-arr[t],g);
    }
}
