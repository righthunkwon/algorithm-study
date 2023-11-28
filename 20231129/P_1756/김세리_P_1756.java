package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1756_피자굽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] oven = new int [D];
		
		st = new StringTokenizer(br.readLine());
		// 오븐 맨 위 지름부터 알려주는 거야
		// 그니까 밑에 지름이 커도 위에 입구가 작으면 어차피 피자 못들어가니까
		// 위에서부터 가장 작은 값을 오븐 지름으로 입력한다
		int minoven = Integer.MAX_VALUE;
		for(int i=0;i<D;i++) {
			int a = Integer.parseInt(st.nextToken());
			minoven = Math.min(minoven,a);
			oven[i] = minoven;
		}
		
		st = new StringTokenizer(br.readLine());
		Queue<Integer> pizza = new LinkedList<>();
		// 피자 만들어진 순서대로 알려주는 거야
		for(int i=0;i<N;i++) {
			pizza.add(Integer.parseInt(st.nextToken()));
		}//입력끝
		
		// 지금 현재 넣을 수 있는 오븐의 깊이
		int possibleoven=D;
		// 피자 남았을 때 표시하기 위한 변수
		int pizzaleft=0;
		
		// 피자가 다 없어질 때까지 하는거야
		while(!pizza.isEmpty()) {
			// 현재 반죽이 완성된 피자를 꺼낸다
			int currentpizza = pizza.poll();
			
			// 가능한 오븐이 없을 때 카운트해줄 변수임
			int nooven = 0;
			
			// oven은 배열이니까 가능한 깊이-1한 것부터 시작한다
			// 그리고 배열 뒤에가 오븐 깊은쪽이니까 거기부터 시작하는거임
			for(int i=possibleoven-1;i>=0;i--) {
				// 오븐에 피자를 넣을 수 있을 때
				// possibleoven 값을 바꿔주고 for문 나간다
				// 현재 피자 넣을 위치 찾았으니까
				if(oven[i]>=currentpizza) {
					possibleoven=i;
					break;
				}else { // 오븐에 넣을 수 없을떈 nooven값을 플러스한다
					nooven++;
				}
			}
			// nooven값이 possibleoven값과 동일하다는건
			// 오븐에서 현재 피자반죽을 놓을 곳이 없다는걸 의미한다
			
			// 근데 possibleoven이 1인 경우, 즉 마지막 한 층만 남아있는 경우이면서
			// nooven도 그 전에 1이 되었다면
			// 피자 반죽을 마지막 층에 구울 수 있는 경우에도 피자가 남았다고 생각할 수 있으니까
			// possibleoven이 1인 경우엔 따로 마지막 경우를 한 번 더 살펴준다
			if(possibleoven!=1 && nooven==possibleoven) {
				pizzaleft = 1;
				break;
			} else if(possibleoven==1 && oven[0]<currentpizza) {
				pizzaleft = 1;
				break;
			}
		}
		// 피자 반죽이 남았으면 0출력
		if(!pizza.isEmpty() || pizzaleft==1) System.out.println(0);
		// 안남았으면 마지막 반죽의 깊이 출력
		else System.out.println(possibleoven+1);
		
	}//main

}
