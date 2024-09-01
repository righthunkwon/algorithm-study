import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //차량 진출 지점 기준으로 정렬
        Arrays.sort(routes,(o1,o2)->o1[1]-o2[1]);
        
        //첫 경로의 진출지점에 일단 카메라 설치
        int recent_camera = routes[0][1];
        answer++;
        
        //가장 최근 카메라 설치된 위치보다 우측에서 진입하는 경로면
        //해당 경로의 진출위치에 카메라 설치
        for(int i=1;i<routes.length;i++){
            if(recent_camera < routes[i][0]){
                answer++;
                recent_camera = routes[i][1];
            }
        }
        
        return answer;
    }
}
