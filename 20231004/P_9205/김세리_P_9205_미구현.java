import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205_맥주마시면서걸어가기 {
	static int n,hx,hy,fx,fy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer str = new StringTokenizer(br.readLine());
			int hx = Integer.parseInt(str.nextToken());
			int hy = Integer.parseInt(str.nextToken());
			List<int[]> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[]{x,y});
			}
			StringTokenizer s = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(s.nextToken());
			int fy = Integer.parseInt(s.nextToken());

			System.out.print(bfs(list)? "happy" : "sad"+'\n');



		}//t

	}//main

	static boolean bfs(List<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(new int[] {hx,hy});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0], py = pos[1];
			if(Math.abs(px-fx) + Math.abs(py-fy) <= 1000) {
				return true;
			}

			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					int nx = list.get(i)[0], ny = list.get(i)[1];
					int dis = Math.abs(px - nx) + Math.abs(py - ny);
					if(dis <= 1000) {
						visited[i] = true;
						q.add(new int[]{nx,ny});
					}
				}
			}
		}
		return false;
	}

}
