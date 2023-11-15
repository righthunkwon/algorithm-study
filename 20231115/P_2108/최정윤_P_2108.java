package baek;

import java.io.*;
import java.util.*;

public class Pro_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a;
			list.add(a);
		}
		Collections.sort(list);

//여기부터 최빈값 구하기...
		int[][] arr = new int[2][4001];// 행 0: 음수 /1: 양수
		int max = 0;
		//그 칸의 값을 +1시키면서 max 값 구해놓기
		for (int i = 0; i < N; i++) {
			int num = list.get(i);
			if (num > 0) {
				arr[1][num] += 1;
				max = Math.max(max, arr[1][num]);
			} else {
				arr[0][-num] += 1;
				max = Math.max(max, arr[0][-num]);
			}
		}
		//max값인지 확인 => 최빈값이 여러개면 두번째로 작은 수 출력해야하기 때문에 for문 -4000부터 돌고 cnt가 2이면 종료
		int cnt = 0;
		int many = 4001;
		for (int i = 4000; i >= 0; i--) {
			if (arr[0][i] == max) {
				many = -i;
				cnt++;
				if (cnt == 2)
					break;
			}
		}
		if (cnt != 2) {
			for (int i = 0; i < 4001; i++) {
				if (arr[1][i] == max) {
					many = i;
					cnt++;
					if (cnt == 2)
						break;
				}
			}
		}



		System.out.println(Math.round(sum / N));
		System.out.println(list.get(N / 2));
		System.out.println(many);
		System.out.println(list.get(N - 1) - list.get(0));
	}
}
