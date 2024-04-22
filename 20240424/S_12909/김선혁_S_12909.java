class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int num = 0;
        for(int i = 0;i<s.length();i++){
            String tmp = s.substring(i,i+1);
            // (이면 +해주고 반대면 - 해줌
            // 만약 -로 넘어가게 되면 false
            if(tmp.equals("(")){
                num++;
            }
            else{
                num--;
                if(num<0){
                    answer = false;
                    break;
                }
            }
            
        }
        // 0이 아니면 false 출력
        if(num != 0){
            answer = false;
        }
        return answer;
    }
}
