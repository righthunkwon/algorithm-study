package 백준;

import java.util.*;

public class Main {
	static int st;
	static int en;
	static int bad;
	static int[] arr;
	static int tc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = 0;
		while (true) {
            st = sc.nextInt();
            // 0입력되면 그대로 종료
            if (st == 0) break;
            en = sc.nextInt();
            bad = sc.nextInt();

            int cnt = 0;
            // arr에 미리 모든 수의 약수의 합을 밑에서 부터 담아 놓은다음
            // 그 수에 해당하는 수를 더해주면 약수의 합을 구할 수 있다.
            for (int i = st; i <= en; i++) {
            	// 다 구해 놓은다음에 st와 en사이의 구간에서 미리 구해둔 약수의 합을 이용해
            	// i에서 그값을 뺀 절댓값이 bad보다 적다면 +1해준다.
                if (Math.abs(i-arr[i]) <= bad)
                    cnt++;
            }
            
            System.out.println("Test "+tc+": "+cnt);
            tc++;
        }

		
	}

	
}
