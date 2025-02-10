package com.example.algo;
import java.util.*;

public class AlgoApplication{

static int N, R, size;
static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt();
         R = sc.nextInt();

        size = (int)Math.pow(2, N);
        arr = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        // 1번 연산은 각 부분 배열을 상하 반전시키는 연산, 2번 연산은 각 부분 배열을 좌우 반전시키는 연산
        // 3번 연산은 각 부분 배열을 오른쪽으로 90도 회전시키는 연산 , 4번 연산은 각 부분 배열을 왼쪽으로 90도 회전시키는 연산
        // 5~8은 블록단위를 하나로 인식하고 전체를 기준으로 똑같이

        // 하나씩 구현해보자..
        for (int i = 0; i < R; i++) {
            int k = sc.nextInt();
            int l = sc.nextInt();
            int partSize = (int) Math.pow(2, l);
            process(k, partSize);
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    static void process(int num, int partSize) {
        switch (num) {
            case 1: solve1(partSize);
                break;
            case 2: solve2(partSize);
                break;
            case 3: solve3(partSize);
                break;
            case 4: solve4(partSize);
                break;
            case 5: solve5(partSize);
                break;
            case 6: solve6(partSize);
                break;
            case 7: solve7(partSize);
                break;
            case 8: solve8(partSize);
                break;
        }
    }

    static void solve1(int partSize) {
        // 블럭내 상하반전
        for (int i = 0; i < size; i += partSize) {
            for(int j =0;j<size; j+= partSize){
                for(int k =0;k<partSize;k+=2){
                    for(int l =0;l<partSize;l++){
                        int tmp = arr[i+k][j+l];
                        arr[i+k][j+l] = arr[i+partSize-1-k][j+l];
                        arr[i+partSize-1 -k][j+l] = tmp;
                    }
                }
            }
        }
    }
    static void solve2(int partSize) {
        // 블럭 내 좌우 반전
        for(int i=0; i < size;i += partSize){
            for(int j =0;j<size; j+= partSize){
                for(int k =0;k<partSize;k++){
                    for(int l =0;l<partSize;l+=2){
                        int tmp = arr[i+k][j+l];
                        arr[i+k][j+l] = arr[i+k][j+partSize-1 - l];
                        arr[i+k][j+partSize -1 - l] = tmp;
                    }
                }
            }
        }
    }
    static void solve3(int partSize) {
        int[][] temp = new int[size][size];
        // 오른쪽으로 90도 회전
        for (int i = 0; i < size; i += partSize) {
            for (int j = 0; j < size; j += partSize) {
                for (int k = 0; k < partSize; k++) {
                    for (int l = 0; l < partSize; l++) {
                        temp[i + l][j + partSize - 1 - k] = arr[i + k][j + l];
                    }
                }
            }
        }
        arr = temp;
    }
    static void solve4(int partSize) {
        int[][] temp = new int[size][size];
        // 왼쪽으로 90도 회전
        for (int i = 0; i < size; i += partSize) {
            for (int j = 0; j < size; j += partSize) {
                for (int k = 0; k < partSize; k++) {
                    for (int l = 0; l < partSize; l++) {
                        temp[i + k][j + l] = arr[i + l][j + partSize - 1 - k];
                    }
                }
            }
        }
        arr = temp;
    }
    // 블록끼리 상하 반전
    static void solve5(int partSize) {
        int[][] tmp = new int[size][size];
        for (int i = 0; i < size; i += partSize) {
            for (int j = 0; j < size; j += partSize) {
                for (int k = 0; k < partSize; k++) {
                    for (int l = 0; l < partSize; l++) {
                        tmp[size - partSize - i + k][j + l] = arr[i + k][j + l];
                    }
                }
            }
        }
        arr =tmp;
    }
    // 블록끼리 좌우 반전
    static void solve6(int partSize) {
        int[][] tmp = new int[size][size];
        for (int i = 0; i < size; i += partSize) {
            for (int j = 0; j < size; j += partSize) {
                for (int k = 0; k < partSize; k++) {
                    for (int l = 0; l < partSize; l++) {
                        tmp[i+k][size- partSize - j + l] = arr[i + k][j + l];
                    }
                }
            }
        }
        arr = tmp;
    }
    // 7 오른쪽으로 90도 회전
    static void solve7(int partSize) {
        int[][] tmp = new int[size][size];
        // 우선 블록의 위치를 정하고 그 안에서의 위치는 그대로
        for (int i = 0; i < size; i+= partSize) {
            for (int j = 0; j < size; j+= partSize) {
                // 블록의 시작점 정함
                for(int k = 0; k < partSize; k++){
                    for(int l = 0; l < partSize; l++){
                        tmp[j+k][size - partSize -i + l] = arr[i+k][j+l];
                    }
                }

            }
        }
        arr = tmp;
    }
    // 8 왼쪽으로 90도 회전
    static void solve8(int partSize) {
        int[][] tmp = new int[size][size];
        for (int i = 0; i < size; i+= partSize) {
            for (int j = 0; j < size; j+= partSize) {
                // 블록의 시작점 정함
                for(int k = 0; k < partSize; k++){
                    for(int l = 0; l < partSize; l++){
                        tmp[size-partSize -j + k][i +l] = arr[i+k][j+l];
                    }
                }

            }
        }
        arr = tmp;
    }
}



