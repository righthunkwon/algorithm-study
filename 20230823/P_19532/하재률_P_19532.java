package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19532_수학은비대면강의입니다 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		// 입력 완료
		
		// -999 부터 999 까지 모두 넣어본다..
		for(int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if((a * x) + (b * y) == c 
					&& (d * x) + (e * y) == f)
				System.out.println(x + " " + y);
			}
		}
	}
}
