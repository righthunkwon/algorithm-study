class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int end=time(video_len);
        int now=time(pos);
        int op_st=time(op_start);
        int op_ed=time(op_end);
        
        for(int i=0;i<commands.length;i++){
            //오프닝건너뛰기
            if(now>=op_st&&now<=op_ed){
                now=op_ed;
            }
            if(commands[i].equals("prev")){//10초 전
                now-=10;
                if(now<0)now=0;
            }else{//10초 후
                now+=10;
                if(now>end)now=end;
            }
        }
        if(now>=op_st&&now<=op_ed){
            now=op_ed;
        }
        //0이 있어야 빈자리에 0을 넣어줌
        String answer = String.format("%02d",now/60)+":"+String.format("%02d",now%60);
        return answer;
    }
    public static int time(String str){
        String[] t= str.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
}
