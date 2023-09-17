package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15787_기차가어둠을헤치고은하수를 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] train = new int[N]; // 기차 수
		int num;

		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int command = Integer.parseInt(input[0]);
			int idx = Integer.parseInt(input[1]) - 1; // 기차 번호를 0 ~ (N-1)로 변경
			switch (command) {
			case 1:
				num = Integer.parseInt(input[2]) - 1; // 좌석 번호를 0 ~ 19로 변경
				train[idx] |= (1 << num); // 앉아라
				break;
			case 2:
				num = Integer.parseInt(input[2]) - 1;
				train[idx] &= ~(1 << num); // 넌 나가라
				break;
			case 3:
				train[idx] = (train[idx] & ~(1 << 19)) << 1; // 20번째사람 있으면 내보내고 한 칸씩 뒤로
				break;
			case 4:
				train[idx] = (train[idx] & ~1) >> 1; // 첫번째 사람 있으면 내보내고 한 칸씩 앞으로
				break;
			}
		}
		HashSet<Integer> tmp = new HashSet<>();
		for(int i = 0; i < N; i++) {
			tmp.add(train[i]);
		}
		System.out.println(tmp.size());
	}		
}