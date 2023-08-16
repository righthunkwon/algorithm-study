import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_2012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] wantArr = new int[N];// 예상등수 배열
		for (int i = 0; i < N; i++) {
			wantArr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(wantArr);// sort빠르게 하기 위해서는 list사용해도 가능
		// sort 해야 최솟값이 나옴
		long sum = 0; // N은 500000까지이고 모두가 500000이라고 예상등수를 적었을 때 int 범위 초과
		// 250000000000으로 21억을 넘긴다. long으로 세팅
		for (int i = 0; i < N; i++) {
			sum += Math.abs(wantArr[i] - (i + 1));
		}
		System.out.println(sum);
	}
}
