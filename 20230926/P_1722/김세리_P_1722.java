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
			long k = Long.parseLong(str.nextToken());
			
			for(int i=0;i<N;i++) { // arr 범위
				for(int j=1;j<=N;j++) { // visited 범위
					// 이미 true이면 넘어간다
					if(visited[j]) continue;
					// fac[N-i-1]보다 k가 크단 의미는 일단 그것보다 더 뒤에쪽에 있는 수열이라는 의미
					// k에서 그 팩토리얼 값 만큼 빼준다
					if(fac[N-(i+1)]<k) { // factorial 범위는 i+1을 해줘야 원하는 값을 구할 수 있다
						k -= fac[N-i-1];
					}else { 
						// fac[N-i-1]>=k 이란 소리는 j값이 수열에 있단 의미
						// 따라서 답으로 출력할 arr의 i번째 자리의 값이 j란 의미와 같다
						// 그러므로 arr배열에도 입력하고 visited[j]도 true로 바꾸고
						// 해당 i번째 값은 정해졌으므로 더 돌지 않고 다음 i번째 값으로 넘어간다
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
			for(int i=0;i<N;i++) { // arr 범위
				for(int j=1;j<arr[i];j++) { //visited 범위
					// visited[j]가 false란 소리는 그것보다 뒤에 있단 의미
					// 따라서 ans값에 그 factorial 값 만큼을 더해준다
					// visited[j]가 true일 때까지 돌면서 값을 더한다
					if(!visited[j]) {
						ans += fac[N-(i+1)];
					}
				}
				// 순열에 존재하는 수는 true로 바꾼다
				// 그리고 true로 바뀐 값은 위에서 이제 더이상 더하지 않는다
				visited[arr[i]]=true;
			}
			System.out.println(ans);
		}// num==2
	}//main

}
