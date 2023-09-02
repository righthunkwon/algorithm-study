package level_24_recursion;
import java.util.Scanner;

// 재귀함수가 뭔가요?
public class P_17478 {
	private static int n; // 총 재귀 횟수
	private static String underbar; // 언더바를 담을 문자열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 재귀 횟수
		
		// 구현부
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursion(0); // 0부터 시작
	}
	
	private static void recursion(int depth) {
		// under bar
		underbar = ""; // 초기화
		for (int i = 1; i <= depth; i++) {
			underbar += "____";
		}
		
		// 기저부분(종료조건)
		if (depth == n) {
            		System.out.println(underbar + "\"재귀함수가 뭔가요?\"");
          		System.out.println(underbar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            		System.out.println(underbar + "라고 답변하였지.");
            		return;
		}
		
		// 재귀부분(반복수행)
		System.out.println(underbar + "\"재귀함수가 뭔가요?\"");
   	    	System.out.println(underbar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
      	  	System.out.println(underbar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        	System.out.println(underbar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        	recursion(depth + 1);
        
        	// under bar
		underbar = ""; // 초기화
		for (int i = depth; i >= 1; i--) {
			underbar += "____";
		}
        	System.out.println(underbar + "라고 답변하였지.");
	}
}
