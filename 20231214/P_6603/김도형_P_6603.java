package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q6603_로또 {
	
	static int k; //각 테스트 케이스 별로 주어진 숫자 갯수
	static int []arr; //테스트 케이스에 주어진 숫자 저장할 배열
	static int []newArr; //선택된 6개 숫자 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0)break; //0이면 끝
			arr = new int[k];
			newArr = new int[6]; //6개 뽑은 수 저장할 배열
			for(int i = 0;i<k;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arr));
			dfs(0,0);
			System.out.println(""); //한줄 띄고
		}
	}
	
	private static void dfs(int depth,int idx) {
		
		//기저
		if(depth==6) { //6개 다 뽑았으면 출력
			for(int i=0;i<6;i++) {
				System.out.print(newArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//재귀
		if(idx<k) { 
		newArr[depth]=arr[idx];
		dfs(depth+1,idx+1); //arr의 해당 idx번째 숫자 선택한 경우
//		newArr[depth]=0; //초기화 -->> (어차피 덮어써지니까 필요 없긴함)
		dfs(depth,idx+1); //arr의 해당 idx번째 숫자 선택 안한경우
		}else return; //6개 아직 안뽑았는데 idx가 k가 되면 무효
		
	}
}
