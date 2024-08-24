// 문제: 43165번 (타겟넘버)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        DFS(0, 0, target, numbers);
        return answer;
    }
    public static void DFS(int cnt, int sum, int target, int [] arr){
        if(cnt == arr.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        DFS(cnt + 1, sum + arr[cnt], target, arr);
        DFS(cnt + 1, sum - arr[cnt], target, arr);
    }
}