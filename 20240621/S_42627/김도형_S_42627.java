import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        
        //각 초 단위에서 현재 요청이 들어온 대기 작업들 중 
        //작업 시간 제일 짧은 거 먼저 처리하면 될듯? > priority큐 ?
        
        // 작업 요청 배열 요청시간 기준 오름차순 정렬 
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 소요 시간 짧은거부터 나오는 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int now = 0; //현재 시간
        int totalTime = 0; //걸린 시간 합
        int idx = 0; //작업 인덱스
        int cnt = 0; //완료된 작업 수

        while (cnt < jobs.length) {
            // 현재 시간까지 도착한 모든 작업을 큐에 추가
            while (idx < jobs.length && jobs[idx][0] <= now) {
                pq.add(jobs[idx]);
                idx++;
            }

            // 큐가 비어 있으면 현재 시간 갱신
            if (pq.isEmpty()) {
                now = jobs[idx][0];
                continue;
            }

            // 가장 짧은 작업을 큐에서 꺼내서 처리
            int[] currentJob = pq.poll();
            now += currentJob[1]; //현재 시간 늘려주고
            totalTime += now - currentJob[0]; //해당 작업 걸린 시간 더하고
            cnt++; //완료된 작업 +1
        }

        return totalTime / jobs.length;

    }
}
