
import java.io.*;
import java.util.StringTokenizer;

public class Pro_9082_지뢰찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			char[] text = new char[N];
			st = new StringTokenizer(br.readLine(), "");
			for (int i = 0; i < N; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
				text = br.readLine().toCharArray();
		}
		//3부터??? *부터???? 양쪽으로 ?????
		
		
		
		
		
		
		
	}
}
