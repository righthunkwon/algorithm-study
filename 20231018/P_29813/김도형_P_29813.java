package AlgoStudy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_Q29813_최애의_팀원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<String> stu = new LinkedList<>();
		Queue<Integer> num = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			stu.add(sc.next());
			num.add(sc.nextInt());
		}
		for (int i = 0; i < N/2; i++) {
			stu.poll();
			int a = num.poll();
			
			for(int j=0;j<a-1;j++) {
				String x = stu.poll();
				stu.add(x);
				int y = num.poll();
				num.add(y);
			}
			stu.poll();
			num.poll();
		}	
		String ans = stu.poll();
		System.out.println(ans);
	}
}
