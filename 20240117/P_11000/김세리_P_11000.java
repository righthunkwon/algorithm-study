package _20240117;

import java.util.*;
import java.io.*;

public class _11000_강의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[]o1, int[]o2){
				if(o1[0]<o2[0]) return -1;
				else if(o1[0]>o2[0]) return 1;
				else {
					if(o1[1]<o2[1]) return -1;
					else return 1;
				}
			}	
		});
		PriorityQueue<Integer> end = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pq.add(new int[] {a,b});
		}
		while(!pq.isEmpty()) {
			int[]temp = pq.poll();
			// 끝 시간을 새롭게 추가할 수 있으면 end에 있는애를 빼버린다
			if(!end.isEmpty() && end.peek()<=temp[0]) {
				end.poll();
			}
			// end에 새로운 애들을 넣는다
			end.add(temp[1]);
		}
		System.out.println(end.size());
		
	}//main

}
