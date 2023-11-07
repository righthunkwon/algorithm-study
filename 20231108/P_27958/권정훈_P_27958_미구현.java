package level_22_backtracking;

import java.util.Scanner;

// 사격 연습
public class P_27958 {
	
	private static int n, k, ans, max;
	private static int[] attack;
	private static int[][] map, hp;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 보드 판의 크기
		k = sc.nextInt(); // 사격 횟수
		map = new int[n][n]; // 초기 보드 판
		hp = new int[n][n]; // 남은 체력 배열
		attack = new int[k]; // 총알 공격력 배열 
		ans = -1;
		max = -1;
		
		// 배열 요소 값 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int element = sc.nextInt();
				map[i][j] = element;
				hp[i][j] = element;
			}
		}
		for (int i = 0; i < k; i++) {
			attack[i] = sc.nextInt();
		}
		
		// 중복순열
		for (int i = 0; i < n; i++) {
			perm(i, 0);
		}
		System.out.println(ans);
	}
	
	// 중복순열(n개 중 k개)
	// 각 중복순열마다의 최댓값 갱신
	public static void perm(int idx, int depth){
		// k개 선택 시 종료
        if (depth == k){
        	ans = Math.max(ans, max);
            return;
        }
        
        // 총알 수만큼 반복
        // 너무 많이 돌 거 같다...
        for (int i = 0; i < k; i++) {
        	
        	
            // 다음 경우의 수 선택
            for (int j = 0; j < n; j++){
                perm(j, depth + 1);
            }
        }

    }
}
