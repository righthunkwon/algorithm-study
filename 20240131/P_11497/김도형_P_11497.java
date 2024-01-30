package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q11497_통나무_건너뛰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); //테스트케이스 개수
		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine()); //통나무 수
			st = new StringTokenizer(br.readLine()); 
			int [] arr = new int[N]; //통나무 높이 저장할 배열
			for(int i =0 ;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr); //오름차순 정렬
			int ans = 0; //정답 초기화
			int [] arr2 = new int[N]; //ㅅ모양으로 정렬 해서 저장할 배열
			int left = 0;
			int right = N-1;
			for(int i=0;i<N;i++) {
				if(i%2==0) { //짝수번째는 왼쪽에서 오른쪽으로 가면서 넣기
					arr2[left]=arr[i]; 
					left++;
				}else { //홀수번쨰는 오른쪽부터 왼쪽으로 가면서 넣기
					arr2[right]=arr[i];
					right--;
				}
			}
			for(int i=1;i<N;i++) {
				ans = Math.max(ans, Math.abs(arr2[i]-arr2[i-1])); //최대 높이 차이 갱신
			}
			ans = Math.max(ans, Math.abs(arr2[0]-arr2[N-1])); //처음과 끝 차이도 비교
			
			System.out.println(ans);
			
		}//for tc
	}
}
