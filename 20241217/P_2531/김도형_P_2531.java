import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int [] arr = new int[N*2];
		for(int i=0;i<N;i++) { //원형으로 이어지도록 배열 2개 이어서 입력
			arr[i]=Integer.parseInt(br.readLine());
			arr[i+N]=arr[i];
		}
		
		int [] cnt = new int [d+1]; //투포인터로 움직이면서 해당 종류 초밥 개수 카운트용
		cnt[c]=1; //쿠폰으로 먹을 수 있는 초밥은 1개 일단 카운트
		
		int l = 0; //왼쪽 포인터
		int r = k; //오른쪽 포인터
		int tmp = 1; //현재 구간 초밥 가짓수 (쿠폰음식 미리 카운트해서 1로 초기화)
		
		for(int i=l;i<r;i++) {
			cnt[arr[i]]++;
			if(cnt[arr[i]]==1&&arr[i]!=c)tmp++; //일단 처음 투포인터 시작할 구간 초밥 가짓수 카운트
		}
		
		int max = 0; //최대 초밥 가짓수
    
		while(r<N+k) {
			cnt[arr[l]]--;
			if(cnt[arr[l]]==0&&arr[l]!=c)tmp--; //쿠폰음식이 아닌게 0개가 되면 tmp-1
			l++;
			cnt[arr[r]]++;
			if(cnt[arr[r]]==1&&arr[r]!=c)tmp++; //쿠폰음식이 아닌게 새로 추가되면 tmp+1
			r++;
			max=Math.max(max, tmp);
		}
		System.out.println(max);
	}
}
