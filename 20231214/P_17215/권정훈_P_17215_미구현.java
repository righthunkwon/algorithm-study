import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 볼링 점수 계산
public class P_17215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] carr = br.readLine().toCharArray();
		int[] score = new int[21]; // 점수 기록 배열

		int idx = 0;
		for (int i = 0; i < carr.length; i++) {
			if (carr[i] == 'S') { // 스트라이크일 경우
				score[idx++] = 10;
				score[idx++] = -1;
			} else if (carr[i] == 'P') { // 스페어일 경우
				score[idx] = 10 - score[idx - 1]; // 합 10점 맞춰준다
				idx++;
			} else if (carr[i] == '-') { // 못 쳤을 경우
				score[idx++] = 0;
			} else { // 해당하는 숫자만큼 쳤을 경우
				score[idx++] = carr[i] - '0';
			}
		}
		
		// 스트라이크를 연달아 기록한 다음 프레임에서 볼링 핀을 쓰러뜨렸을 떄의 점수는 3배
	}
}
