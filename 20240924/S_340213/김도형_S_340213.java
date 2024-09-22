class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoSec = change(video_len);
        int posSec = change(pos);
        int stSec = change(op_start);
        int edSec = change(op_end);
        
        int now = posSec;
        
        for(String cmd : commands){
            //오프닝 건너뛰기
            if(now>=stSec && now<=edSec)now = edSec;
            if(cmd.charAt(0)=='n'){
                now+=10;
                if(now>=videoSec)now=videoSec;
            }else{
                now-=10;
                if(now<0)now=0;
            }
        }    
        //마지막 커멘드 하고나서 한번더 오프닝 건너뛰기
        if(now>=stSec && now<=edSec)now = edSec;
        
        //초단위 -> mm:ss 형식으로 변환
        int min = now/60;
        int sec = now%60;
        String MM = min+"";
        String SS = sec+"";
        if(min<10)MM="0"+MM;
        if(sec<10)SS="0"+SS;
        
        return MM+":"+SS;
    }
    
    //mm:ss -> 초단위로
    public static int change (String s){
        int num = 0;
        num += (s.charAt(0)-'0')*600;
        num += (s.charAt(1)-'0')*60;
        num += (s.charAt(3)-'0')*10;
        num += (s.charAt(4)-'0');
        return num;
    }
    
}
