import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1722_순열의순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		int num = Integer.parseInt(str.nextToken());
		int arr[] = new int [N];
		
		// 주어진 수 그대로 체크하기 위해 크기를 21로 한다
		boolean[] visited = new boolean[21];
		// 순열을 구할 때 사용하기 위해 factorial배열 만들고 값을 저장한다
		long[] fac = new long[21];
		fac[0]=1;
		for(int i=1;i<21;i++) {
			fac[i]=fac[i-1]*i;
		}
		// 1일 때 k번 째 조합을 출력해야한다
		if(num==1) {
			int k = Integer.parseInt(str.nextToken());
			for(int i=0;i<N;i++) { // fac 범위
				for(int j=1;j<=N;j++) { // visited 범위
					// 이미 true이면 넘어간다
					if(visited[j]) continue;
					// fac[N-1]보다 k가 크단 의미는 
					if(fac[N-i-1]<k) {
						k -= fac[N-i-1];
					}else {
						arr[i]=j;
						visited[j]=true;
						break;
					}
				}
			}
			for(int i=0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
			
		}// num==1
		// 2일 때 몇 번 째 수열인지 출력해야 한다
		if(num==2) {
			// 임의의 순열을 입력받는다
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(str.nextToken());
			}
			long ans = 1; // 순서의 시작은 1부터 진행한다
			for(int i=0;i<N;i++) {
				for(int j=1;j<arr[i];j++) {
					//j가 해당하지 않는다면 그것보다 뒤에 있단 의미
					if(!visited[j]) {
						ans+=fac[N-i-1];
					}
				}
				// 순열에 존재하는 수는 true로 바꾼다
				visited[arr[i]]=true;
			}
			System.out.println(ans);
		}// num==2
	}//main

}
