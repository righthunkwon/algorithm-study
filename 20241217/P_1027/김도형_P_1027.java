import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[n];
		for(int i = 0; i<n ; i++)arr[i]=Integer.parseInt(st.nextToken()); //입력 끝
		int [] cnt = new int[n]; //각 빌딩 별 볼 수 있는 빌딩 수 저장
		//1번 빌딩부터 시작해서 자기 기준 오른쪽으로 볼 수 있는 빌딩이면 카운트해주고 해당 빌딩 역시 현재 빌딩을 볼 수 있으므로 +1 해줌
		//볼 수 있는지 여부는 기울기 계산을 통해 가장 최근에 볼수 있는 빌딩과 이었던 선분의 기울기보다 더 큰게 나오면 카운트하고 기울기 갱신		
		for(int i=0;i<n;i++) {
			double max_slope = -999999999.99; //기울기 최소값으로 초기화
			for(int j=i+1;j<n;j++) {
				double now_slope = (double)(arr[j]-arr[i])/(double)(j-i); //현재 건물과의 기울기
				if(now_slope>max_slope) {
					cnt[i]++;
					cnt[j]++;
					max_slope = now_slope;
				}
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++)ans = Math.max(ans, cnt[i]); //최대값 구하기
		System.out.println(ans);
	}//main
}
