package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q2666_벽장문의_이동 {
	static int N,M,ans;
	static int[]order;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //벽장의 갯수 N
		int a = sc.nextInt(); //열린 벽장1
		int b = sc.nextInt(); //열린 벽장2
		int left = Math.min(a, b); //작은게 왼쪽 초기 문
		int right = Math.max(a, b); //큰게 오른쪽 초기 문
		M = sc.nextInt(); //벽장 사용 수
		order=new int[M]; //벽장 사용 순서 저장용 배열
		for(int i=0;i<M;i++) {
			order[i]=sc.nextInt();
		}
		ans=Integer.MAX_VALUE;
		dfs(0,left,right,0);
		System.out.println(ans);
	}//main


  //다음 열릴 벽장이 left보다 왼쪽이면 무조건 왼쪽꺼 이동, 반대의 경우 오른쪽꺼 이동
	//다음 열릴 벽장이 left,right 사이의 벽장일 경우 왼쪽꺼이동하는 경우와 오른쪽꺼 이동하는 2가지 경우로 dfs
	//idx : 몇번쨰 순서인지 / sum : 지금까지 이동 횟수 저장
	public static void dfs(int idx, int left, int right, int sum) {
		//기저
		if(idx == M) { //M번 이동 다 했으면 끝내자
			ans = Math.min(ans, sum); //더 작으면 갱신
			return;
		}
		//재귀
		//이미 열린곳을 사용할 차례이면 sum늘릴 필요 없이 다음 dfs진행
		if(left==order[idx] || right==order[idx]) {
			dfs(idx+1,left,right,sum); 
		}
		//왼쪽열린벽장보다 왼쪽 벽장 사용해야되면 
		else if(order[idx]<left) {
			dfs(idx+1,order[idx],right,sum+left-order[idx]);
		}
		//오른쪽열린벽장보다 오른쪽 벽장 사용하야되면
		else if(order[idx]>right) {
			dfs(idx+1,left,order[idx],sum+order[idx]-right);
		}
		//열린 두 벽장 사이의 벽장 사용해야되면
		else {
			dfs(idx+1,order[idx],right,sum+order[idx]-left);
			dfs(idx+1,left,order[idx],sum+right-order[idx]);
		}
	}
}//class
