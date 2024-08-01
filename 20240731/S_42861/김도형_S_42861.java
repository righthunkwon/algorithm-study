import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        
        List<int[]>arr[]=new ArrayList[n]; //연결된 섬 저장할 리스트
        for(int i=0;i<n;i++)
            arr[i]=new ArrayList<>();
        
        //연결정보 입력
        for(int[]cost : costs){
            arr[cost[0]].add(new int[]{cost[1],cost[2]});
            arr[cost[1]].add(new int[]{cost[0],cost[2]});
        }
        
        //건설비용 낮은거부터 나오는 pq 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        boolean [] linked = new boolean[n]; //섬 연결 여부
        
        pq.add(new int[]{0,0}); //시작지점 자기자신으로 연결 비용 0
        while(!pq.isEmpty()){
            int[]tmp = pq.poll(); //이번에 연결할 섬,연결비용
            if(linked[tmp[0]])continue; //이미 연결된거 pass
            linked[tmp[0]]=true;//방문처리
            answer += tmp[1];
            
            //현재 연결되어있는 섬들과 연결가능한 섬 리스트 추가
            for(int[]land:arr[tmp[0]]){
                if(!linked[land[0]]){
                    pq.add(new int[]{land[0],land[1]});
                }
            }
            
        }
        
        
        
        
        return answer;
    }
}
