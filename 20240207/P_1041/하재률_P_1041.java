package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1041_주사위 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long N = Integer.parseInt(br.readLine());
		
		long[] dice = new long[6];
		st = new StringTokenizer(br.readLine());
		long hana = 0;
		for(int i = 0; i < 6; i++) {
			dice[i] = Long.parseLong(st.nextToken());
			hana = hana > dice[i] ? hana : dice[i];
		}
		
		long[] tmp = new long[3];
		tmp[0] = dice[0] < dice[5] ? dice[0] : dice[5];
		tmp[1] = dice[1] < dice[4] ? dice[1] : dice[4];
		tmp[2] = dice[2] < dice[3] ? dice[2] : dice[3];
		Arrays.sort(tmp);
		
		long one = tmp[0];
		long two = tmp[0] + tmp[1];
		long three = tmp[0] + tmp[1] + tmp[2];
		
		long res = N == 1 ? dice[0]+dice[1]+dice[2]+dice[3]+dice[4]+dice[5] - hana 
				: three * 4 + two * ((N-2) * 4 + (N-1) * 4) + one * ((N-1) * (N-2) * 4 + (N-2)*(N-2));
		System.out.println(res);
		
	}
}
