package AlgoStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//위치정보 담아줄 클래스 생성
class Pos{
	int x;  //x좌표
	int y;  //y좌표
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class BaekJoon_Q9205_맥주_마시면서_걸어가기 {
	static int n;
	static ArrayList<Pos> list;
	static String ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine()); //테케 수 입력
		
		for(int tc = 1; tc<=T; tc++) {
			
			n = Integer.parseInt(br.readLine()); //맥주 파는 편의점 수 입력
			
			ans = "sad"; //정답 sad로 초기화
			
			list = new ArrayList<Pos>();
			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				list.add(new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			
			bfs();
			
			System.out.println(ans);
			
			
		}//tc
		
	}//main
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>(); //bfs용 큐 생성
		boolean[] visit = new boolean[n+1]; //방문처리용 배열
		queue.offer(list.get(0)); //출발지점을 큐에 넣음
		Pos End = list.get(list.size()-1); //도착지 위치정보 정의
		
		while(!queue.isEmpty()) {
			Pos nowPos = queue.poll(); //현 위치를 큐에서 꺼냄
			
			if(Math.abs(End.x - nowPos.x)+Math.abs(End.y - nowPos.y) <= 1000) {
				ans = "happy";
				return;  //현위치~도착지까지 거리가 1000이 안되면 가능한것!
			}
			for(int i = 1; i<=n; i++) {
				if(!visit[i]) {
					Pos nextPos = list.get(i);
					//현 위치에서부터 거리가 1000 이하여서 갈 수 있는 편의점이 있으면
					//방문처리 후 위치를 큐에 삽입
					if(Math.abs(nextPos.x - nowPos.x) + Math.abs(nextPos.y - nowPos.y) <= 1000) {
						visit[i] = true;
						queue.add(new Pos(nextPos.x, nextPos.y));
					}
				}
				
			}
			
		}//while
		
		
		
		
	}//bfs

}//class
