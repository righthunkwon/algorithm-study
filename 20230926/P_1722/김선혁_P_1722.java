import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static long[] flag;
	static boolean[] check;
	static int ans;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt();
		K = sc.nextInt();
		flag = new long[21];
		check = new boolean[21];
		flag[0] = 1; // 전체 개수가 몇개인지
		// 다 곱해서 일단 구하기
		for(int i =1;i<21;i++) {
			flag[i] = flag[i-1] * i;
		}
		// 개수 입력 완료
		long ans =0;
		int idx = 0;
		if(K==1) {
			int[] arr = new int[N];
			// 일단 현재 입력되는 값이
			// 밑에를 반대로 해서 생각해보자
			long a = sc.nextLong(); // 숫자 먼저 받자	
			while(true) {
				// 먼저 a는 순열에서 몇번째 있는 수인지 나타난 것이기 때문에
				// a가 음수가 바로 되기직전까지의 숫자를 구한다 -> tmp
				// 음수가 되는순간 break 
				int tmp = 0;
				while(true) {
					if(a- flag[N-1-idx]*tmp>0) {
						tmp++;
					}
					else {
						break;
					}
				}
				// 순서인 a에서 앞자리를 먼저 선택하기 위해서
				// a를 tmp 개수에서 1뺀값만큼의 (N-1)!를 빼자
				// ex) tmp가 5이면 , 첫번쨰 자리를 선택하는 것이라면 6이 첫번쨰 자리 와야하고
				// 5* N-1-idx만큼의 팩토리얼 값을 뺴고
				// 그 숫자를 true로 바꾸고
				// idx는 ++;
				
				a-=flag[N-1-idx]*(tmp-1);
				int count =0;
				for(int i=1;i<=N;i++) {
					if(!check[i]) {
						count++;
					}
					// 다음 두번째 자리부터는 true인 값이 있으면 건너뛰고 숫자를 세어야한다.
					if(count==tmp) {		
						check[i] = true;
						arr[idx] = i;
						idx++;
						break;
					}
				}			
				// idx가 N이 되면 숫자 선정이 끝난것이므로
				// break
				if(idx == N) {
					break;
				}
			}
			for(int i =0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
		}
		else {
			int[] arr = new int[N];
			for(int i =0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			// 배열 입력 완료
			// 이제 배열따라서 첫번째부터 몇개째인지 분석 
			while(true) {
				// 만약 먼저나온 숫자가 앞인지 뒤인지 따라
				// 2번째 숫자부터는 결과가 달라지므로 
				// 먼저 20까지의 숫자중에서 나온숫자는
				// true처리하고
				// 앞에 숫자의 개수를 센다.
				int tmp= 0;
				for(int i=1;i<21;i++) {
					if(!check[i] && i<arr[idx]) {
						//						System.out.println(i+" !");
						tmp++;
					}
				}
				// 만약 idx가 7일 경우
				// 6번까지의 개수에 팩토리얼을 곱한것을 ans에 더함
				// tmp는 앞의 숫자의 개수
				ans+= flag[N-1-idx]*tmp;
				//				System.out.println(flag[N-1-idx]*tmp);
				check[arr[idx]] = true;
				idx++;			
				if(idx==N) {
					break;
				}
			}
			ans ++; // 처음일경우 0으로 위치가 반환되는거기 때문에 +1;
			System.out.println(ans);
		}

	}

}
