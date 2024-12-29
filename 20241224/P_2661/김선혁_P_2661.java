
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 그냥 string을 진행하면서 좋은 수열인지 판단
		bfs("");		
	}
	public static void bfs(String word) {
		// 만약 길이가 N이랑 같아지면 그대로 출력
		if(word.length() == N) {
			System.out.println(word);
			System.exit(0);
		}
		// 인접한 수를 판단해서 1~3중에 하나를 선택하는 방식
		for(int i = 1;i<=3;i++) {
			String tmp = word + i;
			// tmp가 되는지 확인
			if(check(tmp)) {
				bfs(tmp);
			}
			
		}		
	}
	public static boolean check(String word) {
		for(int i = 1; i <= word.length() / 2; i++) {
            String front = word.substring(word.length() -i * 2, word.length() - i);
            String back = word.substring(word.length() - i, word.length());
            // 두개가 같으면 false
            if(front.equals(back)) {
            	return false;
            }
        }
        return true;
	}
	
}
