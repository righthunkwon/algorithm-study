package _20240117;

import java.util.*;
import java.io.*;

public class _11286_절댓값힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        	// 우선순위 큐에 문제에서 제시된 조건대로 수가 나오도록 조건을 설정한다
        	
        	// 절대값이 작으면 먼저 나오도록 하고
        	// 절대값이 더 큰 경우에는 뒤로 가도록 하고
        	// 절대값이 같은 경우에는 그냥 값을 비교해서 작은 값이 먼저 나오도록 한다
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else if (o1[0] > o2[0]) return 1;
                else {
                    if (o1[1] < o2[1]) return -1;
                    else return 1;
                }
            }
        });
		
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			// 값이 0이 아니면 우선순위 큐에 절대값과 그냥 값을 저장한다
			if(a !=0) q.add(new int[] {Math.abs(a),a});
			else {
				// 값이 0일 때 우선쉬위 큐가 비어있으면 0을 출력하고
				// 아니면 주어진 우선순위에 따라 나온 값을 출력한다
				if(q.isEmpty()) sb.append(0).append("\n");
				else {
					int[] b = q.poll();
					sb.append(b[1]).append("\n");
				}
			}
		}
		System.out.println(sb);
		
		
		
	}//main

}
