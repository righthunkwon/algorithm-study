package study_240410;

import java.util.*;
import java.io.*;

public class Pro_2602_돌다리건너기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] magic = (" " + br.readLine()).toCharArray();
		char[] d = br.readLine().toCharArray();
		char[] a = br.readLine().toCharArray();

		int[][] dp = new int[d.length][2];
		int[][] cnt = new int[d.length][2];
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				//	RGS면 각각의 숫자 저장하고 그 전 숫자의 합 더해본다 .....? 
			}
		}

	}

}
