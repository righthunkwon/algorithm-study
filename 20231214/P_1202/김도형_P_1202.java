package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel{
	int m; //보석 무게
	int v; //보석 가격
	public Jewel(int m, int v) {
		this.m = m;
		this.v = v;
	}
}

public class BOJ_Q1202_보석_도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //보석 수
		int K = Integer.parseInt(st.nextToken()); //가방 수
		Jewel[] jewelry = new Jewel[N]; //보석 정보 입력 배열
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelry[i]=new Jewel(m,v);
		}
		int []bag = new int[K]; //가방 최대무게 정보 입력 배열
		for(int i=0;i<K;i++) {
			bag[i]=Integer.parseInt(br.readLine());
		}//입력 끝
		
		//가방에는 "최대 한개"의 보석만 넣을 수 있음! -> 용량 작은 가방 먼저 채우기..
		//가장 작은 가방에 넣을 수 있는 가장 비싼 보석 넣자

		//보석을 무게 기준 오름차순 정렬하고
        Arrays.sort(jewelry, Comparator.comparing((Jewel j) -> j.m));
		
//        for(int i=0;i<N;i++) {
//        	System.out.print("m="+jewelry[i].m+" ");
//        	System.out.println("v="+jewelry[i].v);
//        } //보석 정렬 확인용..
        
		Arrays.sort(bag); //가방 오름차순 정렬

		//Comparator를 통해 보석을 가격 기준 내림차순 정렬되는 우선순위 큐 선언
		PriorityQueue<Jewel>pq = new PriorityQueue<>(Comparator.comparing((Jewel j)-> j.v).reversed());
		
		long ans = 0; //정답 변수 초기화
		int idx=0; //보석의 인덱스
		
		//작은 가방부터 차례로 보석을 넣음(넣을 수 있는 최대 가격의 보석을 넣어줌)
		for (int i = 0; i < K; i++) {
            while (idx < N && jewelry[idx].m <= bag[i]) { //가방이 감당 가능한 보석 pq에 추가..
                pq.offer(jewelry[idx]); //인덱스는 for문 밖에 선언해뒀기 떄문에 한번 넣었던 idx는 다시 방문 안함
                idx++;
            }
            if (!pq.isEmpty()) { //pq에 들어간 것들 중 가장 가격 높은걸 정답에 더함
                ans += pq.poll().v;
            }
        }

		System.out.println(ans);
		
	}
}
