import java.util.Scanner;

public class Pro_5904_Moo게임 {
	static int N;
	static int length;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 3
		// 3 + 4 + 3 10
		// 전꺼 + 5+ 전꺼 25
		// 전꺼 + 6+ 전꺼 56
		length = 3;
		dfs(4);
	}
	private static void dfs(int i) {
		int imsi = length;
		length += length + i;
		if (N == 1) { //처음 moo로 시작하는 것 
			System.out.println("m");
			System.exit(0);
		} else if (N == 2 || N == 3) {
			System.out.println("o");
			System.exit(0);
		}
		if (length > N) { //3 + 4+ 3 : leng=10,imsi=3,i=4
			if (N - imsi> i) { //다시 반복되는 상황이면 
				N = N-imsi - i; 
				length = 3;
				dfs(4);
			} else {
				if (N-imsi== 1) {
					System.out.println("m");
				} else {
					System.out.println("o");
				}
				System.exit(0);
			}
		} else { //아직 N까지의 길이가 X
			dfs(i + 1);
		}
	}
}
