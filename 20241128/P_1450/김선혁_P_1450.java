package 백준;

import java.util.*;

public class Main {
	static int N;
	static int C;
	static ArrayList<Integer> ar1;
	static ArrayList<Integer> ar2;
	static int[] arr;
	static int ans;
	static int tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N+1];
		ans = 0;
		for(int i = 0 ; i< N;i++) {
			arr[i] = sc.nextInt();
		}
		// 이제 절반을 나눠서 먼저 앞쪽은 1에, 나머지는 2에 입력한 후
		// dfs방식으로 가능한 모든 합을 리스트에 추가한다.
		ar1 = new ArrayList<Integer>();
		ar2 = new ArrayList<Integer>();
		dfs1(0,0);
		dfs2(N/2 , 0);
		
		Collections.sort(ar2);
		// 1배열을 기준으로 이분탐색을 실시하고
		// 2배열을 정렬된 상태로 만든후에
		// 1배열의 앞에서부터 순서대로 이분탐색을 통해 C보다 작은 것을 찾고
		// st > en이 될때까지 이분탐색 진행
		for(int i = 0 ; i < ar1.size();i++) {
			tmp = -1;
			solve(0, ar2.size()-1, ar1.get(i));
			ans += tmp +1;
		}
		System.out.println(ans);
	}
	public static void dfs1(int index , int sum) {
		if(sum > C) {
			return;
		}
		// 해당 index를 포함하고 안하고 두개를 모두 진행하면서
		// 0~n/2까지 모든 가짓수를 리스트에 추가한다.
		if(index == N /2) {
			ar1.add(sum);
			return;
		}
		dfs1(index+1, sum + arr[index]);
		dfs1(index+1, sum);
		
	}
	public static void dfs2(int index , int sum) {
		if(sum > C) {
			return;
		}
		// 위와 반대로 절반을 나눴을때 뒷부분 진행
		if(index == N) {
			ar2.add(sum);
			return;
		}
		dfs2(index+1, sum + arr[index]);
		dfs2(index+1, sum);		
	}
	
	public static void solve(int st, int en, int val) {
		if(st > en) {
			return;
		}
		
		int mid = (st + en)/2;
		if(ar2.get(mid) + val <= C) {
			tmp = mid;
			solve(mid+1, en, val);
		}
		else {
			solve(st, mid-1, val);
		}
		
		
	}

}
