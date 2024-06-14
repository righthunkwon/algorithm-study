import java.util.*;
import java.io.*;

class Solution {
    
    static class Truck{
        int weight; //트럭 무게
        int pos; //트럭 현 위치
        
        public Truck(int weight, int pos){
            this.weight = weight;
            this.pos = pos;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int totalWeight = 0; //현재 다리 위에 있는 트럭 무게 합
        int time = 0; //걸린 시간
        
        Queue<Truck>waitingQ = new LinkedList<>(); //대기 트럭 큐
        Queue<Truck>onBridgeQ = new LinkedList<>(); //다리 위 트럭 큐
        
        for(int i = 0;i<truck_weights.length;i++){
            waitingQ.add(new Truck(truck_weights[i],0)); //대기 트럭 큐에 삽입
        }
        
        onBridgeQ.add(waitingQ.poll()); //첫 트럭 다리에 올림
        totalWeight+=onBridgeQ.peek().weight; //무게 더해주기
        
        while(!onBridgeQ.isEmpty()){ //다리 위 트럭 다 없어지면 끝
            time++;
            for(Truck t:onBridgeQ){ 
                t.pos++; //다리 위 트럭 1칸씩 전진
            }
            
            //맨 앞 트럭 다리 건너면 큐에서 제거하고 다리 위 무게 빼주기
            if(onBridgeQ.peek().pos > bridge_length){
                totalWeight-= onBridgeQ.poll().weight;
            }
            
            //대기 트럭이 남아있고, 다리가 견딜 수 있는 무게면 트럭 더 올리기
            if(!waitingQ.isEmpty()&&totalWeight+waitingQ.peek().weight<=weight){
                totalWeight+=waitingQ.peek().weight; //무게 더하고
                waitingQ.peek().pos++; //위치+1
                onBridgeQ.add(waitingQ.poll()); //트럭 올리고
                
            }

        }
        
        answer = time;
        
        return answer;
    }
}
