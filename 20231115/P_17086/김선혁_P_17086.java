import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<Integer> ax;
	static ArrayList<Integer> ay;
	static int ans;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		arr = new int[N][M];
		ax = new ArrayList<>();
		ay = new ArrayList<>();
		for(int i = 0;i<N;i++) {
			for(int j =0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1) {
					ax.add(i);
					ay.add(j);
				}
			}
		}
		// 입력끝
		// 아기상어의 좌표는 리스트에 담아놨음
		// 이제 리스트에서 가장 가까운 거리에 있는 아기상어의 위치를 구하자
		ans = 0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]==0) {
					sum = 987654321;
					solve(i,j);		
					// 이 좌표를 통해 해당 지점에서의
					// 가장 가까운 지점의 좌표를 구하고
					// 그 중에서 가장 큰 값을 구함
					ans = Math.max(sum, ans);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void solve(int x,int y) {
		for(int i =0;i<ax.size();i++) {
			int tmp = Math.max(Math.abs(x-ax.get(i)),Math.abs(y-ay.get(i)));
			// 두좌표중에 큰값의 차이 구함
			sum = Math.min(tmp, sum);
			// 여러가지 길이 중 가장 짧은 값의 거리를 구함
		}
		return;
	}
		
	
}
