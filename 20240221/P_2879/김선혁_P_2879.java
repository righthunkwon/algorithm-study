import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// 숫자는 그대로 입력받는데로 -해버린다
		for(int i=0;i<N;i++) {
			arr[i] = arr[i] - sc.nextInt();
		}
		// 입력끝
		int ans = 0;
		for(int i =0;i<N;i++) {
			boolean flag = false;
			if(arr[i]>0) flag = true;
			int tmp = Math.abs(arr[i]);
			for(int j = i;j<N;j++) {
				// 두개가 같은 방향이면
				// j는 계속 늘어남
				// 만약 j가 N-1까지 간경우는 밑으로 내려가서 변화시작
				if((flag && arr[j]>0) || (!flag && arr[j]<0)) {
					tmp = Math.min(tmp, Math.abs(arr[j]));
					if(j != N-1) {
						continue;
					}
					j++;
				}
				// 현재 tmp만큼 ans에 더하고
				// 최소 올라갈 만큼
				// i ~ j 까지 쭉 더하고 만약 arr이 0이아니면
				// 다시 arr부터 시행해야하므로 i --하고 break
				ans += tmp;
				if(flag) tmp*=-1;
				for(int idx=i;idx<j;idx++) {
					arr[idx] +=tmp;
				}
				if(arr[i]!=0) i--;
				break;
			}
		}
		System.out.println(ans);

	}
}
