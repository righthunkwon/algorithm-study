class Solution {
    static int max;
    static int[][] dp;
    static String[] arr;
    public int solution(String arr[]) {
        // 최댓값이 나오려면
        // 하나의 그룹에서 최대한 높은 값을 나오게 만들어야함
        // -> 빼기가 나오면 뒤에는 최소가 나와야함
        int n = arr.length;
        this.arr= arr;
		dp = new int[n][n];
		// 우선 dp 배열에 arr의 숫자부분만 넣음
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
			if (i % 2 == 0) {
				dp[i][i] = Integer.parseInt(arr[i]);
			}
		}
        // 이제 dfs를 통해 하나씩 최댓값이 나오도록 계산해보자
        // 방식은 이제 시작부터 끝까지 그안에 있는 서브연산들이
        // 각각 최대값이 나오도록 유도
        max = solve(0,n-1);
        return max;
    }
    public static int solve(int i, int j){
        // i~j까지 우선 값이 갱신되어있으면 그대로 return
		if (dp[i][j] != Integer.MIN_VALUE) {
			return dp[i][j];
		}
        // 우선 양수인체로 -가 나오게 되면 
        // 해당 뒷부분은 최소가 나오도록 만듬
		if (i - 1 >= 1 && arr[i - 1].equals("-")) {
			int sum = Integer.MAX_VALUE;
			for (int k = i; k < j; k += 2) {
                // 각 숫자들이 세부 연산들을 나눠서
                // 안에있는 숫자들이 최소가 나오도록 유도
				int tmp = calculate(solve(i, k), arr[k + 1], solve(k + 2, j));
				sum = Math.min(tmp, tmp);
			}
			dp[i][j] = sum;
		} else { 
            // 이부분은 +로
            // 뒷부분이 최대가 되도록 만들음
			int sum = Integer.MIN_VALUE;
			for (int k = i; k < j; k += 2) {
                // 여기는 -와 반대로 세부 연산들이 최대값이 나올때마다 갱신
				int tmp = calculate(solve(i, k), arr[k + 1], solve(k + 2, j));
				sum = Math.max(sum, tmp);
			}
			dp[i][j] = sum;
		}
		return dp[i][j];
	}

	public static int calculate(int a, String op, int b) {
		if (op.equals("-")) {
			return a - b;
		}
		if (op.equals("+")) {
			return a + b;
		}
		return 0;
	}
}
