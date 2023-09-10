import java.util.Scanner;

public class Main {
	
	
public static void main(String[] args) {	
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt();
	int[][] arr = new int[101][101];
	int cnt =0;
	
	for(int T = 1;T<=N;T++) { // N번반복
		int tmpx = sc.nextInt(); // x좌표 입력
		int tmpy = sc.nextInt(); // y좌표 입력
    
		for(int i =tmpx;i<=tmpx+9;i++) { // 입력된 좌표 +9까지
			for(int j =tmpy;j<=tmpy+9;j++) {
				if(i<=100 && j<=100 && arr[i][j] ==0) { // 100을 넘어가기 전까지만 count
					arr[i][j] = 1; // 1로바꿔주어 다시 그지점은 count 하지 않도록 한다.
					cnt++;
				}
			} // J
		} //  I
		
	} // T
	
	System.out.println(cnt);
	
}


}
