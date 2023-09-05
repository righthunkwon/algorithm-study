package level_35_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 완전 이진 트리
// 중위순회(LVR)의 역과정을 상상!
// 중위순회의 결과에서 '가운데 값'은 해당 레벨의 부모노드!

// 1 6 4 3 5 2 7
// 레벨0(전체 트리)의 루트 노드는 가운데 값인 3

// 1 6 4 // 3 // 5 2 7
// 레벨1의 부모노드는 각각 가운데 값인 6과 2

public class P_9934 {
	private static int k;
	private static int[] arr;
	private static List<ArrayList<Integer>> result;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); // 빌딩 번호
		arr = new int[(1 << k) - 1]; // 빌딩 번호 배열
        result = new ArrayList<>(); // 트리의 level에 맞게 노드를 저장하기 위한 ArrayList

        // level마다 요소가 여러개 있을 수 있으므로 이차원 ArrayList로 구현
        for (int i = 0; i < k; i++) {
        	result.add(new ArrayList<>());
        }

		// 빌딩 번호 배열 요소 입력
		for (int i = 0; i < (1 << k)-1; i++) {
			arr[i] = sc.nextInt();
		}

		// 재귀함수 호출
		recursion(0, (1 << k)-1, 0);
		
		// 출력을 위해 StringBuilder 활용
        for (int i = 0; i < k; i++) {
            for (int j : result.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        
        // 정답 출력
		System.out.println(sb);
	}

	private static void recursion(int st, int ed, int lv) {
		// 기저부분(종료조건)
		if (lv == k) {
			return;
		}

		// 재귀부분(반복수행)
		int mid = (st + ed) / 2; // 중간값
		result.get(lv).add(arr[mid]); // 중간값을 level에 맞는 2차원 ArrayList에 순서대로 삽입

		recursion(st, mid - 1, lv + 1); // 왼쪽 노드에서의 중간 요소(부모 노드) 판단
		recursion(mid + 1, ed, lv + 1); // 오른쪽 노드에서의 중간 요소(부모 노드) 판단
	}
}
