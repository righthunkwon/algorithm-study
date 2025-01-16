package com.example.algo;

import java.util.Scanner;

public class AlgoApplication{
    static int N;
    static int M;
    static int[][] arr;
    static int[] size;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
      // 애벌레들은 매일 에너지를 모아서 정오에 자라고 크기는 0,1,2 중 하나

        // 제일 왼쪽 열과, 제일 위쪽 행의 애벌레들은 자신이 자라는 정도를 스스로 결정
        // 나머지 애벌레들은 자신의 왼쪽(L), 왼쪽 위(D), 위쪽(U)의 애벌레들이 다 자란 다음 그 날 가장 많이 자란 애벌레가 자란 만큼 자신도 자란다.
        // 나머지 애벌레들 방향은 왼쪽 위에서 부터 오른쪽으로 진행

        // 누적합 방식을 사용하여 각 애벌레의 크기를 계산합니다.
        // 0번째 행과 0번째 열의 크기를 먼저 계산한 후, 나머지 영역을 채워가는 방식 선택

        int N = sc.nextInt(); // NXN격자 생성
        int M = sc.nextInt(); // M일만큼 진행
        // 0번째 행과 열을 제외한 2차원 배열의 원소는 자신이 위치한 열의 0번째 원소와 같은 증가치를 가진다.
        // 0번째 행과 열의 증가만 체크해 주고, 최종적으로 각 행의 0번째 원소를 제외한 나머지 원소는 0번째 행의 원소를 출력하면 된다.
        arr = new int[N][N];
        size = new int[2*N];
        // 자라는 크기  0의 개수, 1의 개수, 2의 개수를 입력받음
        // 첫날에 만약 2 3 0 이렇게 받으면 +1 2개 +2 3개 이렇게
        for(int t=0;t<M;t++) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           int c = sc.nextInt();
            size[a]++;
            size[a+b]++;
        }
        int sum=0;
        int idx=0;
        for(int i=N-1;i>=0;i--) {
        // sum은 크기 변화의 누적 합을 저장하고
        // arr[i][0]에 그 행의 크기를 누적합으로 저장
            sum+=size[idx++];
            arr[i][0]=sum;
        }
        // arr[0][i]에는 그 열의 크기를 누적합으로 저장
        for(int i=1;i<N;i++) {
            sum+=size[idx++];
            arr[0][i]=sum;
        }
        // arr[i][j]는 해당 행의 0번째 열 값인 arr[0][j]와 동일하게 설정
        // -> 각 열에 대해 첫 번째 행의 값을 복사하는 방식
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                arr[i][j]=arr[0][j];
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]+1+" ");
            }
            System.out.println();
        }

    }

}
