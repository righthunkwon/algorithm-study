public class _20058_마법사상어와파이어스톰 {
	static int N, Q;
	static int[][] A;
	static int[] L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, N);
		A = new int[size][size];
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		// 입력끝
