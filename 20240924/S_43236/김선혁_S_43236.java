import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        // 바위 2개를 제거했을 때 
        // 각 바위 사이의 거리 중의 최소값에서 
        // 최솟값들 중 최대값을 찾으면됨
        
        // 거리는 1~10억까지, 바위는 50000개 이하
        // 우선 rocks 배열을 정렬한 다음에 
        // 하나의 배열을 만들어 각 rocks의 차이만큼의 숫자를 입력해놓음
        
        // 우선순위 큐에다가 전체 숫자를 다 입력하고 
        // 적은 개수대로 n개....하면 그 길어진거리만큼 기록을 못함..
        
        // 생각을 바꿔보자.. 우선 일단 정렬부터
        Arrays.sort(rocks);
        // 먼저 값을 정한다음에
        // 그 점에서 각 지점까지 사이의 거리가 값보다 크면 유지하고
        // 적다면 그 바위 제거해서 제거된 바위가 2개나올때까지 쭉 돌림
        
        // 바위가 2개보다 많다면 숫자가 줄어야함
        int left = 1;
        int right = distance;
        while(true){
            int mid =(left + right)/2;
            // mid값을 중심으로 제거된 바위의 개수 count
            int cnt = solve(distance, rocks, mid);
            if(cnt> n){
                right = mid -1;
            }
            else {
                // 일단 만족함
                answer = mid;
                left = mid +1;
            }
            
            if(left > right){
                break;
            }
        }
        
        
        return answer;
    }
    
    public static int solve(int distance, int[] rocks, int mid){
        int cnt = 0;
        int st = 0;
        int en = distance;
        // st부터 쭉 확인해서 
       for(int i = 0; i < rocks.length; i++){
            // mid보다 적다면 제거된 바위
            if(rocks[i] - st < mid) {
                cnt++;
            }
            // mid보다 크다면 살아남아서 st 교체
            else {
                st = rocks[i];
            } 
        }
        // 제일 마지막거도 계산
        if(en - st < mid){
            cnt++;
        } 
      
        return cnt;        
    }
    
    
}
