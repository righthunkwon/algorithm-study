
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String M = sc.next();
		// 2개 사이에 숫자로 탐색
		// String으로 입력받고 
		// 서로 자리수 다르면 무조건 0 
		// 같은 개수일때만 확인해보자.	
		int ans = 0;
		if(N.length() == M.length()) {
			// 두개 숫자가 같은 자리수면 애초에 
			// 888 889 라면 2 ,  85800  85881 하면 2개고정 맨앞자리부터 개수count
			for(int i =0;i<N.length();i++) {
				if(N.substring(i,i+1).equals(M.substring(i,i+1))) {
					// 일단 같으면서 8일 때 count++해주고 다르면 break
					if(N.substring(i,i+1).equals("8")) {ans++;}
				}
				else {break;}
			}			
		}
		System.out.println(ans);


	}

}
