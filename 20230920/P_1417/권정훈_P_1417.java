import java.util.Scanner;

// 국회의원 선거
public class P_1417 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 후보의 수 
		int[] arr = new int[n]; // 후보의 배열
		
		// 후보의 배열 요소 입력
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int bribee = 0; // 매수인
		boolean flag = true; // 조건변수
		while(flag) {
			
			// 후보들 중 최대 득표인 구하기
			int max = 0;
			for (int i = 1; i < n; i++) {
				max = Math.max(max, arr[i]);
			}
			
			// 다솜이의 득표 수가 최대 득표 수보다 작거나 같을 경우
			// 다솜이의 득표 수가 더 많아야 하므로 다솜이의 득표 수와 매수인을 증가시키고
			// 후보 배열에서 다솜이를 제외한 후보의 득표수를 하나 줄이고 다음 경우의 수로 진행한다.
			if (arr[0] <= max) {
				arr[0]++;
				bribee++;
				for (int i = 1; i < n; i++) {
					if (arr[i] == max) {
						arr[i]--;
						break;
					}
				}
			} 
			
			// 만약 다솜이의 득표 수가 다른 득표수보다 크다면 반복문을 종료한다.
			else {
				flag = false;
			}
		}
		
		// 정답 출력
		System.out.println(bribee);
	}
}
