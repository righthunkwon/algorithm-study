class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
    // s에서 첫문자, 공백다음은 무조건 toUpperCase() , 나머진 lowerCase 적용
        // s에서 공백을 기준으로 배열에 다 넣어버리면
        // 맨처음 글자만 대문자
        // 나머진 소문자해서 이어 붙여서 출력하면될듯
       for(int i = 0 ;i<arr.length;i++){
            // 공백이면 " "만 ans에 추가
            if(arr[i].length() == 0){
                answer+= " ";
                continue;
            }
           String tmp = arr[i];
           // tmp에는 한 단어씩 있음
           answer += tmp.substring(0,1).toUpperCase();
           // 나머진 소문자
           answer += tmp.substring(1,tmp.length()).toLowerCase();
           answer += " ";
       }
        
        if(!s.substring(s.length()-1, s.length()).equals(" ")){
            answer = answer.substring(0,answer.length()-1);
        }
        
    return answer;
        
    }
}
