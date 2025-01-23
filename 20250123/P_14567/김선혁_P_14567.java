package com.example.algo;

import java.util.*;

public class AlgoApplication{
    static int N;
    static ArrayList<Integer>[] ar;
    static int[] sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();// 과목의 수
        int M = sc.nextInt(); // 선수 과목 조건의 수
        // 각각 선수과목이 부모 객체에 넣어놓고
        // 하나씩 이동할 떄 마다 그 값을 + 해주면 될듯
        ar = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            ar[i] = new ArrayList<>();
        }
        sum = new int[N+1];
        // 먼저 선행되어야할 값 먼저 정하고
        // 그 점에서 이어진 지점 갱신(만약 값있으면 max값으로 갱신)
        for(int i = 1 ; i<=M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ar[a].add(b);
        }
        // 1부터 쭉 진행
        for(int i = 1 ; i<=N ; i++){
            // i에서 연결된 점 모두 갱신
            for(int j = 0;j< ar[i].size();j++){
                int num = ar[i].get(j);
                // 두개중 최대값
                sum[num] = Math.max(sum[num], sum[i]+1);
            }
        }


        for(int i = 1;i<=N;i++){
            System.out.print(sum[i]+1+" ");
        }

    }

}
