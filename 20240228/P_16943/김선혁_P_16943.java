import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String N;
	static int M;
	static String[] arr;
	static boolean[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.next();
		M = sc.nextInt();
		// N은 string으로 받고
		// M은 int로 받고
		
		// dfs를 하면서 N의 숫자를 재조합하고 
		// 중간마다 숫자로 바꿔서 M보다 클경우 return하는 백트래킹 실시
		
		// 가장큰수를 뽑으면되니깐 N을 정렬한 후 맨뒤에서 부터 뽑아보자

		arr = new String[N.length()];
		for(int i = 0;i<N.length();i++) {
			arr[i] = N.substring(i,i+1);
		}
		flag = new boolean[N.length()];
		// 이제 시작 - string이어도 정렬이 된다?
		Arrays.sort(arr);
		solve(0 , "");
		System.out.println(-1);
	}
	public static void solve(int idx, String word) {
		// 현재 idx가 N이랑 길이가 같아지면 종료
		if(idx == N.length()) {
			// 확인한번하고 출력하고 시스템 종료
			if(Integer.parseInt(word) < M) {
				System.out.println(word);
				System.exit(0);
			}
			return;
		}
		// 백트래킹
		if(!word.isEmpty() && (Integer.parseInt(word) > (M/(int)(Math.pow(10,N.length() - word.length())))) ){
			return;
		}
		
		for(int i = N.length()-1;i>=0;i--) {
			if(idx==0 && arr[i].equals("0")) {
				continue;
			}
			if(flag[i]) {
				continue;
			}
			flag[i] = true;
			solve(idx+1 , word+arr[i]);
			flag[i] = false;
		}
		return;
	}

}
