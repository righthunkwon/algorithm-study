import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b= sc.next();
		// 일단 두개에서 겹치는 걸 확인하려면
		// 이중포문을 통해서
		// 겹치는 문자 하나 나올때 1을 넣어주고
		// 그다음것도 같으면 +1을 게속해줌
		// 다르면 0
		int[][] arr = new int[a.length()+1][b.length()+1];
		int ans = 0;
		for(int i =1;i<=a.length();i++) {
			for(int j =1;j<=b.length();j++) {
				// 겹치는거 나올때 확인(바로 전항꺼 +1해야해서 0이면 오류나서 1부터)
				if(a.substring(i-1,i).equals(b.substring(j-1,j))) {
					arr[i][j] = arr[i-1][j-1] +1; // 같으면 전항 +1
					ans = Math.max(ans, arr[i][j]); // 최대 길이 ans에 저장
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
