import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 버퍼드리더 쓰기 싫었는데 스캐너에서 바꾸니깐 한 70퍼쯤에서 시간초과 뜨던게 안뜸 ㅡㅡ
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력끝

		// 여기서부터 이제 전체개수의 2를 나눈거를 왼쪽부터
		// 선택해서 최대공약수 구하는 거 시작
		System.out.println(dfs(arr));

	}
	// 왼쪽에서 gcd를 구하는데
	// 1. 1개면 그대로 출력
	// 2 2개면 두개
	public static int solve(int[] arr) {
		int a = arr[0];
		// 일단 0를 0으로 고정시켜놓고
		// 1번째부터 length까지 두개를 계속
		// 비교해가지고 최대공약수 구해야함
		for(int i =1;i<arr.length;i++) {
			a = change(a,arr[i]);
		}
		// 이과정 다 거치면 입력된 arr배열의 최대공약수가 a에 저장
		return a;
	}
	public static int change(int a, int b) {
		// a랑 arr[i]항 비교해서
		// arr[i]가 a로 나눈 나머지값으로 주고
		// 0이 될때까지 계속 나누는걸 a로 저장
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}

	public static int dfs(int[] arr) {
		// 일단 사이즈 1이면 그냥 0번째 항 반환
		if(arr.length==1) {
			return arr[0];
		}
		// 사실 2면 그냥 두개 더한거 출력해도됨
		else if (arr.length==2) {
			return arr[0] + arr[1];
		}
		else {
			// size를 기준으로 왼쪽과 오른쪽중 더 큰값이 리턴되는거를 구해야함 

			// 1. size를 기준으로 왼쪽은 gcd 구하고
			// 나머지 오른쪽은 또 다시 dfs 돌음

			// 2. size를 기준으로 오른쪽이 gcd구하고 
			// 나머지 왼쪽은 dfs돌아서 하기
			// 둘중 최대값 출력
			int size = arr.length/2;
			int[] a = Arrays.copyOfRange(arr, 0, size);
			int[] b = Arrays.copyOfRange(arr, size, arr.length);
			// 또 이걸기준으로 왼쪽항이랑 오른쪽항 각각한거에서 max값을 return
			return Math.max(solve(a) + dfs(b), solve(b) + dfs(a));
		}
	}


}
