package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934_완전이진트리 {
	// 중위순회한 결과로 트리 구조 출력
	// 완전 이진 트리이기 때문에 가운데 값은 루트
	public static int K;
	public static int[] arr;
	public static List<ArrayList<Integer>> ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		K = Integer.parseInt(br.readLine());
		// 완전 이진 트리이기 때문에 노드의 갯수만큼 배열 생성
		arr = new int[(int)Math.pow(2, K)-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 입력 완료
		
		// depth에 맞게 노드들 저장
		ans = new ArrayList<>();
		for(int i = 0; i < K; i++) {
			ans.add(new ArrayList<>());
		}
		
		sol(0, arr.length - 1, 0);
		
		// ans을 StringBuilder에 담자
		for(int i = 0; i < K; i++) {
			for(int a : ans.get(i)) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void sol(int st, int end, int depth) {
		
		// 기저 부분
		if(depth == K) return;
		
		// 중간값인 루트
		int mid = (st + end) / 2 ;
		
		ans.get(depth).add(arr[mid]);
		
		// 왼자 (st ~ mid -1)
		sol(st, mid - 1, depth + 1);
		// 오자 (mid + 1 ~ end)
		sol(mid + 1, end, depth + 1);
	}
}
