package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q13164_행복_유치원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //원생 수
		int K = Integer.parseInt(st.nextToken()); //K개의 조
		int [] arr = new int[N]; //원생 키 배열
		int [] cha = new int[N]; //바로 앞 사람과 차이 배열
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i>0) {
				cha[i]=arr[i]-arr[i-1];
			}
		}
		int total = 0; //티셔츠 만드는 최소비용
		//cha배열에서 큰거 K-1개 빼고 다 더해주면 답
		Arrays.sort(cha);
		for(int i=0;i<N-K+1;i++) {
			total+=cha[i];
		}
		System.out.println(total);
	}//main
}//class
