package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q4307_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); //테스트케이스 개수
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); //막대의 길이
			int n = Integer.parseInt(st.nextToken()); //개미의 수
			int min = 0; //가장 빠른 시간 초기화
			int max = 0; //가장 느린 시간 초기화
			for(int i = 0;i<n;i++) {
				int ant=Integer.parseInt(br.readLine());//개미 위치
				int x = Math.min(L-ant, ant); //각 개미별로 막대에서 가장 빨리 떨어질 방향으로 이동시키기
				min = Math.max(min, x); //그중 가장 오래걸리는 개미 떨어지는 시간이 모든 개미 떨어지는 <<최소 시간>>
				int y = Math.max(L-ant, ant); //개미 중에 막대의 끝과 가장 멀리 떨어진 개미의 거리 구하면 <<최대시간>>
				max = Math.max(max, y);
			}
			System.out.println(min+" "+max);
		}//for tc
	}//main
}
