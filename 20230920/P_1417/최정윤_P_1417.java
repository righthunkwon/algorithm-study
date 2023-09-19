package baek;
import java.io.*;
import java.util.Arrays;

public class Pro_1417_선거 {
	static int[] diff;//다솜이와 표차이 넣는 배열 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		diff = new int[N - 1];// 다솜이 기호 빼고 다솜이랑의 표차이넣는 배열
		int dasom = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			diff[i] = Integer.parseInt(br.readLine()) - dasom;
		}
		while (!isfirst()) {//다솜이가 1등인지 
			Arrays.sort(diff);//차이 가장 많이 나는 사람 표부터 뺏어야함
			for (int i = diff.length - 1; i >= 0; i--) {
				if (diff[i] >= 0) {//표수가 다솜이랑 같거나 다솜이보다 많을 경우만
					result++;//뺏고
					diff[i] = diff[i] - 1;//뺏은 사람은 다솜이랑 표수가 2표 차이나기 때문에 한개 미리 빼줌
					minusAll();//나머지 차이 -1
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
