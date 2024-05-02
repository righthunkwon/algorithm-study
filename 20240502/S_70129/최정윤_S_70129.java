class Solution {
    public int[] solution(String s) {
        int zero=0;
        int cnt=0;
        while(true){
            if(s.length()==1)break;
            int one=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)-'0'==0){
                    zero++;
                }else{
                    one++;
                }
            }
            s=Integer.toBinaryString(one);//2진수 변환
            cnt++;
        }
         int[] answer = {cnt,zero};
        return answer;
    }
}
