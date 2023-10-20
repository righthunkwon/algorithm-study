package baek;

import java.io.*;
import java.util.*;

public class Pro_2512_예산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] m = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
			sum += m[i];//예산 다 더함
		}
		int money = Integer.parseInt(br.readLine());
		if (sum <= money) {//다 줘도 예산 초과 X
			int max = 0;
			for (int i = 0; i < N; i++) {
				max = Math.max(max, m[i]); //가장 큰 예산값 찾아서 출력
			}
			System.out.println(max);
		} else {
			int max = money / N; //전체 예산을 지방 수로 나누면 최소 줄 수 있는 예산이다. 
			while (true) {
				int tot = 0;
				for (int i = 0; i < N; i++) {
					if (m[i] <= max)  tot += m[i]; //지방예산 요청이 주어진 돈보다 적으면 다 주기
					else  tot += max;//넘으면 주어진예산 주기 
				}
				if (tot > money) break;//줄수 있는 돈을 초과하면 break하고 현시점 max는 초과한 것이니까 max-1을 정답으로 출력
				max += 1;//초과하지 않았다면 +1해서 한번 더 돌려본다.
			}
			System.out.println(max - 1);
		}
	}
}
