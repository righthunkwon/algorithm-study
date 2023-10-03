package level_13_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 볼링장 아르바이트
// 오른쪽부터 바라보면서 최소 이동 개수를 찾는다.

// 맨 오른쪽 요소보다 더 큰 요소가 나올 경우
// 해당 요소들은 빼내서 정렬할 필요가 있는 요소들이다.
public class P_27979 {
	private static int n, idx, cnt, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 볼링공의 개수
		List<Integer> list = new ArrayList<>();	// 볼링공을 담을 배열
		
		// 배열 요소 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int weight = Integer.parseInt(st.nextToken());
			list.add(weight);
		}
		
		// 정렬 배열 생성
		List<Integer> orderedList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			orderedList.add(list.get(i));
		}
		Collections.sort(orderedList);
		
		idx = n-1; // 정렬된 리스트를 뒤에서부터 보기 위한 인덱스
		cnt = 0; // 안 옮겨도 되는 볼링공의 개수

		// list			: 2  7  6  10  4
		// orderedList	: 2  4  6  7  10
		
		// list			: 2 3 2 3 1 2 4
		// orderedList	: 1 2 2 2 3 3 4
		
		// 뒤에서부터 순회하면서 뒤의 요소가 정렬된 요소와 같을 경우
		// 해당 요소는 옮기지 않아도 되는 볼링공이 된다(그 사이의 볼링공만 옮기면 된다).
		
		// 배열을 끝까지 돌면 옮기지 않아도 되는 요소의 개수가 전부 나오고,
		// 이를 전체 볼링공의 개수에서 빼주면 옮겨야 하는 볼링공의 개수가 나온다.
		for (int i = n - 1; i >= 0; i--) {
			if (list.get(i).equals(orderedList.get(idx)) ) {
				idx--;
				cnt++;
			}
		}
		ans = n - cnt;
		System.out.println(ans);
	}
}
