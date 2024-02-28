package algo_study;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BOJ_Q12763_지각하면_안돼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //장소의 수
        int T = sc.nextInt(); //최대 걸릴 수 있는 시간
        int M = sc.nextInt(); //최대 사용할 수 있는 돈
        int L = sc.nextInt(); //도로의 수

        // 도로 정보를 저장할 리스트 초기화
        List<Road> roads = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            int start = sc.nextInt(); // 시작 지점
            int end = sc.nextInt();   // 끝 지점
            int time = sc.nextInt();  // 해당 도로를 이용할 때 걸리는 시간
            int cost = sc.nextInt();  // 해당 도로를 이용할 때 드는 비용

            roads.add(new Road(start, end, time, cost));
        }
        
        
    }

    // 도로 정보 클래스
    static class Road {
        int start, end, time, cost;

        public Road(int start, int end, int time, int cost) {
            this.start = start;
            this.end = end;
            this.time = time;
            this.cost = cost;
        }
    }
}
