package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q17471_게리맨더링 {
	
	static int N,total; 
	static boolean[]selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//구역의 개수
		int[]ingu=new int[N+1]; //구역별 인구정보
		total=0; //전체 인구수
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			ingu[i]=Integer.parseInt(st.nextToken());
			total+=ingu[i];
		}
		System.out.println("인구정보:"+Arrays.toString(ingu));
		System.out.println("전체인구:"+total);
		
		int [][] arr = new int [N+1][N+1]; //인접정보 나타낼 2차원 배열
		
		System.out.println("인접 정보");
			System.out.println(Arrays.toString(arr[0]));
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				int x = Integer.parseInt(st.nextToken());
				arr[i][x]=1; //1이면 인접한 것..
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	
	public static void divide(int idx) { //선거구 나누기..
		
		//기저
		if(idx==N) {
			
			return;
		}
		
		
		
		//재귀
		selected[idx]=true;
		divide(idx+1);
		selected[idx]=false;
		divide(idx+1);
		
		
	}
	
}
