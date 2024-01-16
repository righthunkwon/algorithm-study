import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static int ans;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 일단 x가 1,000,000까지면 다 넣고 하면 시간초과남
		// 입력하는 즉시 높이를 갱신하고
		// 1. 더 높이가 높아지면 뒤에는 건물이 더 있다는 뜻으로 
		// stack에 넣음
		// 2. 낮아지면 ans++하고 값을 pop
		// 3. 만약 입력이 끝났는데 남은 값은
		// 그 높이에 해당하는 값만큼의 건물이 남아있는 것으로
		// 개수만큼 ans++

		// 입력
		ans = 0;
		Stack<Integer> stack = new Stack<>();
		int x = 0; 
		int y = 0; // 높이
		for(int i =0;i<N;i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			// 일단 x와 y를 입력받고 
//            System.out.println(x+" "+ans);
            // 2번 경우로 더 낮은 높이가 입력된 경우
            while(true){
            	// 일단 스택크기가 0 이면 break
            	if(stack.size()==0) {
            		break;
            	}
            	// 만약 입력된 높이가 더 크다면 break
            	if(stack.peek()<= y) {
            		break;
            	}
            	// 낮은 높이가 들어오면 
            	// 개수만큼 다 확인하고 
            	// 높은 높이가 나올때까지           (이 경우는 ㄱ자 경우로 ㄱ자 모형이 끝날때까지)
            	// ans++하고 pop
            	ans++;
            	stack.pop();
            }
            // 현재 들어온 값의 높이와
            // 지금 높이값인 stack의 peek 값이 같다면
            // 변화 x , 다음 입력받음
			if(stack.size()!=0 && stack.peek() == y){
				continue;
			}
			// 확인 다 끝나면 stack에 추가
			// 어차피 1번경우는  스택추가만 있음(높이가 떨어질때 ans++)
			stack.add(y);
		}
		// 3번경우 큐가 빌때까지
		while (true){
			if(stack.size()==0) {
				break;
			}
			// 
			//남은 건물이 있다는 뜻이므로 ans를 ++ 해주고 pop
			if(stack.peek()>0){
				ans++;			
			}
			stack.pop();
		}
		System.out.println(ans);

	}


}
