package _20230920;

import java.util.Scanner;

public class _2606_바이러스 {
	static boolean[] check;
	static int[][] arr;
	static int cnt=0;
	static int C, con;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		con = sc.nextInt();

		// 주어지는 번호를 그대로 사용하기 위해 배열을 하나씩 크게 만든다
		arr = new int [C+1][C+1];
		check = new boolean[C+1];

		// 연결된 곳의 좌표를 받아 해당 위치의 숫자를 1로 바꾼다
		// 행열이 바뀌어도 같은 지점끼리의 연결을 의미하므로 역시 1로 바꾼다
		for(int i=0;i<con;i++) {

			int a =sc.nextInt();				
			int b =sc.nextInt();
			arr[a][b]=arr[b][a]=1;

		}
		// 감염이 1번부터 되었으니까 1부터 시작해서 dfs로 연결된 컴퓨터들을 찾아준다
		dfs(1);

		// 1번 컴퓨터는 답에 해당하지 않으므로 -1을 해준다
		System.out.println(cnt-1);


	}//main

	public static void dfs(int start) {
		// 1번은 바이러스 감염되었으니까 true이다
		check[start]=true;
		// 그리고 true인 컴퓨터가 생길때마다 카운트해준다
		cnt++;

		for(int i=0; i<=C; i++) {
			// 감염된 컴퓨터와 연결된걸 찾고싶은거니까 한쪽은 start로 놓고 나머지 한쪽을 찾는다
			// 그리고 이렇게 찾은 i가 이미 check된 것이 아니면 새롭게 감염된 컴퓨터로 체크해주고
			// 다시 그 컴퓨터를 가지고 연결된 컴퓨터를 찾는다
			if(arr[start][i]==1 && !check[i])
				dfs(i);
		}
	}

}

