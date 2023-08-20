package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2212_센서 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 센서의 개수 (1 <= N <= 10,000)
		int K = Integer.parseInt(br.readLine()); // 집중국의 개수 (1 <= K <= 1,000)
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // 센서들 좌표 담아둘 배열
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 입력 완료
		// 센서들 좌표를 오름차순으로 정렬하자.
		Arrays.sort(arr);
		
		// 오름차순으로 정렬된 센서 좌표들의 각 차이의 합이
		// 1개의 집중국이 커버할 수 있는 수신 가능 영역이니까..
		// 테스트케이스 1번 센서 좌표의 예에서 집중국 K = 1이라면
		// 각 차이의 합인 8이 최소 수신 가능 영역이고
		// 1번 테스트케이스에서는 K = 2 이니까
		// 차이가 가장 큰 3을 패스할 수 있다(빼준다!)
		// 만약 K = 3 이라면 차이가 두번째로 큰 2를 패스할 수 있다
		// 차이도 오름차순으로 정렬 후 뒤에서 K - 1 만큼의 인덱스를 빼고 더하면 답이다
		
		int[] mArr = new int[N-1]; // 좌표의 차이를 담아둘 배열
		for(int i = 0; i < N - 1; i++) {
			mArr[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(mArr); // 정렬해서 큰 거(뒤에서부터) K - 1 번은 빼고 더하자
		
		int res = 0;
		for(int i = 0; i < mArr.length - (K - 1); i++) {
			res += mArr[i];
		}
		System.out.println(res);
	}
}
