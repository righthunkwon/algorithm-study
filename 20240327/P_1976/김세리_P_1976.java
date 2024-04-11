package _20240411;

import java.util.*;

public class _1976_여행가자 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시 수
        int M = sc.nextInt(); // 여행 계획

        parent = new int[N+1];
        for (int i=1;i<=N;i++) {
            parent[i] = i;
        }

        // 도시 연결 정보 입력 및 병합
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                int connection = sc.nextInt();
                if (connection == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력
        int[] plan = new int[M];
        for (int i=0;i<M;i++) {
            plan[i] = sc.nextInt();
        }

        // 여행 계획 가능 여부 확인
        boolean possible = true;
        for (int i=0;i<M-1;i++) {
        	
        	// 부모가 같지 않을 경우 여행 계획은 불가능하다
            if (find(plan[i]) != find(plan[i + 1])) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    // 부모가 같은지 확인한다
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    // 연결되어 있는 경우 부모를 일치시킨다
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
