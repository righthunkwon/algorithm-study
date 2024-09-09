import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        // 콘이 타는 위치 기준으로 
        // 빈자리가 있으면됨!!(그때 시간에 타는 사람은 타있는다 생각)
        
        // 다인원이 차는 시점 -1분이 콘이 타는 시점
        // 우선 시간을 모두 분으로 바꿔서 우선순위 큐에 넣고 시작
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0;i<timetable.length;i++){
            String[] tmp = timetable[i].split(":");
            // tmp에 시간과 분이 따로 담김
            int time = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            pq.add(time);
        }
        // 시작시간이 9시이고 t분마다 pq에서 그 사이에 있는 개수를 카운트해서
        // 만약 m명 만큼 count되면 타는 시점은 각 시간마다 m명이 되는 시점의 시간 -1,
        // 0부터 마지막 시간까지하면 최대한 늦은 시간을 구할 수 있음
        int startTime = 540;
        int cnt = 0;
        int lastTime = 0; // 마지막 탄사람
        for(int i = 0;i<n;i++){
            // 첫번쨰 타임부터 시작
            cnt = 0;
            // 현재 큐의 꼭대기가 starttime보다 적을 때 
            // 하나씩 꺼내서 개수 count
            while(pq.size() >0){
                if(pq.peek() > startTime){
                    break;
                }
                // 위 조건 만족하면 cnt+1하고 큐에서 하나 꺼내서 last에 저장하고 반복
                // 만약 진행하다 cnt가 m되면 그대로 끝내고 다음 시간으로 진행
                cnt ++;
                lastTime = pq.poll();
                if(cnt == m){
                    break;
                }
            }
            // 다음 시간 진행
            startTime += t;
        }
        // 만약 현재 m이랑 같다면 마지막에 탄사람 -1을 하면되고
        // m이 아니라면 자리가 남는것으로 t를 더했기때문에 t빼고 return하면됨
        int time = 0;
        if(cnt == m){
            time = lastTime -1;
        }
        else {
            time = startTime - t;
        }
        // 시간에서 모두 string으로 바꾸는 작업
        // 출력 format이 "09:00" 이런식
        int ah = time/60;
        int am = time%60;
        String answerH = "";
        String answerm = "";
        if(ah < 10){
            answerH = "0";
        }
        if(am < 10){
            answerm = "0";
        }
        answerH += Integer.toString(ah);
        answerm += Integer.toString(am);
        return answerH +":"+answerm;
    }
}
