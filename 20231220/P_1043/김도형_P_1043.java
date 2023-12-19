package AlgoStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q1043_거짓말 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람의 수 N
        int M = sc.nextInt(); // 파티의 수 M
        boolean [] knowTrue = new boolean[N+1]; //진실 아는 사람은 true로
        boolean [] trueparty = new boolean[M]; //진실말해야하는 파티는 true로..
        int K = sc.nextInt(); //진실 아는 사람 수
        for (int i = 0; i < K; i++) {
            knowTrue[sc.nextInt()] = true; //진실 아는 사람은 true로..
        }
        ArrayList<ArrayList<Integer>> parties = new ArrayList<>(); //파티 집합
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt(); // 각 파티의 인원 수
            ArrayList<Integer> members = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                members.add(sc.nextInt());
            }
            parties.add(members);
        } //입력 끝
        for(int x=0;x<M;x++) {
        	for(int i=0;i<M;i++) { //파티별로 인원을 보면서 
            	if(trueparty[i])continue; //이미 진실 말해야되는 파티인게 결정됐으면 볼 필요 x
            	boolean flag=false;
            	for(int j = 0;j<parties.get(i).size();j++) {//해당 파티 멤버들을 보면서 진실 아는놈 있는지 체크
            		if(knowTrue[parties.get(i).get(j)]) {//아는놈 발견
            			flag=true; //flag를 true로 바꾸고 나가
            			break;
            		}
            	}
            	if(flag) { //아는놈 있는 파티면 그 파티 사람 다 진실 알게됨
            		for(int j = 0;j<parties.get(i).size();j++) {
            			knowTrue[parties.get(i).get(j)]=true;
            		}
            		trueparty[i]=true;
            	}
            }
        }//m번 반복하면 전부 다 걸러진다

        int ans = 0;
        for(int i=0;i<M;i++) {
        	if(!trueparty[i])ans++; //거짓말 가능 파티 숫자 카운트
        }
        
        System.out.println(ans);

    }
}
