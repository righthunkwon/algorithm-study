package level_12_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시계
public class P_2082 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력(4개의 숫자, 각 숫자는 공백으로 구분, 총 5줄)
		String input[] = new String[] { "", "", "", "" };
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp1 = st.nextToken();
			String tmp2 = st.nextToken();
			String tmp3 = st.nextToken();
			String tmp4 = st.nextToken();
			input[0] += tmp1; // 길이: 15
			input[1] += tmp2; // 길이: 15
			input[2] += tmp3; // 길이: 15
			input[3] += tmp4; // 길이: 15
		}

		// 입력된 요소들을 배열에 저장
		char[][] clock = new char[4][15];
		for (int i = 0; i < 4; i++) {
			clock[i] = input[i].toCharArray();
		}

		// 비교할 숫자 목록
		char[] zero = "####.##.##.####".toCharArray();
		char[] one = "..#..#..#..#..#".toCharArray();
		char[] two = "###..#####..###".toCharArray();
		char[] three = "###..####..####".toCharArray();
		char[] four = "#.##.####..#..#".toCharArray();
		char[] five = "####..###..####".toCharArray();
		char[] six = "####..####.####".toCharArray();
		char[] seven = "###..#..#..#..#".toCharArray();
		char[] eight = "####.#####.####".toCharArray();
		char[] nine = "####.####..####".toCharArray();

		// 비교할 숫자 배열
		char[][] clocknum = new char[][] { zero, one, two, three, four, five, six, seven, eight, nine };

		// 브루트 포스
		// clock의 각자리 수와 clocknum의 모든 수를 비교하고 정답 출력
		int i,j,k;
		for (i = 0; i < 4; i++) { // 4개의 숫자(시계의 숫자)
			for (j = 0; j < 10; j++) { // 10개의 숫자(clocknum)
				for (k = 0; k < 15; k++) { // 15줄 동안 순회
					
					// 입력받은 시계에는 불이 켜져있는데, 자리수에 불이 안 켜져있으면 해당 숫자는 아니므로 break;
					if (clock[i][k] == '#' && clocknum[j][k] == '.') {
						break;
					}
					
				}
				
				// 이상이 없을 경우 해당 clocknum이 clock의 숫자
				if (k == 15) {
					System.out.print(j);
					break;
				}
				
			}
			
			// 4개의 숫자 중간에 : 표시
			if (i == 1) {
				System.out.print(":");
			}
		}
	}
}
