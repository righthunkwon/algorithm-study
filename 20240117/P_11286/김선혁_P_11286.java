import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
	public static class Node implements Comparable<Node> {
		int num, cnum;
		public Node(int num, int cnum) {
			this.num = num;
			this.cnum = cnum;
		}
		@Override
		public int compareTo(Node n){
			if(this.cnum -n.cnum ==0) {
				return this.num - n.num;
			}
			return this.cnum - n.cnum;
		}
	}
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// Node에 추가하면 바로 정렬
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		for(int i =0;i<N;i++){
			int tmp = sc.nextInt();
			// 0이면 이제 ar에서 cnum이 가장 작은거 제거
			if(tmp ==0){
				// 만약 ar에 아무것도 없으면 
				// 0을 출력 // 아니면 0번째꺼 제거
				if(pq.size()!=0) {
					Node n = pq.poll();
					System.out.println(n.num);
				}
				else {
					System.out.println(0);
				}
			}
			// 0이 아니면 리스트에 tmp 추가
			else{
				pq.add(new Node(tmp, Math.abs(tmp)));
			}
//			for(int in=0;in<ar.size();in++) {
//				System.out.println(ar.get(in).num+" "+ar.get(in).cnum);
//			}
//			System.out.println("!!");
		}



	}


}
