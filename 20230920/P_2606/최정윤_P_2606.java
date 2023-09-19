import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int su = Integer.parseInt(br.readLine());
		int link = Integer.parseInt(br.readLine());
		map = new HashMap<Integer, int[]>();
		set = new HashSet<>();
		v = 0;
		for (int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] arr = map.getOrDefault(a, new int[101]);
			arr[b] = 1;
			map.put(a, arr);
			int[] arr2 = map.getOrDefault(b, new int[101]);
			arr2[a] = 1;
			map.put(b, arr2);
		} // 입력끝
		set.add(1);
		dfs(1);
		System.out.println(set.size() - 1);

	}

	static Map<Integer, int[]> map;
	static int v;
	static HashSet<Integer> set;

	public static void dfs(int start) {
		int[] arr = map.get(start);
		if (arr != null) {
			for (int i = 1; i < arr.length; i++) {

				if (arr[i] == 1) {
					set.add(i);
					arr[i] = 0;
					int arr2[] = map.get(i);
					arr2[start] = 0;
					map.put(i, arr2);
					dfs(i);
				}
			}
	
		}
		return;
	}
}
