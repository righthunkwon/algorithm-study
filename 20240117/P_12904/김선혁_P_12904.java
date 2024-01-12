import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
	static int N;
	static String a;
	static String b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 a = sc.next();
		 b= sc.next();
		// dfs로 2가지 경우를 모두 실행하다가
		// 일치하는거 나오면 1출력
		// 없으면 0출력 
		// 백트래킹 조건은 size가 b보다 커지면
		
		solve(a);
		System.out.println(0);
	
	}
	public static void solve(String ans) {
//		System.out.println(ans+" "+ans.length());
		if(ans.length()==b.length()) {
			if(ans.equals(b)) {
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		// 1번 A더하기
		// 2번 뒤집고 B더하기
//		// 문자열 뒤집기
		 StringBuffer sb = new StringBuffer(ans);        
		 String tmp = sb.reverse().toString();
//		System.out.println(ans +" "+tmp);
		// 뒤집은거랑 ans가 b에 포함안되있으면 return
		if(!b.contains(ans) && !b.contains(tmp)) {
			return;
		}
		solve(ans+"A");
		// B더해서 bfs
		solve(tmp+"B");
		return;
	}
}
