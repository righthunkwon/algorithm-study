import java.io.*;
import java.util.*;

public class Pro_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		// 투포인터 써야할 것 같다..!
		Collections.sort(list);

		int good = 0;
		// 일단 N개가 좋은 수 인지 탐색 ㄱㄱ
		for (int i = 0; i < N; i++) {
			int s = 0;
			int e = N - 1;
			int now = list.get(i);
			while (s < e) {
				if (list.get(s) + list.get(e) == now) { 
					if (s == i)//같을 때 혹시 나를 포함하면 다시 돌리기
						s += 1;
					else if (e == i)
						e -= 1;
					else {//아니라면 일치하는 것 좋다 수 증가
						good += 1;
						break;
					}
				} else if (list.get(s) + list.get(e) > now) {
					e -= 1;
				} else {
					s += 1;
				}
			}
		}
		System.out.println(good);
	}
}
