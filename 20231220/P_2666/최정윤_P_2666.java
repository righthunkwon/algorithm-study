
import java.io.*;
import java.util.*;

public class Pro_2666_벽장문의이동 {
	static int useCnt, min;
	static int[] use, open;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		open = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		open[0] = Integer.parseInt(st.nextToken()) - 1;
		open[1] = Integer.parseInt(st.nextToken()) - 1;

		useCnt = Integer.parseInt(br.readLine());
		use = new int[useCnt]; //열어야하는 벽장문
		min = Integer.MAX_VALUE;
		for (int i = 0; i < useCnt; i++) {
			use[i] = Integer.parseInt(br.readLine()) - 1;
		}
		//본인기준 열려있는 문 두개를 다 선택해본다 . 뭐가 최소인지 모르니까
		//2의20제곱 
		//열려있는 문 2개를 배열로 저장한 후 dfs로 모든 것을 돈다. 
		
		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int useIdx, int total) {
		if (useIdx == useCnt) {        //모든 벽장문 다 열었으면
			min = Math.min(total, min);//전체문 이동횟수 최솟값구하기
			return;
		}
		
		for(int i=0;i<2;i++) {
			int imsi = open[i];
			open[i] = use[useIdx]; //i번째 열린문을 밀어서 내 벽장을 열었다고 가정, 이제는 내 벽장이 열린 것이므로 open에 나를 넣는다.
			dfs(useIdx + 1, total + Math.abs(use[useIdx] - imsi));
			open[i]=imsi;
		}
	}
}
