import java.io.*;
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        int [] table = new int[timetable.length];
        
        for(int i=0;i<timetable.length;i++){
            int hour = (timetable[i].charAt(0)-'0')*10+(timetable[i].charAt(1)-'0');
            int min = (timetable[i].charAt(3)-'0')*10+(timetable[i].charAt(4)-'0');
            table[i]=hour*60+min;
        }
        Arrays.sort(table); //크루원 도착시각 오른차순 정렬
        int [] shuttle_time = new int[n];
        for(int i=0;i<n;i++){
            shuttle_time[i]=540+i*t;
        }

        /*
        1. 시간 -> 분 단위 int형으로 
        2. 크루원들 차를 태워 보내고 마지막 차를 타는 크루원 중 맨 마지막에 타는 크루원의 도착시간에서 1을 뺀 시간
        3. 단, 만약 막차가 꽉 차지 않게 된다면 막차 출발시간에 가면 됨
        4. 분단위 -> 다시 시간 String형으로
        */
        boolean flag = false; //막차가 꽉찼는지 여부
        int crewIdx = 0;//크루원 인덱스
        int shuttleIdx = 0; //셔틀 인덱스
        int nowCrew = 0;//현재 해당 셔틀 탑승인원 체크
        l:while(!flag){
            
            // 막차를 못 타는 크루원이거나 마지막 크루원이었으면 끝내기
            if (crewIdx >= table.length || table[crewIdx] > shuttle_time[shuttle_time.length - 1]) {
                break l;
            }
            
            if(table[crewIdx]<=shuttle_time[shuttleIdx]){//태울 수 있는 크루원
                nowCrew++;
                crewIdx++;
            }else{ //못태우면 다음 셔틀로
                if(shuttleIdx==n-1){ //막차였으면 stop
                    break l;
                }else{
                    shuttleIdx++;
                    nowCrew=0;
                }
            }

            if(nowCrew==m){ //현재 셔틀 인원 꽉찬 경우
                if(shuttleIdx==n-1){//막차가 꽉참 -> 뒤 더 볼 필요 x
                    flag = true;
                    break l;
                }else{ //막차 아니면
                    shuttleIdx++;
                    nowCrew=0; //초기화
                }
            }
        }
        
        //막차가 꽉찼으면 => 막차 마지막 크루원 도착시간 -1
        //막차가 꽉차지 않았으면 => 막차 출발시간
        int ans = flag? table[crewIdx-1]-1 :shuttle_time[shuttle_time.length-1];
        
        //분단위 -> 다시 시간 String형으로
        String ans_hour = (ans/60)+"";
        String ans_min = (ans%60)+"";
        if(ans/60<10){
            ans_hour = "0"+ans_hour;
        }
        if(ans%60<10){
            ans_min = "0"+ans_min;
        }
        String answer = ans_hour+":"+ans_min;
        
        return answer;
    }
}
