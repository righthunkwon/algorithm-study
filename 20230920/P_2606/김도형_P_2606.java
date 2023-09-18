package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_Q2606_바이러스 {
	
	static boolean [] visit; //방문 확인 배열
	static int v; //정점 수
	static int e; //간선 수
	static Queue<Integer>queue; //bfs용 큐
	static int [][]arr; //연결정보 담을 배열
	static int cnt ; // 감염된 컴퓨터 수

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt(); // 컴퓨터의 수(정점의 수)
		e = sc.nextInt(); // 연결된 쌍의 수 ( 간선의 수)
		
		queue = new LinkedList(); //bfs용 queue 생성
		
		arr = new int[v+1][v+1]; //연결 정보 담을 배열 생성
		
		visit = new boolean [v+1]; //방문 확인용 배열 생성
		
		for( int i = 0 ; i<e ;i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a][b]=1;
			arr[b][a]=1; //무방향 그래프이므로..
		}//for
		
		bfs(1);
		System.out.println(cnt-1);  //1번 컴퓨터는 제외하므로 -1 해준다
			
	}//main
	
	/*
	 * v : 시작점
	 * 
	 * */
	public static void bfs(int st) {
		
		visit[st]=true; // st 방문 처리
		queue.add(st); //감염된 1번 컴퓨터 큐에 넣기
		
		
		while(!queue.isEmpty()) { //큐가 빌때까지 반복
			
			int x = queue.poll(); 
			cnt++;  //감염된 컴퓨터이므로 큐에서 빼면서 카운트해준다!

			for(int i = 0 ; i<v+1; i++) {  // i < v 라고 했다가 한번 틀림...ㅠㅠ
				
				if(arr[x][i]==1 && visit[i]==false) { //방금 queue에서 뽑은 감염된 컴과 연결되어있고 visit한적 없으면.
					queue.add(i); //큐에 집어 넣고
					visit[i]=true; //방문처리
					
				}//if
				
				
			}//for
		}//while
			
	}//bfs
	
}
