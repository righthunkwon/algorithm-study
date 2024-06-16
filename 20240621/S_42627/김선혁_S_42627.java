import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 최소가 되게 하려면 
        // 일단 그 시점에서 제일 적은거먼저 해결해야함
        
        // 우선 jobs배열에서 time이 낮은순서대로 정렬
         Arrays.sort(jobs, new Comparator<int[]>() {	       	
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}      	
			});
        // 큐도 낮은순서대로 정렬하게 설정
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
                
        int time = 0; // 진행된 시간
        int count = 0; // 몇개 진행됬는지
        int index = 0; 

        while(count < jobs.length) {
	        	// 전체 작업 진행에서 하나를 잡고
            // 만약 현재 시간이 그 진행될 시간을 지나면
            // 지난것들 일단 큐에 추가하고
            
            // 현재시간까지 큐에있는것들 다 비워질 때까지 
            // 하나 빼서 - 해주고 다음적은거빼고 이런식
	        	while(index < jobs.length && jobs[index][0] <= time) {
	        		pq.add(jobs[index++]);
	        	}
	        	
	        	if(pq.isEmpty()) {
	        		time = jobs[index][0];
	        	}else {
	        		int[] tmp = pq.poll();
	        		answer += tmp[1] + time - tmp[0];
	        		time += tmp[1];
	        		count++;
	        	}
	        	
	        }
        
   return answer/jobs.length;
    }
}
