package AlgoStudy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_Q4386_별자리_만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double [][]star = new double[N][2];// 0:x좌표 / 1:y좌표
		boolean [] visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			star[i][0]=sc.nextDouble(); //x좌표
			star[i][1]=sc.nextDouble(); //y좌표
		}
		
		double [][]dis = new double[N][N];
		//별들 사이 거리 다 입력
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (i == j) continue;
				dis[i][j]=distance(star[i][0],star[i][1],star[j][0],star[j][1]);
				dis[j][i]=dis[i][j];
			}
		}
		
		//pq에 {별idx , dist} 배열을 넣고 dist 짧은거부터 꺼낸다 
		PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->(int)(a[1]-b[1]));
		int cnt = N; //별 꺼낸 갯수 카운트용
		double ans = 0;
		
		pq.add(new double[] {0,0}); //첫번째 별부터 큐에 넣음(시작점은 거리 0)
		while(!pq.isEmpty() && cnt>0) {
			double[]ns=pq.poll();
			int idx = (int)ns[0]; //최소거리인 별 idx
			if(visit[idx])continue; //이미 최소거리로 연결끝낸 별은 패스
			visit[idx]=true;
			cnt--;
			ans+=ns[1]; //답에 최소거리 더해주기
			for(int i=0;i<N;i++) { //다음 연결할 곳 찾기
				if(visit[i])continue;
				pq.add(new double[] {i,dis[i][idx]});
			}
		}
		System.out.println(ans);
		
		
		
	}//main
	
	//두 좌표 거리 구하는 메서드
	public static double distance(double x1,double y1, double x2, double y2) {
		double res=0;
			
		double tmp = Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2);
		res = Math.sqrt(tmp);
		
		return res;
	}
	
}//class
