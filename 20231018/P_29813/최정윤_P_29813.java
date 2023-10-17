package baek;

import java.io.*;
import java.util.*;
public class Pro_29813_최애의팀원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		Queue<String> q = new LinkedList<String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			map.put(name, Integer.parseInt(st.nextToken()));//이니셜과 학번
			q.add(name);
		}

		while (q.size() > 1) {
			int cnt = map.get(q.poll());//학번-1만큼 돌기
			for(int i=1;i<cnt;i++) {
				q.add(q.poll());//패스해서 뒤로 보내기
			}
			q.poll();
		}
		//마지막 남은 사람이니까 qsize1일 때 출력
		System.out.println(q.poll());

	}
}
