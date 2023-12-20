package level_00_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 컨베이어 벨트 위의 로봇
public class P_20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 벨트의 길이(2n)
		int k = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸의 최대 개수

		// 내구도 배열 요소 입력
		// 변경이 잦으므로 int[] 보다는 ArrayList 활용
		List<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		// 로봇 배열 초기화
		boolean[] robot = new boolean[n];

		int ans = 1; // 단계
		int cnt = 0; // 내구도가 0인 칸의 개수
		
		// 각 단계를 나타내는 반복문
		while (true) {
			// 1. 벨트 회전
			int last = arr.get(2 * n - 1);
			arr.remove(2 * n - 1);
			arr.add(0, last);

			// 2. 로봇 한 칸 이동
			for (int i = n - 1; i >= 1; i--) {
				robot[i] = robot[i - 1];
			}
			robot[n - 1] = false;
			robot[0] = false;

			// 2. 로봇 전체 이동
			for (int i = n - 1; i >= 1; i--) {
				int durability = arr.get(i); // 내구도
				
				// 각 내구도가 0보다 크고
				// 현재 자리에 로봇이 없고 이전 자리에 로봇이 있으면
				// 로봇을 옮기고 내구도를 1 감소시키고 이전 자리의 로봇을 없앤다.
				if (durability > 0 && !robot[i] && robot[i - 1]) {
					robot[i] = true;
					arr.set(i, durability - 1);
					robot[i - 1] = false;
					
					// 만약 감소시킨 내구도가 0이라면
					// 내구도가 0인 벨트의 칸 수를 증가시킨다.
					if (durability - 1 == 0) {
						cnt++;
					}
				}
			}
			
			// 3. 로봇 올리기
			// 올리는 위치의 내구도가 0보다 크면
			// 해당 위치의 내구도를 1감소시키고 새로운 로봇을 올린다.
			int first = arr.get(0);
			if (first > 0) {
				arr.set(0, first - 1);
				robot[0] = true;
				
				// 만약 감소시킨 내구도가 0이라면
				// 내구도가 0인 벨트의 칸 수를 증가시킨다
				if (first - 1 == 0) {
					cnt++;
				}
			}

			// 4. 내구도가 0인 칸이 k개 이상이라면 종료
			// 조건문을 ==로 해서 시간초과가 발생했었다. 문제를 잘 읽자.
			if (cnt >= k) {
				break;
			}

			// 단계 증가
			ans++;
		}
		
		// 정답 출력
		System.out.println(ans);
	}

}
