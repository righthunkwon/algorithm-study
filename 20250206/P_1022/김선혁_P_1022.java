package com.example.algo;
import java.util.*;

public class AlgoApplication{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 최대로 나올수 있는 칸의 수는 10000*10000
        // --> 무조건 시간초과라 규칙을 찾아서 바로바로 출력해야 한다.

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int[][] arr = new int[x2-x1+1][y2-y1+1];
        // 우선 배열안에 값들을 넣는 과정을 생각해보자
        // 방향은 오,위,왼,아 방향으로

        // 우선 주변을 생각하면 2번째 틀은 2~9 , 3번쨰 틀은 10 ~ 25 이런식으로 존재
        // 껍데기의 수는 오른쪽에서 시작해서 오른쪽 아래의 숫자가 가장 큰 숫자
        // -> 오른쪽 숫자들은(대각선위 제외) 위로갈 수록 +1 , 위쪽 숫자들은 y가 -일수록 +1
        // 왼쪽 숫자들은 x+ -> +1 , 아래쪽숫자들은 y+ -> +1
        int max = 0;
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                arr[i-x1][j-y1] = solve(i,j);
                max = Math.max(max,arr[i-x1][j-y1]);
            }
        }
        int cnt = String.valueOf(max).length();
        System.out.println(cnt);
        // 출력 형식 떄문에 만약 가장 큰수의 자릿수만큼, 안되는 수는 앞에다 붙이고 해야한다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(String.format("%" + cnt + "d ", arr[i][j])); // cnt만큼의 자릿수 맞추기
            }
            System.out.println();
        }

    }

    static int solve(int x , int y){
        // 우선 위치부터 파악하자
        // 0,0을 기준으로 시작하니까 몇번쨰 테두리인지 확인
        // 두개중에 절대값의 (큰수의 값+1)번쨰 테두리에 존재
        int pos = Math.max(Math.abs(x), Math.abs(y)); // -> 1,1 일경우 2번째지면 1로나옴
        // pos번째 테두리의 숫자의 범위를 구해서 끝좌표에 따라 구해보자
        // 1 -> 1 , 2 -> 9 , 3 -> 25
        int num = (int) Math.pow(2*pos -1 , 2);
        // 방향은 큰수부터 순서대로 가야하므로 아래, 왼쪽, 위, 오른쪽 순으로 진행 , num+1부터 존재
        // 숫자보면 2일경우 아래는 7번쨰부터 진행(7~9) , 왼쪽은 5부터 진행 ...
        if(x == pos){
            return num + pos* 7 + y;
        }
        else if(y == -pos){
            return num + pos*5 + x;
        }
        else if(x == -pos){
            return num + pos*3 - y;
        }
        else{
            return num + pos -x;
        }

    }

}
