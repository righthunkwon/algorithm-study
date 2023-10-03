package AlgoStudy;

import java.util.ArrayList;
import java.util.Scanner;

class Town implements Comparable<Town> {
    int end;
    int weight;
 
    Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Town arg0) {
        return weight - arg0.weight;
    }
}

public class BOJ_Q1238_파티 {
	
	static int N,M,X;
	static ArrayList<ArrayList<Town>> arrList, reverse_arrList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //학생 수
		M = sc.nextInt(); //도로 수(단방향 간선?)
		X = sc.nextInt(); //X번 마을에 모임(1<=X<=N)
		
		arrList = new ArrayList<>(); // 문제의 입력을 그대로 받은 배열
	    reverse_arrList = new ArrayList<>(); // 문제의 입력을 반대로 받은 배열
		
	    for (int i = 0; i <= N; i++) {
            arrList.add(new ArrayList<>());
            reverse_arrList.add(new ArrayList<>());
        }
		
	}

}
