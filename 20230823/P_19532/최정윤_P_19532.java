import java.io.*;
import java.util.StringTokenizer;

public class Problem_19532 {
	public static void main(String[] args) throws IOException {
		//처음 접근 a=0일 때로 접근했지만 ,, 
		//제한시간 1초 1999*1999하면 3996001로 충분하므로 가능!!
		//N이 10000개면 for문 2번 돌릴경우 (1만*1만=1억)1초 넘을 확률 큼 !! N이 1999개 이므로 가능
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		first: for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if (a * x + b * y == c && d * x + e * y == f) {
					System.out.println(x + " " + y);
					break first;
				}
			}
		}
		
//        int x = (c * e - b * f) / (a * e - b * d);
//        int y = (c * d - a * f) / (b * d - a * e);
//        System.out.println(x+" "+y);
		
	}
}
