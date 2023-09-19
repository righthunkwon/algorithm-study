import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] diff;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		diff = new int[N - 1];// 다솜이 기호 빼고 다솜이랑의 표차이넣는 배열
		int dasom = Integer.parseInt(br.readLine());
		result = 0;
		for (int i = 0; i < N - 1; i++) {
			diff[i] = Integer.parseInt(br.readLine()) - dasom;
		}
		while (!isfirst()) {
			Arrays.sort(diff);
			for (int i = diff.length - 1; i >= 0; i--) {
				if (diff[i] >= 0) {
					result++;
					diff[i] = diff[i] - 1;
					minusAll();
					break;
				}
			}
		}

		System.out.println(result);
	}

	public static void minusAll() {
		for (int i = 0; i < diff.length; i++) {
			diff[i] = diff[i] - 1;
		}
	}

	public static boolean isfirst() {
		for (int i = 0; i < diff.length; i++) {
			if (diff[i] >= 0) {
				return false;
			}
		}
		return true;
	}
}
