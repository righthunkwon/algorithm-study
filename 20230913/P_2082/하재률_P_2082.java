package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2082_시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<char[][]> num = new ArrayList<char[][]>();
		// 0 ~ 9 까지 모두 만들어놓구요
		num.add(new char[][] {{'#','#','#'},{'#','.','#'},{'#','.','#'},{'#','.','#'},{'#','#','#'}});
		num.add(new char[][] {{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'}});
		num.add(new char[][] {{'#','#','#'},{'.','.','#'},{'#','#','#'},{'#','.','.'},{'#','#','#'}});
		num.add(new char[][] {{'#','#','#'},{'.','.','#'},{'#','#','#'},{'.','.','#'},{'#','#','#'}});
		num.add(new char[][] {{'#','.','#'},{'#','.','#'},{'#','#','#'},{'.','.','#'},{'.','.','#'}});
		num.add(new char[][] {{'#','#','#'},{'#','.','.'},{'#','#','#'},{'.','.','#'},{'#','#','#'}});
		num.add(new char[][] {{'#','#','#'},{'#','.','.'},{'#','#','#'},{'#','.','#'},{'#','#','#'}});
		num.add(new char[][] {{'#','#','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'}});
		num.add(new char[][] {{'#','#','#'},{'#','.','#'},{'#','#','#'},{'#','.','#'},{'#','#','#'}});
		num.add(new char[][] {{'#','#','#'},{'#','.','#'},{'#','#','#'},{'.','.','#'},{'#','#','#'}});
		
		// 입력 받아요
		char[][] c = new char[5][15];
		for(int i = 0; i < 5; i++) {
			c[i] = br.readLine().toCharArray();
		} // 입력 완료
		
		// j가 0 4 8 12 부터 시작해야 되니까
		for(int st = 0; st <= 12; st += 4) {
			// 0 ~ 9 까지 비교해보자
			l1: for(int idx = 0 ; idx <= 9; idx++) {
				boolean flag = true; // flag를 true로 초기화 시키고 false인경우 break걸자
				l2 : for(int i = 0; i < 5; i++) {
					for(int j = st, k = 0; j < st + 3; j++,k++) {
						if(c[i][j] == '#' && num.get(idx)[i][k] == '.') {
							flag = false;
							break l2; // 만들 수 없는 숫자인 경우 다음 숫자와 비교를 시작하자
						}
					}
				}
				// 이까지 무사히 ture인상태로 통과했으면 만들 수 있는 숫자이니까
				// Stringbilder에 추가시키고 다음 숫자 0~9 비교 들어가자
				if(flag) {
					sb.append(idx);
					break l1;					
				}
			}
			// 두번째 숫자 sb에 추가시키고 나서 떙땡 하나 넣어주기
			if(st==4)sb.append(":");
		}
		System.out.println(sb);
	}
}
