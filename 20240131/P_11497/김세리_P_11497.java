package _20240131;

import java.io.*;
import java.util.*;

public class _11497_통나무건너뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] L = new int[N];
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            // 통나무를 양쪽에서 중앙으로 배치
            int left=0, right=N-1;
            while (!q.isEmpty()) {
                if (left<=right) {
                    L[left++] = q.poll();
                }
                if (left<=right) {
                    L[right--] = q.poll();
                }
            }

            // 인접한 통나무 사이의 최대 높이 차이 계산
            int gap = 0;
            for(int i=0;i<N-1;i++) {
                gap = Math.max(Math.abs(L[i]-L[i+1]), gap);
            }
            gap = Math.max(Math.abs(L[0]-L[N-1]), gap);
            System.out.println(gap);
        }
    }
}
