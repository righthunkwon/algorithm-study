import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	// dp 같긴한데
		// 2 -> 2/2
		// 3 -> 3/4
		// 4 ->	4/6
		// 위에함은 +1씩
		// 밑에항은 +2씩
		double a = N;
		double b = 2*N -2;
		System.out.println(a/b);
		
		// 이거 왜 정답임? ㅋㅋ 
	}
}
