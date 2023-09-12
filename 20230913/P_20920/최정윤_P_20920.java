import java.io.*;
import java.util.*;

public class Pro_20902_영단어암기는괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() >= M) {
				if (map.containsKey(word)) {
					int count = map.get(word);
					count++;
					map.put(word, count);
				} else {
					map.put(word, 1);
				}
			}
		}
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				// 빈도수가 높은 거가 앞인거 -1가 맞다

				if (map.get(o1) > map.get(o2)) {
					return -1;
				} else if (map.get(o1) < map.get(o2)) {
					return 1;
				} else {

					if (o1.length() > o2.length()) {
						return -1;
					} else if (o1.length() < o2.length()) {
						return 1;
					} else {
						return o1.compareTo(o2);// 사전순 작은게 더 앞으로
					}
				}

			}
		});

		StringBuilder sb = new StringBuilder();
		for (String key : list) {
			sb.append(key + "\n");
		}
		System.out.println(sb.toString());

	}
}
