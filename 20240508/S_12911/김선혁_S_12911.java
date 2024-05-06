class Solution {
    public int solution(int n) {
        
        // 해당 숫자보다 큰숫자부터
        // for문으로 1의 숫자가 같은 그 다음숫자 발견하면 break
        int answer = 0;
        int cnt = 0;
        // 우선 n을 2진수로 교체하고 1탐색
        String num = Integer.toBinaryString(n);
        for(int i = 0 ;i<num.length();i++){
            if(num.substring(i,i+1).equals("1")){
                cnt++;
            }
        }
        // cnt랑 1의 개수가 같은 숫자 찾기
        for(int number= n+1;number<=1000000;number++){
            String tmp = Integer.toBinaryString(number);
            int tmpCnt = 0 ;
            for(int i =0;i<tmp.length();i++){
                if(tmp.substring(i,i+1).equals("1")){
                    tmpCnt++;
                }
            }
            if(cnt == tmpCnt){
                answer = number;
                break;
            }
        }
        return answer;
    }
}
