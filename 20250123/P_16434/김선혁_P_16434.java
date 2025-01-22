package com.example.algo;

import java.util.*;

public class AlgoApplication{
    static int N;
    static int atk;
    static int[][] arr; // 각 방마다의 정보

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 용사가 공주를 구하러 가는길에 몬스터를 만나면 전투를 진행한다.

        // 1. 용사의 공격력만큼 몬스터의 생명력을 깎습니다.
        // 2. 몬스터의 생명력이 0 이하이면 전투가 종료되고 용사는 다음 방으로 이동합니다.
        // 3. 몬스터의 공격력만큼 용사의 생명력을 깎습니다.
        // 4. 용사의 생명력이 0 이하이면 전투가 종료되고 용사는 사망합니다.
        // 5. 다시 1부터 진행합니다.
        // 체력포션이 있는 방에 가면 체력과 공격력이 상승

        // 용사가 던전을 통과하기 위한 필요한 최소의 체력을 구해야함
        N = sc.nextInt();;
        atk = sc.nextInt();
        arr = new int[N][3];
        // 1인 경우 몬스터, 2인 경우 공격력과 생명력 향상

        // 최소가 되려면 전체의 체력 범위에서 이분탐색을 통해 체력을 정하고
        // 실행해보면 될듯
        for(int i = 0;i< N ;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        long ans = 0;
        // 이제 진행해보자
        long left = 0;
        long right = 1000000L * 1000000; // 때리는 횟수 백만 * 적의 체력 백만을 고려
        while(true){
            long mid = (right + left)/2;
            // mid를 가지고 게임 돌려보자
            if(solve(mid,atk)){
               // 만족하면 피 깎아서 다시
               right = mid -1;
            }
            else{
                left = mid +1;
            }
            // 만약 left가 right보다 커지면 끝
            if(left > right){
                ans = left;
                break;
            }
        }
        System.out.println(ans);

    }
    public static boolean solve(long hp, long atk){
        // hp가지고 진행
        long nowHp = hp;
        long nowAtk = atk;
        for(int i = 0;i< N ;i++){
            int a = arr[i][1]; // 공격력
            int b = arr[i][2]; // 체력
            if(arr[i][0] == 1){
            // 몬스터일 경우
                // 내 공격력을 적 체력으로 나눈 값 + 1 만큼의 적의 공격력만큼 내가 피해입음
                long cnt = (long)b / nowAtk;
                // 내가 먼저 공격이기떄문에 내가 공격한 횟수-1 만큼 공격당함
                // 0으로 나눠떨어지면 -1해줘야함
                if((long)b%nowAtk == 0L){
                    cnt --;
                }
                nowHp -= a * cnt;
                if(nowHp <= 0L){
                    return false;
                }
            }
            // 포션일 경우
            else{
                nowHp = Math.min(nowHp + b , hp);
                nowAtk += a;
            }

        }
        // 모두 통과하게 되면 조건 만족
        return true;

    }
}
