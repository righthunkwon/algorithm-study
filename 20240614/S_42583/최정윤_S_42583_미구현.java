import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int cnt = 0;
        int w =0;
        while(true){
            if(idx==truck_weights.length) break;
            answer++;
            if(bridge_length>cnt && weight>=w+truck_weights[idx]){
                w+=truck_weights[idx];
                
            }
        }
        return answer;
    }
}
