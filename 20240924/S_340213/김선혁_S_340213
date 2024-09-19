import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // prev 명령하면 10초전 이동, next 명령하면 10초 후로 
        // 맨 처음과 끝이 겹치면 0초나 마지막 위치로 이동
        
        // 현재 초의 위치가 오프닝에 속하면 오프닝 끝나는 위치로 이동
        // 오프닝 위치 확인은 매번 작업 수행마다 확인
        
        // 일단 모두 초로 바꾼후에 시작
        int len = Integer.parseInt(video_len.substring(0,2)) * 60 + Integer.parseInt(video_len.substring(3,5));
        int now = Integer.parseInt(pos.substring(0,2)) * 60 + Integer.parseInt(pos.substring(3,5));
        int opS = Integer.parseInt(op_start.substring(0,2)) * 60 + Integer.parseInt(op_start.substring(3,5));
        int opE = Integer.parseInt(op_end	.substring(0,2)) * 60 + Integer.parseInt(op_end	.substring(3,5));
        // 먼저 현재 위치 확인후 오프닝에 속하면 끝으로 이동
        if(now >= opS && now <= opE){
            now = opE;
        }
        // 이제 명령시작 
        for(int i = 0;i<commands.length;i++){
            // 1. next인 경우 
            if(commands[i].equals("next")){
                // 10초 뒤로 이동하고 만약 끝보다 클경우 끝으로 정정 
                now = Math.min(now + 10, len);
            }
            else {
                // 10초 전으로 이동하고 만약 -일경우 0으로 정정 
                now = Math.max(now - 10, 0);
            }
            // 현재 위치가 오프닝에 속하면 오프닝 끝으로 이동 (매번확인)
            if(now >= opS && now <= opE){
                now = opE;
            }
        }
        int h = now/60;
        int m = now%60;
        
        if(h <10){
            answer += "0";
        }
        answer += Integer.toString(h);
        answer += ":";
        if(m < 10){
            answer += "0";
        }
        answer += Integer.toString(m);
        
        return answer;
    }
}
