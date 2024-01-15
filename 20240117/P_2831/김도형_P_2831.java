package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q2831_댄스_파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //
		int []men = new int[N];
		int []women = new int[N];
		st=new StringTokenizer(br.readLine());
		int minusmanNum = 0; //음수 남자 수(minusmanNum부터 남자 양수)
		for(int i =0;i<N;i++) {
			men[i]=Integer.parseInt(st.nextToken());
			if(men[i]<0)minusmanNum++;
		}
		st=new StringTokenizer(br.readLine());
		int minuswomanNum = 0; //음수 여자 수(minuswomanNum부터 여자 양수)
		for(int i =0;i<N;i++) {
			women[i]=Integer.parseInt(st.nextToken());
			if(women[i]<0)minuswomanNum++;
		}
		Arrays.sort(men);
		Arrays.sort(women); //오름차순 정렬
		
		int ans = 0; //정답 변수 초기화
		
		//조건 만족하려면 두 수 곱했을 때 음수고, 더했을 때도 음수면 된다..
		int menIdx = N-1;
		int womenIdx = 0;
		//여자가 큰 경우 (여자 음수, 남자 양수면서 배열 범위 내일 경우)
		while(menIdx>=minusmanNum&&womenIdx<minuswomanNum && womenIdx<N && menIdx>=0) { 
			if(men[menIdx]*women[womenIdx]<0 && men[menIdx]+women[womenIdx]<0) { 
				ans++;
				menIdx--;
				womenIdx++;
			}else {
				menIdx--;
			}
		}
		menIdx = 0;
		womenIdx = N-1;
		//남자가 큰 경우(여자 음수, 남자 양수면서 배열 범위 내일 경우)
		while(womenIdx>=minuswomanNum&&menIdx<minusmanNum&& menIdx<N && womenIdx>=0) { 
			if(men[menIdx]*women[womenIdx]<0 && men[menIdx]+women[womenIdx]<0) {
				ans++;
				womenIdx--;
				menIdx++;
			}else {
				womenIdx--;
			}
		}
		System.out.println(ans);
	}
}
