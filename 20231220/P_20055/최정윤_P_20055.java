import java.io.*;
import java.util.*;

public class Pro_20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belt = new int[2 * N];			//내구도
		boolean[] robot = new boolean[2 * N];	//그 자리에 로봇이 있는가
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int result = 0;
		//0~2*N-1까지 인데 사이클이 도니까 2N으로 나눈 나머지로 계산해야겠다 .
		
		while (true) {
			result++;	//단계+1
			start--;	//오른쪽으로 도니까, 시작점은 왼쪽
			if (start < 0)//시작점 2N-1은 따로 세팅
				start = 2 * N-1;
			if(robot[(start+N-1)%(2*N)])robot[(start+N-1)%(2*N)]=false;//돌렸는데 내리는 자리에 로봇이 있다면 내리고 false처리해라
			for (int i = start + N - 2; i > start; i--) {//내리는 위치부터 지점까지 
														//로봇 다음칸으로 옮기기
														//로봇이 존재, 그 다음칸에 로봇이 없고 내구도가 1이상이면 
				if (robot[i % (2 * N)] && !robot[(i+1) % (2 * N)] && belt[(i+1) % (2 * N) ] >= 1) {
					if (i != start + N - 2) {	//로봇이동
						robot[(i+1) % (2 * N)] = true;// 어차피 내리는 위치에서는 바로 내리니까 true 표시 할 필요 없음
					}
					robot[i % (2 * N)] = false;
					belt[(i+1) % (2 * N)]--;	//다음칸 내구도 -1
				}
			}
			if (belt[start] >= 1) {	// 내구도 1이상이면,새로운 로봇 올리기
				belt[start]--;
				robot[start] = true;
			}
			int cnt = 0;
			for (int i = 0; i < 2 * N; i++) {//내구도 0인거 개수 카운트
				if (belt[i] <= 0)
					cnt++;
			}
			if (cnt >= K)//이 때 종료
				break;
		}
		System.out.println(result);
	}
}
