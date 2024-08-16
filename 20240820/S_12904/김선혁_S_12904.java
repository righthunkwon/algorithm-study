class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        // 해당숫자가 기준점이라 생각할 때 
        // 현재 answer숫자부터 끝까지 더 짧은 곳까지를 기준으로
        // 확장해가면서 최대 길이 return
        // --> 투포인터 반대로 확장버전 생각하면 될듯
        for(int i = 0 ;i<s.length()-1;i++){
            // 현재 i번째 위치한 문자열이 중심이라 생각
            // 홀수랑 짝수 2번 수행
            // 홀수일 때 : i번째를 중심으로 뻗어나감
            // 짝수일 때 : i와 i+1번째를 중심으로 뻗어나감
            int a = solve(s,i,i);
            int b = solve(s,i,i+1);
            answer = Math.max(answer, a);
            answer = Math.max(answer, b);
        }

        return answer;
    }
    public static int solve(String s, int left, int right){
        while(true){
            // left와 right번째를 비교하면서 
            // 벌어지고 마지막에는 두개의 차 return
            if(left <0 || right >= s.length() ){
                break;
            }
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            // 두개가 다르면 break 아니면 서로 멀어짐
            left --;
            right ++;
        }
        // 현재 두개숫자는 벗어난 상태라 마지막에 -1
        return right - left -1;
    }
    
    
}
