import java.util.Scanner;

public class Main {

	static String N;
	static int[] arr;
	static int ans;
	public static void main(String[] args) {
		// 먼저 문자열을 입력받아
		// arr 배열에 현재 문자의 개수만큼
		// ++ 해주고 
		// 재귀 돌려서 직접 다 세기
		Scanner sc = new Scanner(System.in);	
		N = sc.next();
		arr = new int[26]; // 직접 세보니 26개		
		for(int i =0;i<N.length();i++) {
			arr[N.charAt(i) - 'a']++;
		}
		ans = 0;
		// 문자열 저장 완료
		solve(0,0);
		System.out.println(ans);
	}
	public static void solve(int cnt,int idx) {
		if(cnt==N.length()) {
			ans++;
			return;
		}
		// 알파벳 순으로 재귀를 돌려보자 
		for(int i=0;i<26;i++) {
			// 먼저 알파벳이 있어야 하고 , 전에 알파벳이 지금 들어갈 알파벳과 달라야함
			
			// 이렇게 될경우 맨처음이 0으로 시작해서 첫번째 알파벳이
			// a가 와야할경우가 불가능하기 때문에
			// cnt==0일 때는 예외로 가능하게 처리
			if(arr[i]!=0 && (idx!=i || cnt ==0)) {
				arr[i] --;
				solve(cnt+1,i); // 개수는 +1시켜주고 현재 알파벳 반환
				arr[i]++; // 포함안할 경우 +1;
			}
		}

	}
}
