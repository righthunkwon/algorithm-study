import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	
	static int K;
	static int[] arr;
	static int[] ans; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		//테스트 케이스 개수를 모르니깐
		// 다음 입력되는 숫자가 있는지 확인
		if(!sc.hasNextInt()) {
			break;
		}
		K = sc.nextInt(); 
		// K를 입력 받고 재귀를 통해서 
		// 6칸 크기의 배열에 수를 집어넣어
		// 6의 숫자가 완성되는 순간 
		// 그 숫자를 출력하고
		// 재귀를 종료 !
		arr = new int[K]; // 입력받을 배열
		for(int i =0;i<K;i++) {
			arr[i] = sc.nextInt();
		}
		// 먼저 K개의 숫자를 arr에 입력받음

		ans = new int[6]; // 정답 담을 배열 ans
		
			solve(0,0);
			System.out.println();
		}

	}
	public static void solve(int cnt, int idx) {
		// 6개를 모두 선정시 
		if(cnt == 6) {
			// 이제 출력을 해보자
			for(int i =0;i<ans.length;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
	

		for(int i =idx;i<K;i++) {
			// 선정
			ans[cnt] = arr[i];
			solve(cnt+1, i+1);			
		}

	}

}    
