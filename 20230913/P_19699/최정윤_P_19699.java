package baek;

import java.io.*;
import java.util.*;
// set은 중복허용 불가 , 출력은 iterator 사용해야 출력가능 확장for문으로도 가능
//list에 addall을 하여 hashset을 넣을 경우 hashset의 원소 개수만큼 list에 알아서 더해짐 
//백트랙킹이 어디서 사용되는지 모르겠음
public class Pro_19699_소난다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 농장에 있는 소들
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		weight = new int[N];
		arr = new int[M];
		list = new ArrayList<>();
		hashset = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		pick(0, 0);
		list.addAll(hashset);//오름차순 정렬

		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}
	}

	static int M;
	static int N;
	static List<Integer> list;// 소수를 담는 리스트
	static HashSet<Integer> hashset;
	static int[] arr;// M마리의 조합 담는 배열
	static int[] weight;// N마리 몸무게 담아놓는 배열

	public static void pick(int idx, int aidx) {
		if (aidx == M) {//M마리 고르는거 꽉찼으면
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += arr[i];
			}//몸무게 총합구하고
			boolean prime = true;
			//소수인지 확인하는 작업
			for (int i = 2; i < sum; i++) {
				if (sum % i == 0) {
					prime = false;
					break;
				}
			}
			if (prime)
				hashset.add(sum);
			return;
		}
		if (idx == N) {
			return;
		}
		// 재귀부분
		arr[aidx] = weight[idx];
		pick(idx + 1, aidx + 1);
		arr[aidx] = 0;
		pick(idx + 1, aidx);
	}
}
