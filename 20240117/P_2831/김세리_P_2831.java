package _20240117;

import java.util.*;

public class _2831_댄스파티 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> lpreferM = new PriorityQueue<>(); //양수
		PriorityQueue<Integer> spreferM = new PriorityQueue<>(); //음수
		PriorityQueue<Integer> lpreferW = new PriorityQueue<>(); //양수
		PriorityQueue<Integer> spreferW = new PriorityQueue<>(); //음수
		
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			if(a>0) lpreferM.add(a);
			else spreferM.add(Math.abs(a));
		}
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			if(a>0) lpreferW.add(a);
			else spreferW.add(Math.abs(a));
		}
		int ans =0;
		// 키 큰 여자를 선호하는 남자 - 키 작은 남자를 선호하는 여자 매칭
		while (!lpreferM.isEmpty() && !spreferW.isEmpty()) {
			// 맨 앞의 수를 가지고 둘 다 조건 만족하면 매칭성공
            if (lpreferM.peek() < spreferW.peek()) {
                lpreferM.poll();
                spreferW.poll();
                ans++;
            } else {
            	// 아닐 경우 여자만 빼버려서 다음 여자와 매칭되는지 다시 보기
            	spreferW.poll();
            }
        }
		
		// 키 작은 여자를 선호하는 남자 - 키 큰 남자를 선호하는 여자 매칭
        while (!spreferM.isEmpty() && !lpreferW.isEmpty()) {
        	// 맨 앞의 수를 가지고 둘 다 조건 만족하면 매칭성공
            if (spreferM.peek() > lpreferW.peek()) {
                spreferM.poll();
                lpreferW.poll();
                ans++;
            } else {
            	// 아닐 경우 남자만 빼버려서 다음 남자와 매칭되는지 다시 보기
            	spreferM.poll();
            }
        }
		
		System.out.println(ans);
		
	}//main

}
