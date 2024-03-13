package study_240313;

import java.io.*;
import java.util.*;

public class Pro_2539_모자이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 행이 반대임 원래랑
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		// 사실 R은 필요가 없어
		List<Integer> list = new ArrayList<>();
		int cnt = Integer.parseInt(br.readLine());// 색종이 장수 100장이하
		int wrong = Integer.parseInt(br.readLine());// 잘못 칠해진 것

		// 행렬 위에 꼭 붙어야함
		int max = 0;
		for (int i = 0; i < wrong; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			max = Math.max(max, r);
			list.add(c - 1);
		}

		Collections.sort(list);
		boolean[] visited;
		// max 크기부터 R 크기까지 중
		int left = max;
		int right = R;
		int mid;
		int ans = -1;
		while (left <= right) {
			mid = (left + right) / 2;
			visited = new boolean[C];
			int cnt2 = 0;
			l: for (int j = 0; j < list.size(); j++) {
				int s_idx = list.get(j);
				if (visited[s_idx]) continue; //이미 색종이로 덮인 곳이라면
				cnt2++; //색종이 수 한 개 추가하고
				for (int k = s_idx; k < s_idx + mid; k++) {//색종이 크기만큼 덮어라
					if (k >= C) continue l;
					visited[k] = true;
				}
			}

			if (cnt2 > cnt) {// 색종이가 더 필요하다면
				left = mid + 1;
			} else {//색종이가 남는다 더 줄일 수 있음?
				ans = mid;
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
