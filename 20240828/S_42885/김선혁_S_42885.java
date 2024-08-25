import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬먼저 하고
        // 맨끝에서부터 하나씩 채우면서
        // 맨처음에 있는 사람과 합쳐서 무게제한 limit에 합격하면 count
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        while(true){
            if(left > right){
                break;
            }
            // 두개의 합이 제한에 속하면 answer++ 하고 두개 하나씩 줄이고     
            // 안속하면 right만 하나 -- 하고 answer++
            if(people[left] + people[right] <= limit){
                answer ++;
                left ++;
                right --;
            }
            else{
                answer ++;
                right --;  
            }            
        }
        
        
        
        return answer;
    }
}
