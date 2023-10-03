import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int[][] guitar = new int[M][2]; // 기타줄의 세트가격과 개별가격을 guitar에 입력받는다
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			guitar[i][0]= Integer.parseInt(st.nextToken());
			guitar[i][1]= Integer.parseInt(st.nextToken());
		}
		// 세트가격 최소, 개별가격 최소 를 각각 setmin, indmin으로 구한다
		int setmin=10000;
		int indmin=10000;
		
		for(int i=0;i<M;i++) {
			if(guitar[i][0] < setmin) setmin = guitar[i][0];
			if(guitar[i][1] < indmin) indmin = guitar[i][1];
		}
		// 구입하고자 하는 줄의 수가 6개 미만일 때와 그 이상일 때로 구분하여 구한다
		int ans=0;
		
		// 6개 미만일 때 : 세트 하나 구입 가격과 개별 가격으로 N개 구입할때 비용 중 작은 방식으로 구입한다
		if(N<6)	ans = Math.min(setmin, indmin*N);
		
		else {
		// 6개 이상일 때 : 세트로 모두 구입할 때(N보다 많이 구입), 세트로 구입하고 남은 것은 개별가격으로 구입,
		// 전부 개별가격으로 구입 3가지 경우로 나누어 계산하고 그 중 가장 비용이 작은 방식으로 구입한다
			ans = Math.min(setmin*((N/6)+1), setmin*(N/6)+indmin*(N%6));
			ans = Math.min(ans, indmin*N);
		}
		System.out.println(ans);
		
	}//main

}
