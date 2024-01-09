package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q27172_수_나누기_게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//카드 숫자들 중복 x
		//입력된 순서대로 점수를 출력해야됨.. 정렬 x -> 숫자 뽑힘여부와 각 숫자별 점수를 관리하자
		boolean[]chosen=new boolean[1000001]; //뽑혔는지 확인용
		int[]score=new int[1000001]; //숫자별 점수 기록용
		
		for(int i =0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			chosen[arr[i]]=true; //뽑힘
		}//입력끝
//		System.out.println(Arrays.toString(arr));
		for(int i : arr) {
			for(int j=i*2;j<1000001;j+=i) { //해당 숫자의 배수들을 돌면서 점수 갱신
				if(chosen[j]) {//i의 배수인 j들은 i로 나누어떨어지므로
					score[i]++; 
					score[j]--;
				}
			}
		}
		for(int i : arr) {
			System.out.print(score[i]+" ");
		}
	}//main
}//class
