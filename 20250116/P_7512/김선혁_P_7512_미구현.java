package com.example.algo;

import java.util.*;

public class AlgoApplication{
    static final int Num = 10000001;
    static boolean[] pos = new boolean[Num];
    static List<Integer> Nums = new ArrayList<>();
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
           // 모든 i에 대해서 연속하는 소수 ni개의 합으로 나타낼 수 있는 가장 작은 소수를 찾는 프로그램
            // 3 , 5 - > (83 = 23 + 29 + 31 = 11 + 13 + 17 + 19 + 23)
            // .. 낮은 소수부터 실행 직접 실행?

            // 소수를 먼저 계산하자
            Arrays.fill(pos, true);
            pos[0] = pos[1] = false; // 0과 1은 소수가 아님
            for (int i = 2; i < Num; i++) {
                if (pos[i]) {
                    Nums.add(i);
                    for (int j = i * 2; j < Num; j += i) {
                        pos[j] = false;
                    }
                }
            }

            int T = sc.nextInt();
            for(int tc = 1; tc<=T ;tc++){
                int ans = 0;
                int N = sc.nextInt();
                int [] arr = new int[N];
                for(int i = 0;i<N;i++){
                    arr[i] = sc.nextInt();
                }


                System.out.println("Scenario 1:"+ ans);
            }










        }



}
