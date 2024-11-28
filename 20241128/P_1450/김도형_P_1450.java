import java.io.*;
import java.util.*;
public class BOJ_Q1450_냅색문제 {
	
	static int n,c;
	static int [] arr;
	static ArrayList<Long> left = new ArrayList<>(); //절반 왼쪽으로 만들 수 있는 부분합 리스트
	static ArrayList<Long> right = new ArrayList<>(); //절반 오른쪽으로 만들 수 있는 부분합 리스트
	
	//모든 부분집합의 개수를 구했을 떄, 최대 2^30 -> 시간초과
	//"meet int the middle" 알고리즘 => 절반씩 나눠서 연산 후 합쳐서 해결 (2^15 두번 -> 2^16)
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0,n/2,0,left);
		dfs(n/2,n,0,right);
		
		Collections.sort(left); //이분탐색을 위해 정렬
		for(long e : right) { //오른쪽 부분합 리스트의 모든 원소들에 대해 이분탐색을 진행해 가능한 부분합 갯수 더해줌
			int l = 0;
			int r = left.size();
			int mid = (l+r)/2;
			while(l<r) {
				if(e+left.get(mid)<=c) {
					l = mid+1;
				}else {
					r = mid;
				}
				mid=(l+r)/2;
			}
			ans+=r;
		}
		System.out.println(ans);
	}//main
	
	static void dfs(int st, int ed, long sum, ArrayList<Long> list) {
		
		if(sum>c)return; //c보다 커지면 어차피 넣을 필요 x
		
		if(st >= ed) { //끝까지 갔으면 부분합 리스트에 추가
			list.add(sum);
			return;
		}
		dfs(st+1,ed,sum,list);
		dfs(st+1,ed,sum+arr[st],list);
		
	}//dfs

}
