package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2*N; i++) list.add(Integer.parseInt(st.nextToken()));
		
		boolean[] robot = new boolean[N];
//		System.out.println(list);
		
		int cnt = 0;
		int turn = 1;
		while(true) {
			list.add(0, list.get(2*N-1));
			list.remove(2*N);
			for(int i = N-1; i >= 0; i--) {
				if(robot[i]) {
					robot[i] = false;
					robot[i+1] = true;
				}
			}
//			System.out.println("한 칸 옮기기"+list);
//			System.out.println("로봇전"+Arrays.toString(robot));
			
			for(int i = N-2; i >= 0; i--) {
				robot[N-1] = false;
				if(list.get(i+1) > 0 && robot[i] && !robot[i+1]) {
					robot[i] = false;
					robot[i+1] = true;
					list.set(i+1, list.get(i+1) - 1);
					if(list.get(i+1) == 0) cnt++;
				}
			}
//			System.out.println("로봇후"+Arrays.toString(robot));
//			System.out.println("로봇 옮기기"+list);
			
			if(list.get(0) > 0) {
				robot[0] = true;
				list.set(0 ,list.get(0) - 1);
				if(list.get(0) == 0) cnt++;
			}
//			System.out.println("로봇 놓기" + list);
//			System.out.println(Arrays.toString(robot));
			
			if(cnt >= K) break;
			turn++;
			
//			System.out.println(turn + "번째 단계 %%%%%%%%%%%%%%%");
//			System.out.println("최종"+list);
		}
		System.out.println(turn);
	}
}
