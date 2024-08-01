// DP 문제, 리트코드에서 풀었던 문제
// 집 도둑 유형
// https://www.acmicpc.net/problem/13422
// 집 도둑 문제
// https://leetcode.com/problems/house-robber-ii/description/
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return 0;// 예외 처리1
        if(n == 1) return nums[0];// 예외 처리2
        int result2 = max(nums, 0, n - 2);// 첫 번째 집부터 마지막 집 바로 전까지
        int result1 = max(nums, 1, n - 1);// 두 번째 집부터 마지막 집 까지

        return Math.max(result1, result2);// 두 경우 중 최대값
    }

    private int max(int[] nums, int l, int r) {
        int now = 0;// 지금 집까지 계산
        int prev = 0;// 이전 집까지 계산
        for(int i = l; i <= r; i++) {
            int tmp = Math.max(now, prev + nums[i]);
            prev = now;
            now = tmp;
        }

        return now;
    }
}