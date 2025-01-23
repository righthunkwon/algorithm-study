package com.example.algo;

import java.util.*;

public class AlgoApplication{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 우선 ::가 연속될 경우 0000이 반복되는 경우임
        // 따라서 배열 시작부터 :을 만나게 될경우
        // 그 자리 전까지의 값들을 배열 하나에 넣어 각 배열별로 계산하는 것이 편하다.
        // --> ::을 만날 경우에는 8- 전체배열의 size를 하여 0의 개수가 몇개인지 구하자
        String s = sc.next();
        // -> 안풀려서 차라리 ::을 기준으로 나누고 나중에 계산
        // 1. ::이 앞에 있는 경우 -> 0 , num ->  ::1 0이 7개 필요하므로 8+2(빈 개수) - length
        // 2. ::이 중간에 있는 경우 -> num , num ->  8+1(빈 개수) - length
        // 3. ::이 끝에 있는 경우 -> num ->  8 - length
        // 4. ::이 없는 경우 -> num - 그냥 계산
        String[] arr = s.split("::");
        String[] arr2 = s.split(":");
        // 1번과 2번 경우부터 계산
        int cnt = 0 ; //필요한 0세트의 개수
        String answer = "";
        if(arr.length == 2){
            // 1번 경우
            if(arr[0].equals("")){
                for(int i = 0 ;i < 10 - arr2.length; i++){
                    answer += "0000:";
                }
                // 후에 나머지 부분 추가
                answer += solve(arr[1]);
            }
            // 2번 경우
            else{
                answer += solve(arr[0])+":";
                for(int i = 0;i< 9 - arr2.length;i++){
                    answer += "0000:";
                }
                answer += solve(arr[1]);
            }
        }
        // 3번 4번 경우
        else{
            // 3번 경우
            if(arr[0].length() != 8){
                answer += solve(arr[0])+":";
                for(int i = 0;i< 8 - arr2.length;i++){
                    answer += "0000:";
                }
                // 마지막 : 제거
                answer = answer.substring(0,answer.length() - 1);
            }
            // 4번 경우
            else{
                answer += solve(arr[0]);
            }
        }
        System.out.println(answer);



    }
    //
    public static String solve(String word){
        String sum = "";
        String[] tmp = word.split(":");
        // :을 기준으로 모두 sum에 더해서 return
        for(int i = 0; i < tmp.length; i++){
            // 앞에 빈공간 만큼 0 추가
            for(int j = 0 ; j < 4 - tmp[i].length();j++){
                sum += "0";
            }
            sum += tmp[i]+":";
        }
        sum = sum.substring(0,sum.length() - 1);
        return sum;
      }


}
