import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		int[] arr = new int[N+1];

//		for(int i = 0; i<N; i++) {
//			arr[i]=sc.nextInt();
//		}

		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= N; i++) {

			if (i != 0) {
				int b = 2;
				while (i * b <= N) {
					arr[i * b] = 0;
					b++;
				}
			}
		}

		for (int i = M; i <= N; i++) {

			if (arr[i] != 0) {
				System.out.println(i);
			}

		}

	}

}
