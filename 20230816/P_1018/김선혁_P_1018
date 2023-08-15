import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();			
		for(int t=1;t<=T;t++) {
		int	N = sc.nextInt();
		int[][] rank = new int[N][2];
		for(int i=0;i<N;i++) {
			rank[i][0] = sc.nextInt();
			rank[i][1] = sc.nextInt();
		}
			
		Arrays.sort(rank, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}			
		});
		// 정렬완료
		for(int i =0;i<N;i++) {
			System.out.print(rank[i][0]+" ");
			System.out.println(rank[i][1]);
		}
		
		
		
		}
		
	}
}
