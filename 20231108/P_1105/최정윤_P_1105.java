package baek;

import java.util.Scanner;

public class Pro_1105_팔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int R = sc.nextInt();
		int min = 0;
		int L_len = String.valueOf(L).length();
		int R_len = String.valueOf(R).length();
    
		if (L_len != R_len)// 길이가 같지 않다면 무조건 8의 개수가 0개인 경우가 껴있음
			min = 0;
      
		else {// L과 R이 같은 길이일 경우
			min = 0;
			char[] Larr = String.valueOf(L).toCharArray();
			char[] Rarr = String.valueOf(R).toCharArray();
			// 달라지는 순간 8이 안나올 수 있음
			// 같으면 무조건 8인지 체크
			int idx = 0;
      
			while (idx<L_len&&Larr[idx] == Rarr[idx]) {
				if (Larr[idx] == '8')	min++;
				idx++;
			}
      
		}
		System.out.println(min);
	}
}
