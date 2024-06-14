import java.util.*;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> Q = new LinkedList<>();
		int sum = 0, time = 0; 
		for(int i = 0; i < truck_weights.length; i++) {
			int t = truck_weights[i];
			while(true) {
				if(Q.isEmpty()) {
					Q.add(t);
					sum += t;
					time++;
					break;
				}
                else if(Q.size() == bridge_length) sum -= Q.poll();
				else {
					if(sum + t <= weight) {
						Q.add(t);
						sum += t;
						time++;
						break;
					}
                    else { 
						Q.add(0);
						time++;
					}
				}
			}
		}
        return time + bridge_length; 
    }
}
