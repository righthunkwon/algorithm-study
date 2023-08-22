package back;

import java.io.*;
//주석 정리 다시 할게요
public class Problem_11729 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bf.readLine());
		// 출력 시간 초과로 StringBuilder 사용해야함
		System.out.println(hanoi(1, 3, 2, K) + "\n" + stringBuilder);
		// 개수가 먼저 나와야하므로 stringBuilder에 append말고 따로 출력
	}

	public static StringBuilder stringBuilder = new StringBuilder();//static으로 써야 사용가능

	public static int hanoi(int start, int end, int mid, int K) {
		//재귀함수 만든 방법
		//1번에서 3번으로 옮기는 것으로 가정(1번이 start,3번이 end, 2번이 mid)
		//만약 N이 4면 N-1개인 3개의 탑을 2번 탑에 세운 뒤(1번에서 2번으로 =>그래서 변수 순서 바꿔서 재귀함수 쓰는 것=>start는 동일 mid으로 가야함)
		//1번에서 3번으로 4번 블록을 옮기고
		//2번에서 3번으로 3개의 탑을 다시 세운다.(이것도 mid가 시작점이 되고 start가 mid가 된다)
		//=>계속 반복하니까 재귀함수로 씀 
		
		
		if (K == 1) {
			stringBuilder.append(start + " " + end + "\n");
			return 1;
		}
		//원래는 return  hanoi(start, mid, end, K - 1)+1+hanoi(mid, end, start, K - 1); 인데 
		//중간에 1에 값을 찍어야 좌표순서가 맞음
		int tt = hanoi(start, mid, end, K - 1);
		stringBuilder.append(start + " " + end + "\n");
		//중간에 값 찍는 법 이렇게 나눠서 하면 됨
		return tt + 1 + hanoi(mid, end, start, K - 1);
	}
}
