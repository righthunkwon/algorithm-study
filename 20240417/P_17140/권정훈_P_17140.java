package level_00_basic;

import java.io.*;
import java.util.*;

// 이차원 배열과 연산
public class P_17140 {
	private static int r, c, k;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[101][101];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int rowSize = 3;
		int colSize = 3;

		while (true) {
			
			// 종료조건
			// r행 c열의 값이 k일 경우 종료
			if (arr[r][c] == k) {
				break;
			}
			// 종료조건
			// 시간이 100초가 지날 경우 종료
			if (time > 100) {
				time = -1;
				break;
			}
			
			// 시간 증가
			time++;

			// R연산(행정렬)
			if (rowSize >= colSize) {

				int currColSize = colSize; // 연산을 위한 현재 열 크기 임시 저장 변수
				colSize = 0; // 최댓값을 계산하기 위해 0으로 변경

				// 각 행마다 정렬
				for (int i = 1; i <= rowSize; i++) {
					HashMap<Integer, Integer> hm = new HashMap<>(); // 등장 횟수를 저장할 해시맵
					List<Node> list = new ArrayList<>(); // 정렬용 리스트

					// 열 길이만큼 정렬
					for (int j = 1; j <= currColSize; j++) {
						// 0이 아닐 경우 해당 수의 등장 횟수 증가
						if (arr[i][j] != 0) {
							hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0) + 1);
						}
					}

					// 맵이 비어있을 경우 패스
					if (hm.isEmpty()) {
						continue;
					}

					// 정렬하기 위해 해시맵의 각 요소를 리스트에 저장
					for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
						list.add(new Node(e.getKey(), e.getValue()));
					}

					// 리스트 정렬
					// 등장횟수, 숫자 순으로 오름차순 정렬
					Collections.sort(list, (o1, o2) -> {
						if (o1.cnt > o2.cnt) {
							return 1;
						} else if (o1.cnt == o2.cnt) {
							if (o1.val > o2.val) {
								return 1;
							} else {
								return -1;
							}
						} else {
							return -1;
						}
					});

					// 리스트 크기만큼 배열 값 갱신
					int idx = 0; // 연산 후 열의 길이를 저장하기 위한 인덱스변수
					for (int j = 0; j < list.size(); j++) {
						if (j == 50) break;	// 열 길이가 100 넘어가면 패스
						int length = (j + 1) * 2; // 열 최대값
						idx = length; // 열 최대값 갱신
						
						// 위치별 값 저장
						Node curr = list.get(j);
						arr[i][(j + 1) * 2 - 1] = curr.val;
						arr[i][(j + 1) * 2] = curr.cnt;
					}

					// 연산 후 열 길이와 현재 열 길이를 비교 후 최대값 갱신
					colSize = Math.max(colSize, idx);

					// 열 길이가 줄어들 경우 이전 값을 0으로 변경
					for (int j = idx + 1; j <= currColSize; j++) {
						if (arr[i][j] != 0) {
							arr[i][j] = 0;
						}
					}
				}
			} 
			
			// C연산 (열정렬)
			else { 
				int currRowSize = rowSize; // 연산을 위한 현재 행 크기 임시 저장 변수
				rowSize = 0; // 최댓값을 계산하기 위해 0으로 변경

				// 각 열마다 정렬
				for (int j = 1; j <= colSize; j++) {
					HashMap<Integer, Integer> hm = new HashMap<>(); // 등장 횟수를 저장할 해시맵
					List<Node> list = new ArrayList<>(); // 정렬용 리스트

					// 행 길이만큼 정렬
					for (int i = 1; i <= currRowSize; i++) {
						// 0이 아닐 경우 해당 수의 등장 횟수 증가
						if (arr[i][j] != 0) {
							hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0) + 1);
						}
					}

					// 맵이 비어있을 경우 패스
					if (hm.isEmpty()) {
						continue;
					}

					// 정렬하기 위해 해시맵의 각 요소를 리스트에 저장
					for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
						list.add(new Node(e.getKey(), e.getValue()));
					}

					// 리스트 정렬
					// 등장횟수, 숫자 순으로 오름차순 정렬
					Collections.sort(list, (o1, o2) -> {
						if (o1.cnt > o2.cnt) {
							return 1;
						} else if (o1.cnt == o2.cnt) {
							if (o1.val > o2.val) {
								return 1;
							} else {
								return -1;
							}
						} else {
							return -1;
						}
					});

					// 리스트 크기만큼 배열 값 갱신
					int idx = 0; // 연산 후 행의 길이를 저장하기 위한 인덱스변수
					for (int i = 0; i < list.size(); i++) {
						if (i == 50) break;	// 행 길이가 100 넘어가면 패스
						int length = (i + 1) * 2; // 행 최대값
						idx = length; // 행 최대값 갱신
						
						// 위치별 값 저장
						Node curr = list.get(i);
						arr[length - 1][j] = curr.val;
						arr[length][j] = curr.cnt;
					}

					// 연산 후 행 길이와 현재 행 길이를 비교 후 최대값 갱신
					rowSize = Math.max(rowSize, idx);

					// 행 길이가 줄어들 경우 이전 값을 0으로 변경
					for (int i = idx + 1; i <= currRowSize; i++) {
						if (arr[i][j] != 0) {
							arr[i][j] = 0;
						}
					}
				}
			}
		}

		System.out.println(time);
	}

	private static class Node {
	        int val;
	        int cnt;

	        public Node(int val, int cnt){
	            this.val = val;
	            this.cnt = cnt;
	        }
	    }
}
