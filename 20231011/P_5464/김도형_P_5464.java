package AlgoStudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_Q5464_주차장 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //주차공간 수
		int M = sc.nextInt(); //오늘 주차장 이용할 차량 수
		
		int [] cost = new int[N+1];
		
		int [] weight = new int[M+1];
		
		for(int i = 1;i<=N;i++) {
			
			cost[i]=sc.nextInt();
			
		}
		
		for(int i = 1;i<=M;i++) {
			weight[i]=sc.nextInt();
			
		}
		
		//주차공간에 차량 있는지 확인용 배열
		int [] visit = new int[N+1];
		
		//대기차량용 큐 생성
		Queue<Integer> wait = new LinkedList<Integer>();
		
		int total = 0;
		
		for(int inNout=0;inNout<M*2;inNout++) {
			
			int x = sc.nextInt();
			
			if(x>0) {
				
				wait.add(x); //일단 큐에 삽입
				
				for(int i=1;i<=N;i++) {
					if(visit[i]==0) { //주차공간 있으면
						int a = wait.poll(); //큐에서 빼주고
						visit[i]=a; //그걸 방문 배열에 넣어줌
						total += cost[i]*weight[a]; //비용 계산
						break;
					}
					
					

				}
				
			}else {
				
				for(int i=1;i<=N;i++) {
					
					if(visit[i]==x*(-1)){ //-1 곱한 값을 방문배열에서 찾음
						
						if(!wait.isEmpty()) { //이때 큐가 비어있지 않으면 
							int a = wait.poll();
							visit[i]=a;
							total +=cost[i]*weight[a];
						}else {
							visit[i]=0;
						}
						break;
					}
					
				}
				
			}//else (음수 들어오면)
			
			
		}//inNout
		
		System.out.println(total);
		
		
	}

}
