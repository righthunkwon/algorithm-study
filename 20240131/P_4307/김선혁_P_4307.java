import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// 일단 최소부터
			// 최소는 개미의 위치에서 
			// 0과 N중 더 가까운 숫자의 값으로
			
			
			// 일단 개미의 위치 다 리스트에 추가
			ArrayList<Integer> ar = new ArrayList<>();
			int min = 0;
			int max = 0;
			for(int i=0;i<M;i++) {
				ar.add(sc.nextInt());
			}
			// 최소부터 
			// 막대까지 가까운 거리 중에
			// 최대값을 구해야 모두 다 떨어지는거임
			for(int i = 0;i<ar.size();i++) {
				// tmp에 현재 개미의 막대끝까지의 최소점을 구함
				int tmp = Math.min(ar.get(i), N-ar.get(i));
				min = Math.max(tmp, min);
			}
			
			// 최대값은 어렵게 생각해봤는데
			// 막 회전한다해도 더 가까운쪽때문에 상관x라
			// 그냥 먼거리 구해줌
			for(int i = 0;i<ar.size();i++) {
				int tmp = Math.max(ar.get(i), N-ar.get(i));
				max = Math.max(max, tmp);
			}
			
			System.out.println(min+" "+max);
			
			

		}
	}
}
