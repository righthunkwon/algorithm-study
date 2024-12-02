import java.io.*;
import java.util.*;

public class BOJ_Q13251_조약돌_꺼내기 {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []stones = new int[m];
		int t = 0; //전체 돌 갯수
		for(int i=0;i<m;i++) {
			stones[i]=Integer.parseInt(st.nextToken());
			t+=stones[i];
		}
		int k = Integer.parseInt(br.readLine());
		double mm = comb(k,t); //분모 -> 전체 돌 개수 중 k개를 뽑는 경우의 수
		double cc = 0; //분자 -> 각 색깔별로 k개 뽑는 경우의 수 모두 합치기
		for(int i=0;i<m;i++) {
			if(stones[i]<k)continue; // k보다 개수 적은 돌은 pass
			if(stones[i]==k) { //딱 k개면 경우의 수 1가지
				cc++;
				continue;
			}
			cc+=comb(k,stones[i]); //해당 색만 k개 뽑는 경우의 수 더하기
		}
		System.out.println(cc/mm);

	}//main
	
	// nCm (n개 중 m개 뽑는 경우의 수)
	static double comb(double n, double m) {
		
		n = Math.min(n, m-n);
		double a = 1;
		double b = 1;
		for(int i=0;i<n;i++) {
			a=a*(m-i);
			b=b*(i+1);
		}
		return a/b;
	}

}
