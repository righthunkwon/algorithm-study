import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int K; // 파티의 수
	static int[] arr;
	static int[] parent;
	public static ArrayList<Integer>[] party;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		// 거짓말을 아는사람은 
		// 일단 밑에 나오면 
		// 그사람들이랑 겹치는 모든사람들이 알게됨 
		// --> find 를 사용해서 
		parent = new int[N+1]; 
		party = new ArrayList[K];

		int num = sc.nextInt();
		arr = new int[num];
		for(int i =0;i<num;i++) {
			arr[i] = sc.nextInt();
			// 일단 아는사람들을 arr배열에 넣음
		}
		// 파티의 번호를 바탕으로 union과 find를 통해서
		// 서로 통하는 파티는 번호를 매길거임
		for (int i=0;i<=N;i++) {
			parent[i] = i;
		}
		// 일단 자신의 부모는 자신으로 설정해 놓고
		for (int i =0;i<K;i++) { // 파티의 수 만큼
			party[i] = new ArrayList<>();
			int a = sc.nextInt();
			// a명의 크기만큼 i번째 리스트는
			// 번호를 다 추가해줌
			for (int j =0;j<a;j++) {
				party[i].add(sc.nextInt());
			}
		}
		// 입력 끝
		// 이제 리스트마다 한명을 골라서 
		// 그 한명과 겹치는 파티는 모두 
		// 하나의 그룹으로 분류할거임!!
		for(int i =0;i<K;i++) {
			int tmp = party[i].get(0);
			// 첫번쨰사람을 기준으로 잡고
			// 1번째부터 탐색
			for(int j=1;j<party[i].size();j++) {
				union(tmp, party[i].get(j));
				// 둘이 하나의 그룹으로
			}
		}

		// 이제는 그룹에 없는 파티 count가자
		int ans = 0;
		for (int i=0;i<K;i++) {
			int tmp = party[i].get(0);
			boolean flag = true;
			for (int j=0;j<num;j++) {
				// flag를 true로 설정해놓고
				// find를 통해서 서로 부모 확인
				if(find(tmp) == find(arr[j])) {
					flag = false;
					// 같은 부모라면 진실아니깐 false
					break;
				}
			}
			if (flag) {
				// 같은 집합에 속하지 않는다면
				// 해당 파티에서는 들키지 않음
				ans++;
			}
		}
		System.out.println(ans);

	}
	// 두개의 부모 합치기
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {	          
			parent[b] = a;
		}
	}
	// 자신이 가지고 있는 부모 찾기
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		} 
		else {
			return parent[a] = find(parent[a]);
		}
	}

}
