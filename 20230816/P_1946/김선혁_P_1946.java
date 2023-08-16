import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();			
		for(int t=1;t<=T;t++) {
		int	N = sc.nextInt();
//		int[][] rank = new int[N][2];
//		for(int i=0;i<N;i++) {
//			rank[i][0] = sc.nextInt();
//			rank[i][1] = sc.nextInt();
//		}
//			
//		Arrays.sort(rank, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				return o1[0] - o2[0];
//			}			
//		});
//		// 정렬완료
////		for(int i =0;i<N;i++) {
////			System.out.print(rank[i][0]+" ");
////			System.out.println(rank[i][1]);
////		}
//		
//		// 정렬완료했으니 1번을 기준으로 개수 짜름
//		int cnt= 1; //최종 사원수
//		int index=0; // 시작 index =0
//		int min = rank[index][1]; // 2번째 값이 5라면 일단 5개로축소		
//		while(true) {			
//			index++;
//			if(min>rank[index][1]) {				
//				min = rank[index][1];
//				cnt++;
//			}
//			if(rank[index][1]==2) {
//				cnt++;
//				break;
//			}
//			
//		}
//		System.out.println(cnt);
		
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			int a = sc.nextInt();
			int b =sc.nextInt();
			arr[a] = b;
		}
//		System.out.println(Arrays.toString(arr));
		
		int cnt=0;
		int min = arr[1];		
		for(int i=1;i<=N;i++) {
			if(min>=arr[i]) {
				cnt++;
				min = arr[i];
			}
			if(arr[i]==2) {
				cnt++;
				break;
			}
			if(arr[i] ==1) {
				break;
			}
			
		}
		System.out.println(cnt);
		
		
		
		
		}
		
	}
}
