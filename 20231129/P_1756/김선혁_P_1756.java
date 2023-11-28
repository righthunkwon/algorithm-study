import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	static int[] arr;
	static int[] bread;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		//		bread = new int[M];

		// 그냥 하나하나하면 시간초과가 뜨는데 
		// 어차피 뒤의 반죽은 크던작던 그전에 반죽 숫자보다 커도 필요가 없음
		// 전반죽이 작으면 못지나가기때문
		
		int max = Integer.MAX_VALUE;
		for(int i =1;i<=N;i++) {
			arr[i] = sc.nextInt();
			// 현재 i번째값이 그 전에값보다 크면 어차피 의미없어서 그전에값으로 입력
			arr[i] = Math.min(arr[i], max); // 자꾸 arr[i-1]을 넣으면 arrayindex뜸
			max = arr[i];
		}
		// ex1) 5 5 4 3 3 2 2로 만들어짐		
		// 입력끝
		
		// 반죽크기는 입력받는 즉시 그대로 위치 찾을거임
		// 이문제는 일단 반죽을 순서대로 하나씩 골라서
		// 그 반죽이 걸쳐지는 곳까지 찾아가고
		// 그 다음 반죽은 처음부터 가다가 막히는곳 
		// 또는 전반죽이 있던 곳까지 진행하고
		// 들어가지 못한다면 0출력

		int dep = N; // N-1번째의 깊이부터 시작
		a : for(int i=0;i<M;i++) {
			// 일단 반죽하나 선택
			// while문을 통해서
			// dep의 위치를 하나씩 빼가면서 현재 i번째 반죽의 위치를
			// 정할거임
			int tmp = sc.nextInt(); // tmp는 현재 반죽의 값
			while(true) {
				if(arr[dep] < tmp) { // 현재위치에는 부적절하다는 의미
					dep --;	// 현재 반죽의크기가 오븐에 들어갈 수 있을떄까지	
				} // 깊이를 계속 -- 해주고 
				else {
					// 만약 들어갈 수 있으면 break해서 다음 반죽으로
//					System.out.println(dep);
					dep --;
					break;
				}
				if(dep <0) {
					break a;
				}
			}
		}
		System.out.println(dep+1);


	}


}
