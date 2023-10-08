package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	주차 공간 없으면 대기
	주차 공간 생기면 가장 작은 번호에 주차
	대기 장소는 queue
	주차료는 해당 주차 공간의 무게당 요금 x 차량의 무게
	출차시 요금 계산하면 될 듯? 
*/

public class BOJ_5463_주차장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 주차 공간
		int M = Integer.parseInt(st.nextToken()); // 차량 몇 대
		int[] Rs = new int[N+1]; // 주차 공간 무게당 요금
		int[] cars = new int[N+1]; // 주차 공간에 몇 번 차가 주차중인지?
		int[] Wk = new int[M+1]; // 차량의 무게
		
		for(int i = 1; i <= N; i++) {
			Rs[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <= M; i++) {
			Wk[i] = Integer.parseInt(br.readLine());
		}
		
		Queue<Integer> q = new LinkedList<>(); // 대기 공간
		int res = 0;
		
		// 입력받는 입.출차 순서는 차량 대수 * 2 이니께
		l:
		for(int i = 0; i < M * 2; i++) {
			int car = Integer.parseInt(br.readLine());
			
			if(car > 0 ) { // 입차
				for(int j = 1; j <= N; j++) { // j가 1부터 N까지 돌기때문에 작은 번호의 빈자리부터 탐색
					if(cars[j] == 0) { // 해당 자리가 비어있다면
						cars[j] = car; // 주차 ㄱㄱ
						continue l; // 주차 했으면 다음 입력 처리하자
					}
				}
				q.add(car); // 빈자리 없으면 요까지 도달해서 대기 공간으로 ㄱㄱ
			} else { // 출차
				car = -car;
				for(int j = 1; j <= N; j++) {
					if(cars[j] == car) { // 주차된 차 찾아서
						cars[j] = 0; // 해당 자리 비워두고
						res += Rs[j] * Wk[car]; // 무게당 비용 * 차량 무게
						// 대기공간에 차 있으면 해당 자리에 젤 앞에놈 넣기
						if(!q.isEmpty()) cars[j] = q.poll();
					}
				}
			}
		}
		System.out.println(res);
	}
}
