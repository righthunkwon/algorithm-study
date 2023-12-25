import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 일단 주사위에서 위 아래를 제외한 
		// 4개의 면에서 각각 최대값을 구하면됨
		// 당연히 위아래에 올 수 있는 숫자는 6개 모두 가능
		
		// 일단 아래층 하나를 고정하면 
		// 나머지 위층 한면은 고정됨
		arr = new int[N][6];
		for(int i =0;i<N;i++) {
			for(int j =0;j<6;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력 끝
		
		int ans = 0;
		int sum= 0;
		// 이제 6개의 면중 아래면을 하나 고정하고
		// 6면중에서 윗면을 먼저 찾고
		// 나머지 4개의 면중에서 최대값을 찾자.
		// 먼저 1면을 고정
		for(int i =0;i<6;i++) {
			int bot = arr[0][i]; // 아랫면을 먼저 해버림
			int top = arr[0][find(i)];
			// 윗면 찾고 첫번째 주사위부터 
			// 윗면의 값에 해당하는 것을 찾고 
			// 1. 윗면과 아랫면 값 교환
			// 2. 4개의 면중에 최대값 sum에다가 더함
			for(int j=0;j<N;j++) {
				for(int k =0;k<6;k++) {
					// 윗면에 해당하는 값을 먼저 찾으면
					// 다음 주사위를 위해 값 교환해주고 
					// 나머지 값중 최대값 sum에 더함
					if(arr[j][k] == top) {
						bot = top;
						top = arr[j][find(k)];
						sum += solve(top, bot);
//						System.out.println(sum);
						break;
					}
				}
			}
			// 하나를 기준으로 다 끝나면 
			// ans값 최대로 갱신하고 sum 초기화
			ans = Integer.max(ans, sum);
			sum = 0;
		}
		
		System.out.println(ans);
		
		
	}
	// i가 들어오면 i에 해당하는 반대면을 찾아줌
	public static int find(int i) {
		if(i==0) {
			return 5;
		}
		else if(i==1) {
			return 3;
		}
		else if(i==2) {
			return 4;
		}
		else if(i==3) {
			return 1;
		}
		else if(i==4) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	public static int solve(int a,int b) {
		for(int i =6;i>0;i--) {
			if(i==a || i == b) {
				continue;
			}
			return i;
		}
		return 0;
	}

}

