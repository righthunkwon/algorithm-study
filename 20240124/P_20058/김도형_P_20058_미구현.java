package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q20058_마법사_상어와_파이어스톰 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = (int)Math.pow(2, N); //M = 2^N
		int [][]map = new int[M][M];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//출력확인
		for(int i=0;i<M;i++) {
			System.out.println();
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
		}
		
		int [] level = new int[Q];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			level[i]=Integer.parseInt(st.nextToken());
		}
		
	}//main
}//class
