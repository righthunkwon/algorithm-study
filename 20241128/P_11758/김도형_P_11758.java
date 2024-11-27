import java.io.*;
import java.util.*;

public class BOJ_Q11758_CCW {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());	
		int y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());	
		int y2 = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());	
		int y3 = Integer.parseInt(st.nextToken());	
		//CCW가 양수면 반시계 방향, 음수면 시계 방향, 0이면 일직선
		int CCW = (x2-x1)*(y3-y1)-(x3-x1)*(y2-y1);
		int ans = 0;
		ans = CCW>0?1:CCW==0?0:-1;
		System.out.println(ans);

	}

}
