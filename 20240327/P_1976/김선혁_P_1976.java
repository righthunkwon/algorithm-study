import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int parent[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 모두 입력받은 다음
		// 연결되 있는 숫자들은 가장 작은 숫자를 저장해놓음
		
		// 진행할 순서대로 모든 숫자의 부모가 같으면 O
		// 아니면 x
		arr = new int[N+1][N+1];
		parent = new int[N+1];
		for(int i = 1;i<=N;i++) {
			parent[i] = i;
		}
		for(int i=1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				// 입력받는 숫자가 1이면 두개 연결되있다는 뜻
				if(sc.nextInt() == 1) {
					if(parent[i]>parent[j]) {
						// j가 작으면 j의 부모쪽으로 값 이동
						// 반례때문에 이줄 넣은건데 좀 이상함
						parent[parent[i]] = parent[j];
						parent[i] = parent[j];
					}
					else {
						parent[parent[j]] = parent[i];
						parent[j] = parent[i];
					}
				}
			}
		}
		// 이과정 거치면 부모설정 완료
		// 다음입력값의 부모에 해당하는 값을 정해놓고
		// 다른값이 나오면 NO출력
	
		int ans = parent[sc.nextInt()];
		for(int i = 1;i<M;i++) {
			if(parent[sc.nextInt()] != ans) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
		

	}

}
