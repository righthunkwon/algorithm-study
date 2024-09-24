import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        //  <시간, 해당시간에 그 좌표에 있는 로봇 수> 로 hashmap 2차원 배열 생성
        HashMap<Integer, Integer>[][] map = new HashMap[101][101];
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                map[i][j]=new HashMap<>();
            }
        }
        
        //routes 배열에 따라 로봇 이동시키면서 map 배열 업데이트
        for(int[]route : routes){
            
            
            
        }
        
        //특정시간 특정좌표에 있는 로봇 수가 2이상이면 충돌위험 +1
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                for(int key : arr[i][j].keySet()){
                    if(arr[i][j].get(key)>1) { 
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}
