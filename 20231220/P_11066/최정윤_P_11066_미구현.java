import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			for (int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long total = 0;
			while (pq.size() >=2) {
//				System.out.println(pq.size());
				Long join = pq.poll() + pq.poll();
				total+=join;
//				System.out.println(join+"tot"+total);
				pq.add(join);
			}
			System.out.println(total);
		}
	}
}
