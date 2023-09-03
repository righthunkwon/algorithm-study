import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] arr;
	static boolean[] flag;
public static void main(String[] args) {
	// 일단 깊이 입력받고
	// 만약 깊이가 3이면
	// 3 2 3 1 3 2 3
	// 4이면
	// 4 3 4 /2 /4 3 4  // 1 // 4 3 4 2 4 3 4 
	// 절반 절반 절반 일때 1 - 2 - 3 , 3 이렇게 진행 나머진 4에다 넣음
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt();
	arr = new ArrayList[N+1]; // (1)층부터 밑으로 0번째에는 숫자 다 담아놓음
	for(int i =0;i<=N;i++) {
		arr[i] = new ArrayList<Integer>(); // 각 배열마다 선언
	}
	
	
	while(sc.hasNextInt()) {
		 // 다음 입력이 있다면 계속 입력 
			arr[0].add(sc.nextInt());					
	}
	
	
	flag = new boolean[arr[0].size()]; // arr[0]번째 있는 모든수에 대해서 boolean
	solve(0,arr[0].size()-1,1);
	
	
	for(int i =1;i<=N;i++) {
		for(int j = 0;j<arr[i].size();j++) {
			System.out.print(arr[i].get(j)+" "); // 한줄 출력하고 줄바꿈
		}
		System.out.println();
	}
	
	
}
	public static void solve(int left, int right, int depth) {
		if(depth == N+1) {
			return;
		}
		int mid = (left+right)/2;
		arr[depth].add(arr[0].get(mid)); // 가운데 있는 수를 arr의 depth에 넣어버림
		solve(left, mid-1,depth+1);
		solve(mid+1,right,depth+1);
		
	}
	


}
