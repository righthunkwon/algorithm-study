package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_16974_레벨햄버거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		P_su = new long[N + 1];//N레벨까지 패티가 몇개 있는지 넣어놓는 배열
		all = new long[N + 1];//N레벨까지  햄버거가 몇장인지 넣어놓는 배열
		long X = Long.parseLong(st.nextToken());
		memoP(N);//P_su 배열 채우기 위한 메소드
		memoX(N);//all 배열 채우기 위한 메소드
		System.out.println(P_su(X, N));//N레벨 햄버거에서 아래에서부터 X개까지의 패티의 수
	}


	public static long[] P_su;// P수 넣는 배열
	public static long[] all;// 몇개 있는 지 총

	//패티는 B예전레벨P예전레벨B 이므로 예전레벨패티 *2+1
	public static long memoP(int N) {
		P_su[0] = 1;
		if (N > 0 && P_su[N] == 0) {
			P_su[N] = 2 * memoP(N - 1) + 1;
		}
		return P_su[N];
	}
	//총 수는 예전레벨수 *2+3
	public static long memoX(int N) {
		all[0] = 1;
		if (N > 0 && all[N] == 0) {
			all[N] = 2 * memoX(N - 1) + 3;
		}
		return all[N];
	}

	public static long P_su(long X, int N) {//들어온 값: X가 먹을 장수 N은 레벨
											//반환값: X장에 있는 패티의 수		
		                                    //모든 값(P수와 all수)이 절반을 기점으로 대칭이기 때문에 +1생각해주는 것이 중요하다

		if (X == 0) {//먹을 패티가 없다면 패티수 0 더하고 종료 
			return 0; 
		} 
		else if (X == all[N]) { // 빨리 반환하게 하려고 적은 조건
			return P_su[N];		//먹을 장수가 N레벨햄버거장수와 같다면 N레벨에 있는 패티값 반환 후 종료
		} 
		else if (all[N] / 2 + 1 < X) {//X(먹어야 하는 장수)가 햄버거의 반보다 크다면
					     //구해야 하는 패티에 현재 레벨의 P반+1 수 더해주고
	      				     //재귀호출 => 햄버거의 반은 X에서 빼주고 레벨 N-1버거로 다시 돌리기
			return P_su[N] / 2 + 1 + P_su(X - (all[N] / 2 + 1), N - 1);
		} 
		else if (all[N] / 2 + 1 > X) {//X(먹어야 하는 장수)가 햄버거의 반보다 작다면
			                            //레벨 N-1패티로 판단하고 제일 아래에 깔린 B한개를 빼주어야한다
			return P_su(X - 1, N - 1);
		} 
		else {// 햄버거 반이랑 같으면 N레벨의 P수 중 반
			return P_su[N] / 2 + 1;
		}
	}

}
