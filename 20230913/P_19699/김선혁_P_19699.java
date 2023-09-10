import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int N; // 총 소 마리수
	static int M; // 선정될 소의 수
	static int[] arr; // 소의 몸무게를 저장할 배열
	static int count; // 몸무게의 합이 소수인 개수
	static ArrayList<Integer> ans;
	static HashSet<Integer> ans2;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		//		System.out.println(check(31));
		N = sc.nextInt();
		M =sc.nextInt();
		arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		ans2 = new HashSet<>();
		// 재귀를 통해서 먼저 
		// M마리를 선정했을 때의
		// 몸무게를 구해보고
		// 메서드를 통해서 그때의 몸무게의 합이 소수인지 판단
		// 소수이면 ==> ans에 넣기

		count = 0;
		solve(0,0,0); // 재귀 실행
		// 재귀가 끝나고 ans 배열 오름차순 정렬 후 출력	
		// ans에 hachset에 있는 내용들을 옮김
		ans = new ArrayList<>(ans2); 		
		Collections.sort(ans);
		
		// size가 0이면 -1 출력
		if(ans.size()==0) {
			System.out.println(-1);
		}
		// size가 0이 아닌경우에 출력
		else {
			for(int i=0;i<ans.size();i++) {
				System.out.print(ans.get(i)+" ");
			}
		}

	}
	public static void solve(int sum, int idx , int cnt) { 
		// 몇번째 소인지, 각 몸무게의 합 , 몇마리 선정했는지
		if(idx ==N) {
			if(M == cnt ) { // M마리 선정했을 때 idx가 N까지 갔을때만 계산
				if(check(sum)){ // 추가적으로 소수인지 확인
					ans2.add(sum); // 소수이면 ans에 추가
				}
			}
			return;
		}
		if(M<cnt) { // N이 idx 가기전에 선정을 더 많이하면 return;
			return;
		}
		solve(sum+arr[idx],idx+1,cnt+1); // 해당 소를 선정했을때
		solve(sum,idx+1,cnt); // 선정x일때

	}
	// 이제 몸무게 합이 소수인지 판단해보자......
	// output은 boolean
	public static boolean check(int num) {
		int cnt = 0; // 나눌 때 나머지가 0인 개수
		int tmp = 1; // 나누기 시작할 수
		while(true) {
			if(num % tmp ==0) {
				cnt++;
			}
			tmp++; // 나누는 수 tmp 상승
			if(cnt ==2) { // 1을 제외하고 나머지가 0인수가 2개가 되면 false
				return false;
			}
			if(tmp == num) { // cnt는 1이면서 num까지 tmp가 상승하면 true
				return true;
			}
		}

	}

}
