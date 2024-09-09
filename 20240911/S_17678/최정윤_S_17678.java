import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        //24*60=
        PriorityQueue<Integer> pq=new PriorityQueue();;
        //pq에 시간을 분단위로 저장
        for(int i=0;i<timetable.length;i++){
            String[] time=timetable[i].split(":");
            pq.add(Integer.parseInt(time[0])*60+Integer.parseInt(time[1]));
        }
        int start=540;
        int ans=0;
        for(int i=0;i<n;i++){//n번
            for(int j=0;j<m;j++){//m명타기 가능
                if(pq.isEmpty()) {//탈 사람이 없으면 출발시간에 타는게 제일 늦은 것
                    ans=start;
                    break;
                }
                if(pq.peek()>start) {//탈 사람이 차보다 늦게 올 경우 출발 시간 저장
                    ans=start;
                    break;
                }else{
                    ans=pq.poll()-1;//탈 사람 있다면 그 전 시간으로 저장해놓기
                }
                
            }
            start+=t;
        }
        // System.out.println(ans);
        //숫자인 시간을 string으로 바꾸기
        String answer = "";
        answer+=ans/60<10?"0"+ans/60+":":ans/60+":";
        answer+=ans%60<10?"0"+ans%60:ans%60;
        
        return answer;
    }
}
