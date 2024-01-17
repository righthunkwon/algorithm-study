
import java.util.*;
import java.io.*;

public class Pro_11286_절댓값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {//절댓값이 같을 경우는 작은 수
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);//절댓값이 작은 수 
			}
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num=Integer.parseInt(br.readLine());
			if (num == 0) { // 출력
				if(pq.isEmpty())sb.append(0+"\n");
				else sb.append(pq.poll() + "\n");
			}else { //넣기
				pq.add(num);
			}
		}
		System.out.println(sb);
	}
}
