// https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=java

/* 
1. 현재 시간을 기록하는 변수를 nowTime=0으로 설정
2. 전체 입력 배열의 길이만큼 방문 체크 할 배열을 설정해 boolean으로
3. 처음 시작하면 nowTime = 0 이니까 순회해서 요청시점이 0인 애들만 전부 찾아서 관리 배열에 넣고 방문 처리 
4. 순회 후 방문 배열에서 소용시간 가장 짧은 작업을 진행시킴
5. nowTime 해당 작업 소용시간 만큼 증가, 새로 갱신된 nowTime 이하인 작업들 중 방문 처리 안 되어 있는 작업들 추가로 관리 배열에 추가
6. 관리 배열과 방문 배열이 전부 처리 될 때까지 이 과정을 반복 
*/

// 배열 순회로만 구현
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간을 기준으로 작업을 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int nowTime = 0; // 현재 시간
        boolean[] visited = new boolean[jobs.length]; // 방문 체크 배열
        int totalWaitTime = 0; // 총 대기 시간
        int completedJobs = 0; // 완료된 작업 수
        
        while (completedJobs < jobs.length) {
            int shortestJobIndex = -1;
            int shortestJobTime = Integer.MAX_VALUE;
            
            // 현재 시간 이하에 요청된 작업 중 가장 짧은 작업을 찾음
            for (int i = 0; i < jobs.length; i++) {
                if (!visited[i] && jobs[i][0] <= nowTime) {
                    if (jobs[i][1] < shortestJobTime) {
                        shortestJobTime = jobs[i][1];
                        shortestJobIndex = i;
                    }
                }
            }
            if (shortestJobIndex == -1) {
                // 처리할 작업이 없으면 현재 시간을 다음 요청 시간으로 이동
                for (int i = 0; i < jobs.length; i++) {
                    if (!visited[i]) {
                        nowTime = jobs[i][0];
                        break;
                    }
                }
            } else {
                // 가장 짧은 작업을 처리
                visited[shortestJobIndex] = true;
                nowTime += jobs[shortestJobIndex][1];
                totalWaitTime += nowTime - jobs[shortestJobIndex][0];
                completedJobs++;
            }
        }
        // 평균 대기 시간 계산 및 반환 (소수점 이하 버림)
        return totalWaitTime / jobs.length;
    }
}

// 우선순위 큐 사용
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간을 기준으로 작업을 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int nowTime = 0; // 현재 시간
        boolean[] visited = new boolean[jobs.length]; // 방문 체크 배열
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요 시간이 짧은 순으로 정렬되는 우선순위 큐
        int totalWaitTime = 0; // 총 대기 시간
        int completedJobs = 0; // 완료된 작업 수
        
        while (completedJobs < jobs.length) {
            // 현재 시간 이하에 요청된 작업들을 모두 우선순위 큐에 추가
            for (int i = 0; i < jobs.length; i++) {
                if (!visited[i] && jobs[i][0] <= nowTime) {
                    pq.add(jobs[i]);
                    visited[i] = true; // 방문 처리
                }
            }
            
            if (pq.isEmpty()) {
                // 처리할 작업이 없으면 현재 시간을 다음 요청 시간으로 이동
                for (int i = 0; i < jobs.length; i++) {
                    if (!visited[i]) {
                        nowTime = jobs[i][0];
                        break;
                    }
                }
            } else {
                // 가장 짧은 작업을 처리
                int[] currentJob = pq.poll();
                nowTime += currentJob[1];
                totalWaitTime += nowTime - currentJob[0];
                completedJobs++;
            }
        }
        // 평균 대기 시간 계산 및 반환 (소수점 이하 버림)
        return totalWaitTime / jobs.length;
    }
}