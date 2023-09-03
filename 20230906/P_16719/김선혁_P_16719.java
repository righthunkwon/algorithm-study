import java.util.Scanner;

public class Main {


	static String N;
	static boolean[] flag;
	static char[] ans;
	static char[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// 일단 가장 알파벳 빠른거를 찾음
		// 그 알파벳 기준으로 뒤를 먼저 탐색해버리고
		// 뒤부분 끝까지 다해버리면
		// 그다음 그 알파벳 앞부분 탐색
		N = sc.next();
		flag = new boolean[N.length()];
		ans = new char[N.length()];
			ans = N.toCharArray();
					
		say(0,N.length()-1);
		
		
	}
	public static void say(int left, int right) {
		if(left > right) {
			return;
		}
		int idx= left;
		for(int i =left;i<=right;i++) {
			if(ans[idx]>ans[i]) {
				idx = i;
			}
		}
//		ans[idx] = 'ㅓ';
		flag[idx] = true; 
		for(int i =0;i<ans.length;i++) {
			if(flag[i]) {
				System.out.print(arr[i]); // true인것만 출력
			}
		}
		System.out.println();
		say(idx+1, right); // 해당지점을 기준으로 뒤로 쭉
		say(left, idx-1); // 젤 먼저의 알파벳 끝나면 이제 앞에 탐색
		
	}


}
