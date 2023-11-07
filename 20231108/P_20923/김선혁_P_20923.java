import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 카드수
		M = sc.nextInt(); // 게임 수
		
		Deque<Integer> d1 = new ArrayDeque<>();
		Deque<Integer> d2 = new ArrayDeque<>();
		// 각각 d1이 도도 d2가 수연
		for(int i = 0;i<N;i++) {
			d1.add(sc.nextInt());
			d2.add(sc.nextInt());
		}
		// 입력 끝
		
		// 각각 서로 게임을 할건데 g1은 도도앞에있는 카드 , g2는 수연앞에 있는 카드 
		Deque<Integer> g1 = new ArrayDeque<>();
		Deque<Integer> g2 = new ArrayDeque<>();
		// deque사용할거임
		int tmp = 0; // 그라운드로 나오는 숫자
		boolean winner = false; // false면 도도가 이기고 true면 수연이 이기는거로 생각한다.
		while(true) {    		
    		// 우선 도도가 먼저 카드를 꺼냄
    		tmp = d1.pollLast();
    		g1.addLast(tmp); // 그라운드로 추가
    		// 만약 카드를 전부 꺼낸 것이면
    		// 수연이 승리한다.
    		if(d1.isEmpty()) {
    			winner = true;		// 수연 승리
    			break;
    		}
    		
    		// 도도가 이기는 경우 
    		// 숫자가 5일때
    		if(tmp == 5) {
    			// 수연이 꺼낸 숫자를 모두 
    			// 도도가 가져가고
    			// 그 다음으로 도도가 꺼낸 숫자를
    			// 다 가져감
    			while(g2.size()!=0) {
    				d1.addFirst(g2.poll());
    			}
    			while(g1.size()!=0) {
    				d1.addFirst(g1.poll());
    			}
    		}    		
    		// 수연이 이겼을 경우
    		// 꺼낸 두수의 합이 5일 때
    		// 먼저 그라운드에 둘다 숫자가 있어야함
    		if(!g1.isEmpty() && !g2.isEmpty() && g1.peekLast() + g2.peekLast() == 5) {
    			// 도도가 꺼낸거부터 추가하고
    			// 수연이 꺼낸숫자를 수연의 덱으로 다 가져감
    			while(!g1.isEmpty()) {
    				d2.addFirst(g1.poll());
    			}
    			while(!g2.isEmpty()) {
    				d2.addFirst(g2.poll());
    			}
    		}
    		// 게임한번이 이제 끝 
    		// M--하고 0이면 break
			M--;
    		if(M == 0) {
    			break;
    		}
    		
    		// 다음으로는 수연이 차례 ㄱㄱ
    		tmp = d2.pollLast();
    		// 한장먼저 꺼내놓고
    		g2.addLast(tmp);
    		// 만약 더 가진 카드가 없으면
    		// 도도가 승리
    		if(d2.isEmpty()) {
    			winner = false;		
    			break;
    		}
    		
    		// 도도가 이겼을 경우
    		if(tmp == 5) {
    			while(g2.size()!=0) {
    				d1.addFirst(g2.poll());
    			}
    			while(g1.size()!=0) {
    				d1.addFirst(g1.poll());
    			}
    		}
    		
    		// 수연이 이겼을 경우  위와 동일
    		if(!g1.isEmpty() && !g2.isEmpty() && g1.peekLast() + g2.peekLast() == 5) {
    			while(!g1.isEmpty()) {
    				d2.addFirst(g1.poll());
    			}
    			while(!g2.isEmpty()) {
    				d2.addFirst(g2.poll());
    			}
    		}
    		// 게임 1번 -- 
			M--;
    		if(M == 0) {
    			break;
    		}
    	}
		if(d1.size()>d2.size()) {
			winner = false; // 도도가 카드 더 많으면 승리
		}
		else {
			winner = true; // 아니면 수연승리
		}
    	    	
    	if(d1.size() == d2.size()) {
    		System.out.println("dosu");		
    	}
    	else if(winner) {
    		System.out.println("su");
    	}
    	else {
    		System.out.println("do");
    	}
    	
	}

		
	
}
