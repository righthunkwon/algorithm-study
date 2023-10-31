package _20231101;

import java.io.*;
import java.util.*;

public class _12100_2048_Easy {

	static int N;
	static int[][] board;

	// 이동 방향을 나타내는 상수
	static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = Math.max(result, move(i, 5));
		}

		System.out.println(result);
	}

	// 방향에 따라 블록을 이동시키는 메서드
	static int move(int dir, int depth) {
		int[][] newBoard = copyBoard(); // newBoard: 현재 상태의 보드

		if (depth == 0) {
			return getMaxBlock(newBoard);
		}

		int maxScore = 0;

		switch (dir) {
		case UP:
			for (int j = 0; j < N; j++) {
				int[] arr = new int[N]; // arr: 현재 열에서 이동한 블럭들을 저장할 배열
				int idx = 0;
				for (int i = 0; i < N; i++) {
					if (newBoard[i][j] != 0) { // 현재 위치에 블록이 있을 때
						// 현재 위치의 블록을 arr배열에 넣고, idx를 증가시켜 다음 블록을 저장할 위치를 나타냄
						arr[idx++] = newBoard[i][j];
					}
				}
				for (int i = 1; i < idx; i++) { // arr을 순회하며 같은 값을 갖는 블록을 합친다
					if (arr[i - 1] == arr[i]) { // 현재 블록과 이전 블록이 같은 경우를 검사
						arr[i - 1] *= 2; // 이전 블록의 값을 2배로 만들어 합친다
						arr[i] = 0; // 현재 블록은 없애고 0으로 만든다
					}
				}
				idx = 0; // 다시 인덱스(저장할 위치) 초기화
				for (int i = 0; i < N; i++) { // arr순회하며 블록을 보드에 다시 저장
					if (arr[i] != 0) { // 0이 아닌 값을 가진 경우에만 처리
						newBoard[idx++][j] = arr[i]; // 보드에 값을 저장하고, idx를 증가시켜 다음 위치를 나타냄
					}
				}
				while (idx < N) { // 나머지 빈칸을 0으로 채운다
					newBoard[idx++][j] = 0;
				}
			}
			break;
		case DOWN:
		    for (int j = 0; j < N; j++) { // 열을 기준으로 아래쪽으로 블록을 이동시키는 것을 구현
		        int[] arr = new int[N]; // 이동한 블록들을 저장한 배열
		        int idx = N - 1; // arr 배열에서 값을 저장할 위치, 가장 끝부터 값을 채워나간다
		        for (int i = N - 1; i >= 0; i--) { //현재 열의 각 행을 아래쪽 방향으로 순회하면서 블록을 arr 배열에 저장
		            if (newBoard[i][j] != 0) { // 블록이 0이 아닐 경우 현재 블록을 저장
		                arr[idx--] = newBoard[i][j];
		            }
		        }
		        for (int i = N - 2; i >= 0; i--) { // arr배열을 순회하면서 같은 값을 가진 블록 합친다
		            if (arr[i + 1] == arr[i]) {
		                arr[i + 1] *= 2;
		                arr[i] = 0;
		            }
		        }
		        idx = N - 1; // idx를 초기화하여 newBoard에 값을 저장할 위치를 초기화함
		        for (int i = N - 1; i >= 0; i--) { // 합쳐진 블록을 다시 newBoard에 저장
		            if (arr[i] != 0) {
		                newBoard[idx--][j] = arr[i];
		            }
		        }
		        // 나머지 빈 칸을 0으로 채운다
		        while (idx >= 0) {
		            newBoard[idx--][j] = 0;
		        }
		    }
		    break;

		case LEFT: //비슷한 방식으로 왼쪽 진행, left와 right는 각 행의 이동 방향이 반대가 된다.
		    for (int i = 0; i < N; i++) {
		        int[] arr = new int[N]; 
		        int idx = 0;
		        for (int j = 0; j < N; j++) { 
		            if (newBoard[i][j] != 0) {
		                arr[idx++] = newBoard[i][j];
		            }
		        }
		        for (int j = 1; j < idx; j++) {
		            if (arr[j - 1] == arr[j]) {
		                arr[j - 1] *= 2;
		                arr[j] = 0;
		            }
		        }
		        idx = 0;
		        for (int j = 0; j < N; j++) {
		            if (arr[j] != 0) {
		                newBoard[i][idx++] = arr[j];
		            }
		        }
		        while (idx < N) {
		            newBoard[i][idx++] = 0;
		        }
		    }
		    break;

		case RIGHT: //비슷한 방식으로 오른쪽 진행
		    for (int i = 0; i < N; i++) {
		        int[] arr = new int[N];
		        int idx = N - 1;
		        for (int j = N - 1; j >= 0; j--) {
		            if (newBoard[i][j] != 0) {
		                arr[idx--] = newBoard[i][j];
		            }
		        }
		        for (int j = N - 2; j >= 0; j--) {
		            if (arr[j + 1] == arr[j]) {
		                arr[j + 1] *= 2;
		                arr[j] = 0;
		            }
		        }
		        idx = N - 1;
		        for (int j = N - 1; j >= 0; j--) {
		            if (arr[j] != 0) {
		                newBoard[i][idx--] = arr[j];
		            }
		        }
		        while (idx >= 0) {
		            newBoard[i][idx--] = 0;
		        }
		    }
		    break;
		}

		for (int i = 0; i < 4; i++) {
			maxScore = Math.max(maxScore, move(i, depth - 1));
		}

		return maxScore;
	}

	// 현재 보드에서 가장 큰 블록을 반환하는 메서드
	static int getMaxBlock(int[][] board) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}

	// 보드를 복사하는 메서드
	static int[][] copyBoard() {
		int[][] newBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
}
