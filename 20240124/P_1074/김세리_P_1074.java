package _20240124;

import java.util.*;

public class _1074_Z {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		ans=0;
		z(N,r,c,0);
		System.out.println(ans);
		
		
	}//main
	static void z(int N, int r, int c, int cnt) {
		// N이 0보다 작아지면 더 작은 Z로 쪼갤 수 없으므로 해당 위치에서의 cnt를 ans에 넣는다
		if(N<0) {
			ans = cnt;
			return;
		}
		// 제일 큰 Z에서 왼쪽위/ 오른쪽위/ 왼쪽아래/ 오른쪽아래 중
		// 어디에 해당하는지 구하고 총 cnt에 그 위치에 따라 횟수를 추가한다
		
		// 그리고 한단계 작은 Z로 간 뒤 거기서의 r, c를 계산해서 갱신해둔다
		int size = (int)Math.pow(2, N-1);
		if(r<size && c<size) cnt +=0;
		else if(r<size && c>=size) {
			cnt += size*size;
			c = c-size;
		}
		else if(r>=size && c<size) {
			cnt += size*size*2;
			r = r-size;
		}
		else if(r>=size && c>=size) {
			cnt += size*size*3;
			r = r-size;
			c = c-size;
		}
		// 방금 한 Z보다 한단계 작은 Z로 넘어간다
		z(N-1, r, c, cnt);
	}
}
