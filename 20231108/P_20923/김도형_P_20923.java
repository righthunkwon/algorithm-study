package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_Q20923_숫자_할리갈리_게임 {
	
	static int N,M;
	static Deque<Integer> dd,sd,dgd,sgd ;
	static int round;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dd = new ArrayDeque<>(); //도도의 덱
		sd = new ArrayDeque<>(); //수연의 덱
		dgd = new ArrayDeque<>(); //도도 그라운드 덱
		sgd = new ArrayDeque<>(); //수연 그라운드 덱
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int docard = Integer.parseInt(st.nextToken());
			int sucard = Integer.parseInt(st.nextToken());
			dd.addFirst(docard);
			sd.addFirst(sucard); 
		}//입력끝
		
		//덱 맨 위 (숫자 안보이게 쌓기): first
		//덱 맨 아래 (숫자 보이게 쌓기): last
		
		round = 0;
		
		while(round<M) {
			
			int dc = dd.pollFirst(); //도도 덱 맨 위 카드 꺼냄
//			System.out.println("도도가 낸거"+dc);
			dgd.addLast(dc); //도도 그라운드에 놓음
			if(dd.isEmpty()) { //도도 덱 비었으면
				System.out.println("su"); //수연 승
				return;
			}
			
			if(!sgd.isEmpty()) { //수연 그라운드 비어있지 않으면
				if(dc==5) {
					dowin();
				}else if(dc+sgd.peekLast()==5) {
					suwin();
				}
			}else { //수연 그라운드 비어있으면
				if(dc==5) { // 낸게 5면 도도 승
					dowin();
				}
			}
			
			if(round+1==M)break;
			round++;
			
/////////////////////////////////////////////////////////////////////////
			
			int sc = sd.pollFirst(); //수연 덱 맨 위 카드 꺼냄
//			System.out.println("수연이가 낸거"+sc);
			sgd.addLast(sc); //수연 그라운드에 놓음
			if(sd.isEmpty()) { //수연 덱 비었으면
				System.out.println("do"); //도도 승
				return;
			}
			
			if(!dgd.isEmpty()) { //도도 그라운드 비어있지 않으면
				if(sc==5) {
					dowin();
				}else if(sc+dgd.peekLast()==5) {
					suwin();
				}
			}else { //도도 그라운드 비어있으면
				if(sc==5) { // 낸게 5면 도도 승
					dowin();
				}
			}
			
			if(round+1==M)break;
			round++;
			
			
		}//while
		
		if(dd.size()>sd.size()) {
			System.out.println("do"); //도도 승
			return;
		}
		if(sd.size()>dd.size()) {
			System.out.println("su"); //수연 승
			return;
		}
		if(sd.size()==dd.size()) {
		System.out.println("dosu"); //비김
		}
		
	}//main
	
	//도도 판승
	public static void dowin() {
//		System.out.println("dowin");
		while(!sgd.isEmpty()) {
			dd.addLast(sgd.pollFirst());
//			System.out.println("수연ground"+dd.peekLast()+"dd삽입");
		}
		while(!dgd.isEmpty()) {
			dd.addLast(dgd.pollFirst());
//			System.out.println("도도ground"+dd.peekLast()+"dd삽입");
		}
	}
	
	//수연 판승
	public static void suwin() {
//		System.out.println("suwin");
		while(!dgd.isEmpty()) {
			sd.addLast(dgd.pollFirst());
		}
		while(!sgd.isEmpty()) {
			sd.addLast(sgd.pollFirst());
		}
	}

}//class
