class Solution {
    public String solution(String p) {
        String answer = makeCorrect(p);
        return answer;
    }
    
    //문자열 p를 올바른 문자열로 변환하기 위한 재귀함수
    String makeCorrect(String str) {
        if(str.length() == 0) { //빈 문자열은 그대로 반환
            return "";
        }
        
        int cut = divide(str); //두 "균형잡힌 괄호 문자열" u, v로 분리
        String u = str.substring(0, cut);
        String v = str.substring(cut, str.length());
        
        if(isCorrect(u)) {
            return u + makeCorrect(v);
        } else {
            String tmp = "(" + makeCorrect(v) + ")";  //4-1 ~ 4-3
            u = u.substring(1, u.length()-1); //u의 첫 번째와 마지막 문자를 제거
            u = reverse(u); //나머지 문자열의 괄호 방향을 뒤집어서
            return tmp + u; //뒤에 붙임
        }
    }
    
    //균형잡힌 문자열(u, v)로 나눌 수 있는 앞에서 가장 가까운 인덱스 구하기
    int divide(String str) {
        int open = 0;
        int close = 0;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                open++;
            else
                close++;
            
            if(open == close)
                return i+1;
        }
        return -1;
    }
    
    //올바른 괄호 문자열인지 판별
    boolean isCorrect(String str) {
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            
            if(cnt < 0)
            return false;
        }
        return true;
    }
    
    //괄호 방향 뒤집기
    String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }
    
}
