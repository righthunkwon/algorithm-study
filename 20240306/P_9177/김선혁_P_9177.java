import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node{
		int first;
		int second;
		int index;
		public node(int first, int second, int index) {
			super();
			this.first = first;
			this.second = second;
			this.index = index;
		}
	}
	static int N;
	static boolean flag;
	static String a;
	static String b;
	static String c;
	static int[][] arr;
	static Queue<node> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			flag = false;
			a = sc.next();
			b = sc.next();
			c = sc.next();
			// 각 두개의 길이가 200까지이므로
			// 미리 다 설정해놓고
			// a와 b의 index를 진행시키면서
			// c의 index확인 
			// 다 맞으면 flag는 true로
			arr = new int[201][201];
			q = new LinkedList<>();

			// index가 0,0 부터 시작
			q.add(new node(0,0,0));    	  

			while(true) {
				if(q.size()==0) {
					break;
				}
				node n = q.poll();
				// 만약 first와 second가 끝까지 갔으면
				// 그건 성공
				if(n.first == a.length() && n.second == b.length()) {
					flag = true;
					break;
				}
				// 방문처리
				 if (arr[n.first][n.second] == 1) {
			          continue;
			        }

				 arr[n.first][n.second] = 1;
				// 먼저 a가 index가 범위안에 있고
				// first번째 글자가 c의 단어랑 일치하면
				// 한칸다음으로 진행
				// 반대로 b가 일치하면 한칸더 진행 
				if (n.first < a.length() && a.substring(n.first, n.first+1).equals(c.substring(n.index,n.index+1))) {
					q.add(new node(n.first + 1, n.second, n.index + 1));
				}
				if (n.second < b.length() && b.substring(n.second, n.second+1).equals(c.substring(n.index,n.index+1))) {
					q.add(new node(n.first, n.second + 1, n.index + 1));
				}
			} // while
			System.out.print("Data set "+tc+": ");
			if(flag) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}

	}


}
