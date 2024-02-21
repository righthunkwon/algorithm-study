import java.io.*;
import java.util.*;

public class pro {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] now = new int[N];
		int[] diff = new int[N]; //차이 배열

		for (int i = 0; i < N; i++) {
			now[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(st.nextToken()) - now[i];
		}

		// 양수면 tab을 해야하고 음수면 삭제
		// 0 이면 추가 삭제 불가
		// 양수끼리의 그룹 , 음수끼리의 그룹 찾기 어치피 음수 양수 다르면 한번 더 해야함
		int result = 0;
		for (int i = 0; i < N; i++) {  
			if (diff[i] > 0) { //양수면 뒤부터 같은 양수 찾고 거기 다 한개씩 --
				int j;
				for (j = 1; i + j < N; j++) {
					if (diff[i+j] > 0) continue;
					else break;
				}
				for (int k = i; k < i + j; k++) {diff[k]--;}
				result++;
				i--;
			} else if (diff[i] < 0) {
				int j;
				for (j = 1; i + j < N; j++) {
					if (diff[i+j] < 0) continue;
					else break;
				}
				for (int k = i; k < i + j; k++) {diff[k]++;}
				result++;
				i--;
			}
		}
		System.out.println(result);

	}
}
