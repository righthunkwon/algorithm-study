package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _17471_게리맨더링 {
	static int N;
	static int[] population;
	static List<ArrayList<Integer>> connection;
	static boolean[] selected;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			population[i]=Integer.parseInt(st.nextToken());
		}
		connection = new ArrayList<>();
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0;j<a;j++) {
				int num = Integer.parseInt(st.nextToken());
				connection.get(i).add(num-1); // 배열이니까 1빼준다
			}
		} // 입력끝
		
		// 두 그룹으로 나누고
		// 나뉜애들이 연결되어있는지, 그룹 크기가 모두 1 이상인지 확인하고 아니면 return
		// 나뉜애들 인구 차이 구하고 최소값 구하기
		// 최솟값이 여전히 max 숫자일 땐 -1을 출력한다 아니면 최솟값 출력한다
		divided(0);
	}//main
	
	static void divided(int idx) {
		if(idx==N) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(selected[i]) A.add(i);
				else B.add(i);
			}
			if(A.size()==0||B.size()==0) return;
			//A가 연결되어 있고 B가 연결되어 있으면 인구수 차이 구하기
		}
		selected[idx]=true;
		divided(idx+1);
		selected[idx]=false;
		divided(idx+1); //??
	}//divided
	
	static void connected(List<Integer> list) {
		//연결되어있는지 쳌
	}
	
	static void diff(List<Integer> list) {
		// 두 리스트 간에 인구수 쳌
	}
	

}
