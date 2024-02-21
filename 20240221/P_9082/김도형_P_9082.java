package algo_study;

import java.util.Scanner;

public class BOJ_Q9082_지뢰찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테케 수
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int []num = new int[N];
			char[] cha = new char[N];
			sc.nextLine(); //개행
			String str = sc.nextLine();
			String str2 = sc.nextLine();
			int total = 0; //첫줄 숫자 합
			for(int i=0;i<N;i++) {
				num[i]=str.charAt(i)-'0'; //숫자 입력
				cha[i]=str2.charAt(i); //블록 상태 입력
				total+=num[i];
			}
			int ans = (total+2)/3;
			System.out.println(ans);
		}//tc
	}//main
}//class


/*
 * 지뢰 1개당 total 3씩 늘어남
 * 
 * 단, 지뢰가 양쪽 끝에 있는건 2씩 늘어남
 * 
 * 양쪽 끝에 둘다 지뢰가 있다고 쳐도, +2를 해주고 나누기 3 하면 지뢰 수가 됨.
 * 양쪽 끝에 다 지뢰가 없어도, +2를 했다고 지뢰 수를 1 더 세지 않음!
 * 
 * */
