class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String str = Integer.toString(storey);
        System.out.print(str);
        int tmp = 0; //올림용 변수
        //1의자리부터 시작
        for(int i=str.length()-1;i>=0;i--){
            int num = str.charAt(i)-'0'+tmp; //이전자리에 올림을 했으면 1증가
            tmp=0; //초기화
            if(num>=10){
                tmp++;
                continue;
            }else if(num>5){
                tmp++;
                answer+=(10-num);
            }
            else if(num==5){ //5일 경우 예외처리
                if(i>0&&str.charAt(i-1)-'0'>=5){ //다음 자리수가 5이상이면 올림
                    tmp++;
                }answer+=5;
                
            }else answer+=num;
        }
        
        answer+=tmp; //마지막에 올림있었으면 처리
        
        return answer;
    }
}
