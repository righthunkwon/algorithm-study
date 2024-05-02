class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int a = 0; // 변환
        int b = 0; // 제거개수
        
        // 2진수로 변환시키고 
        // 전부다 1이면 break 아니면 무한반복
        while(true){
            if(s.equals("1")){
                break;
            }
            a++;
            // 1과 0의 개수 count해서 
            // 2진수 변환
            int one = 0;
            for(int i =0;i<s.length();i++){
                String tmp = s.substring(i,i+1);
                if(tmp.equals("1")){
                    one++;
                }
                else{
                    b++;
                }
            }
             // 1의 개수만큼 2진수 변환
                s = Integer.toBinaryString(one);
        } // while
        
        answer[0] = a;
        answer[1] = b;
        
        
        
        return answer;
    }
}
