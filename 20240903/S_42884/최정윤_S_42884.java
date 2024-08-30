import java.io.*;
import java.util.*;

class Solution {
    static class Car{
        int in,out;
        public Car(int in, int out){
            this.in=in;
            this.out=out;
        }
    }
    public int solution(int[][] routes) {
        // 10000대, 60000지점
        List<Car> list=new ArrayList();
        for(int i=0;i<routes.length;i++){
            list.add(new Car(routes[i][0],routes[i][1]));
        }
        Collections.sort(list,((o1,o2)->o1.out-o2.out));
        //제일 먼저 나간거 기준 카메라 설치, 그것보다 빨리 들어온거는 무조건 찍힌다
        //카메라 설치 지점보다 늦게 들어온거면 그 차 나간지점에 카메라 다시 설치
    
        int idx=list.get(0).out;
        int answer=1;
        for(int i=1;i<list.size();i++){
            Car car=list.get(i);
            if(car.in>idx){
                answer++;
                idx=car.out;
            }
        }
        return answer;
    }
}
