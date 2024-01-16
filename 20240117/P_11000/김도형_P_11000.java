package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q11000_강의실_배정 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //N개의 수업
		int [][] arr = new int[N][2];
		//시작시간 순으로 오름차순 정렬, 시작시간 같으면 끝나는 시간 기준 오름차순 정렬 
		PriorityQueue<int[]>pq = new PriorityQueue<>((o1,o2)->{
			if(o1[0]==o2[0]) {
				return o1[1]-o2[1];
			}else {
				return o1[0]-o2[0];
			}
		});
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //수업 시작시간
			arr[i][1] = Integer.parseInt(st.nextToken()); //수업 끝 시간
			pq.add(arr[i]);
		}
		PriorityQueue<Integer>room = new PriorityQueue<>();
		room.offer(0);
		
		//pq에서 하나씩 빼면서 강의실에 시간 배정해주기
		while(!pq.isEmpty()) {
			//time[0]:시작시간 , time[1]:끝시간
			int[]time=pq.poll(); //현재 가장 일찍 끝나는 강의실 pq에서 꺼내고
			if(room.peek()<=time[0]) { //그 강의실에서 이어서 수업 진행 가능하면
				room.poll(); //빼고 끝나는 시간 갱신 
			}//만약 현재 수업 가장 일찍 끝나는 강의실에서 이번에 pq에서 꺼낸 수업 진행 불가능하면 강의실 새로 배정..
			room.offer(time[1]); 
		}
		System.out.println(room.size()); //강의실 수 출력
		
	}//main
}
