package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//완전 이진 트리이지만 문제 조건상 포화이진트리  mid값 구하기 쉬움 
public class Pro_9934_완전이진트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		arr = new int[((int) Math.pow(2, K)) - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//입력끝
		
		for(int i=0;i<=K;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		level(K, ((int) Math.pow(2, K) - 1) / 2);
		//출력시작
		for(int i=list.size()-1;i>=0;i--) {
			List<Integer> depth=list.get(i);
			for(int j=0;j<depth.size();j++) {
				System.out.print(depth.get(j)+" ");
			}
			System.out.println();
		}
	}

	public static int[] arr;
	public static List<List<Integer>> list;
	//k가 최대 10이므로 사용해도 괜찮다고 판단

	public static void level(int K, int mid) {//mid란 좌 우로 나누었을때 중심 노드를 뜻함 K가 낮아질 수록 depth깊어지는 것으로 구현
		list.get(K).add(arr[mid]);
		if (K == 1)	return;
		level(K - 1, mid - (((int) Math.pow(2, K - 1) - 1) / 2 + 1));
		//mid 정하고 mid 앞부분의 다음 재귀 mid 구하기
		level(K - 1, mid + ((int) Math.pow(2, K - 1) - 1) / 2 + 1);
		//mid 뒷부분의 다음 재귀 mid구하기
  }
}
