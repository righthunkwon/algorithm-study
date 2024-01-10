
import java.io.*;
import java.util.*;

//그냥 구현으로 모든 조합 (2개씩 묶는) 만들어서 나누기 하고 점수 계산하는 시스템 만들기
//엥 그러면 100000C2이면 1초 넘어갈거같은데???
//음 그럼 A>B일 때 B가 A의 배수이면 A의 배수는 B의 배수이다.
//그냥 배수 약수 개수 구하는거
//내가 다른 사람의 약수라면 이간다.
public class Pro_27172_수나누기게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		int[] score = new int[N];
		boolean[][] visited = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {// i의 배수인지 확인하기
		
		}
	}
}
