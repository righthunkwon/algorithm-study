package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904_Moo게임 {
	/*  
		수열의 길이는
		S(0) = 3, S(1) = 3 + 1+3 + 3 = 10, S(2) = 10 + 2+3 + 10 = 25
		S(X) = S(X-1) * 2 + X+3
		S(X+1) = S(X) * 2 + X+4
		N에 해당하는 X를 찾아서 
		왼쪽부분:0 ~ S(X-1), 가운데부분:S(X-1) ~ S(X-1)+X+3, 오른쪽부분:S(X-1)+X+3 ~ S(X-1)*2+X+3 인지 계속 판별 
	*/
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int x = 0;
		int len = 3; // x 일때 길이
		int tmp = 0; // x-1 일때 길이
		// moo의 길이를 구하자
		while(N > len) {
			tmp = len;
			len = len * 2 + x + 4;
			x++;
		}
//		System.out.println(len);
//		System.out.println(tmp);
		
		while(true) {
			// 가운데 부분
			if(tmp < N && N <= tmp+x+3) {
				N -= tmp;
				break;
			}		
			// 왼쪽부분
			if(N <= tmp) {
				len = tmp;
				x--;
				tmp = (len-(x+3))/2;
			// 오른쪽부분
			}else {
				len = tmp;
				N -= tmp + x + 3;
				x--;
				tmp = (len-(x+3))/2;
			}
		}
		System.out.println(N==1?'m':'o');
		
		
	}
}
