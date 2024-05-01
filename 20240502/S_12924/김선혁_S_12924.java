class Solution {
    public int solution(int n) {
         int answer = 0;
    // 2중포문 사용해서 하나를 기준잡고
    // 그 수부터 절반+1까지 숫자를 연속한 합을 구해보자
    for(int i = 1 ; i<=n/2;i++){
        int sum = i;
        // sum을 기준값 바뀔때마다 초기화
        for(int j = i+1;j<= n/2+1;j++){
            sum += j;
            
            // 만약 sum이 n보다 커지면 break하고 
            // 같으면 +1하고 break
            if(sum > n){
                break;
            }
            else if(sum == n){
                answer++;
                break;
            }
        }
        
    }
    
    
    return answer+1;
    }
}
