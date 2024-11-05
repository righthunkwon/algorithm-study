import java.util.*;
import java.io.*;
    class Solution {
    public int solution(String[][] book_time) {
        int [][] new_book_time = new int [book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            new_book_time[i][0]=timeToMin(book_time[i][0]);
            new_book_time[i][1]=timeToMin(book_time[i][1])+10; //청소시간 고려
        }
        //시작시각 기준 정렬
        Arrays.sort(new_book_time, (o1, o2) -> o1[0]-o2[0]);
        
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int roomCnt = 1; //방개수 최소 1개

        for(int i=0;i<new_book_time.length;i++){
            //방 다 비어있으면 pq에 종료시각 넣기
            if(pq.isEmpty()){
                pq.add(new_book_time[i][1]);
                continue;
            }
            
            //시작시각보다 종료시각 빠른것들 다 빼고, 현재 예약의 종료시각 pq에 넣기
            while(!pq.isEmpty()&&pq.peek()<=new_book_time[i][0]){
                pq.poll();
            }
            pq.add(new_book_time[i][1]);
            roomCnt = Math.max(roomCnt,pq.size()); //방 개수 갱신
        }
        return roomCnt;
    }
    //시간 문자열 -> 분단위 int형으로 변환 
    public int timeToMin(String t){
        int time = 0;
        time+=(t.charAt(0)-'0')*600;
        time+=(t.charAt(1)-'0')*60;
        time+=(t.charAt(3)-'0')*10;
        time+=(t.charAt(4)-'0');
        return time;
    }
}
