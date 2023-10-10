package AlgoStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_Q15686_치킨_배달 {
	static int N, M; // 도시크기 N*N, 최대치킨집 수 M
	static int[][] map; // 도시 정보
	static List<Integer> hr, hc, cr, cc; // 좌표 저장용 리스트
	static boolean[] open;
	static int ans;

	public static void main(String[] args) throws Exception{

		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 도시크기 N*N
        M = Integer.parseInt(st.nextToken()); // 최대 치킨집 수 M

		map = new int[N][N]; // 도시 정보 입력받을 배열 생성

		hr = new ArrayList<Integer>(); // 집r좌표 저장
		hc = new ArrayList<Integer>(); // 집c좌표 저장
		cr = new ArrayList<Integer>(); // 치킨집r좌표 저장
		cc = new ArrayList<Integer>(); // 치킨집c좌표 저장

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken()); // 도시 정보 입력
				map[i][j] = a;
				if (a == 1) { // 1이면 집 좌표 입력
					hr.add(i);
					hc.add(j);
				}
				if (a == 2) { // 2면 치킨집 좌표 입력
					cr.add(i);
					cc.add(j);
				}
			}
		}

		open = new boolean[cr.size()]; // 오픈 여부 나타낼 배열
		ans = Integer.MAX_VALUE;
		
		comb(0,0);
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	}// main

	// 최소의 치킨거리 계산할 메서드
	public static int minChickenDistance() {
		
		int sum = 0;
		for (int i = 0; i < hr.size(); i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < cr.size(); j++) {
				if (open[j] == true) { //오픈한 치킨집이면 
					int dist = Math.abs(hr.get(i) - cr.get(j)) //집에서부터 거리 계산해줌
							+ Math.abs(hc.get(i) - cc.get(j));
					
					min = Math.min(min, dist); //최소 거리 갱신
				}
			}
			sum += min; 
		}
		return sum;
	}

	// 오픈할 치킨집 조합을 구할 메서드
	public static void comb(int start,int cnt) {
		
		//기저
		if(cnt == M) {
			int a = minChickenDistance();
			ans = Math.min(ans, a);
			return;
		}
		
		//재귀
		for(int i = start; i < cr.size();i++) { //@@@@@@@@@@int i = 0 부터로 했다가 시간초과뜸..ㅠㅠ
			open[i]=true; //방문처리
			comb(i+1,cnt+1);
			open[i]=false;
		}
		

	}

}// class
