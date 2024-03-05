import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[N];
		int[] frequency = new int[N + 1];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			frequency[card[i]]++; // 숫자 등장 빈도수 체크
		} // 입력 끝

		//모든 경우의 수 2^n-1 가지 (하나도 안뽑는 경우는 없으므로)
		//결국 구해야 하는건 겹치지않게 뽑는 조합의 경우의 수
		
		long answer = 1;
		for (int count : frequency) {
			if (count > 0) {
				// 1번 나왔으면 뽑거나,안뽑거나 2가지 경우.. 
				// 2번 나왔으면 먼저나온놈 뽑거나,뒤에나온놈 뽑거나, 안뽑거나 3가지 경우..
				// 따라서 나온 빈도수 + 1 만큼을 곱해준다! 
				answer *= count + 1;  
				answer %= 1000000007;// 10^9 + 7
			}
		}
		//아무것도 안뽑은 경우인 1을 빼줌
		answer = (answer - 1 + 1000000007) % 1000000007; // 결과를 조정

		System.out.println(answer);

	}// main
}// class
