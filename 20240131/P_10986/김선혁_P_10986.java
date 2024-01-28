import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		long[] arr = new long[N];
		long ans = 0;
		long[] sum = new long[M];
		// 범위보니깐 그대로하면 시간초과 뜰거같음
		// arr에 값을 입력받는 즉시
		// arr에는 전항까지의 합을 더해서
		// M으로 나눠
		// 나머지의 합을 넣어놓는다.
		// 나머지에 해당하는 sum 값만큼 ++해주고
		// 나머지가 0인것부터 그전항의 개수만큼을 곱해서 
		// 2로나눈것이 값 ( ?)
		 arr[0] = (sc.nextLong()%M);
	     sum[(int) arr[0]]++;
		for(int i = 1;i<N;i++) {
			int tmp = sc.nextInt();
			// 입력받고 나머지에 해당하는 부분만 
			// sum에 바로 더하고
			  arr[i]+=(arr[i-1]+tmp)%M;
	            sum[(int)arr[i]%M]++;
		}

        ans+=((sum[0]*(sum[0]+1))/2);
 
        for(int i=1; i<M; i++){
            ans+=(((sum[i]-1)*(sum[i]))/2);
        }
		
		System.out.println(ans);
		
		
	}
}
