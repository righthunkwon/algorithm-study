import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] wantArr = new int[N];
		int[] rightArr = new int[N];
		for (int i = 0; i < N; i++) {
			wantArr[i] = Integer.parseInt(bf.readLine());
			rightArr[i] = i + 1;
		}
		Arrays.sort(wantArr);
		long sum=0;
		for(int i=0;i<N;i++) {
			sum+=Math.abs(wantArr[i]-rightArr[i]);
		}
		System.out.println(sum);
	}
}
