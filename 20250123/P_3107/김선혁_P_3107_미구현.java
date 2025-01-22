package com.example.algo;
//////////////////////// 반례좀 찾아주실분 //////////////////////////
import java.util.*;

public class AlgoApplication{


    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // 우선 ::가 연속될 경우 0000이 반복되는 경우임
            // 따라서 배열 시작부터 :을 만나게 될경우
            // 그 자리 전까지의 값들을 배열 하나에 넣어 각 배열별로 계산하는 것이 편하다.
        // --> ::을 만날 경우에는 8- 전체배열의 size를 하여 0의 개수가 몇개인지 구하자
        String line = sc.next();
        String[] word = line.split(":");
        String answer = "";
        for(int i = 0 ; i < word.length ; i++){
            String s = word[i];
            // 빈칸일 경우에는 다음 배열도 확인해보자
            // 다음 배열도 빈칸이면 8 - word의 길이 +2만큼 모두 0이다.
            if(s.equals("")){
                // 다음 배열 확인
                if(i+1 < word.length && word[i+1].equals("")){
                    // 0채우기
                    for(int in = 0 ;in < 10- word.length ;in++){
                        answer += "0000:";
                    }
                    // 다음것도 확인했으니 i를 +1 더해준다
                    i++;
                }
                // 다음 배열이 빈칸이 아니라면
                else {
                    answer += "0000:";
                }
            }
            // 빈칸이 아니라면 4개 맞춰서 answer에 더해줌
            else{
                String sum = "";
                for(int j = 0 ; j< 4- s.length();j++){
                    sum += "0";
                }
                answer += sum + s +":";
            }
        }
        // 여기서 마지막에 ::이 오는 경우 word에 채워지지 않기 때문에
        // 그 수 만큼 더 넣어줘야한다.
        if(answer.length() != 40){
            for(int i = 0 ; i < 8- word.length;i++){
            answer += "0000:";
            }
        }
        // 마지막에 붙은 : 을 빼야한다.
        System.out.println(answer.substring(0, answer.length()-1));


        }



}
