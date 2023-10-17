package _20231018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _29813_최애의팀원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Queue<String> name = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		
		// 이름은 name에, 학번은 q에 넣는다
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			name.add(st.nextToken());
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		// 한양이의 팀원 1명 남을때까지(ㅠㅠ) 팀을 만들어 내보낸다
		while(q.size()!=1) {
			// q에서 학번 하나 꺼낼때, 똑같이 name에서도 꺼낸다
			int a = q.poll()-1;
			name.poll();
			
			// 팀이 아닌 애들은 빼서 뒤에다가 다시 넣는다
			for(int i=0;i<a;i++) {
				int temp = q.poll();
				q.add(temp);
				String t = name.poll();
				name.add(t);
			}
			// 팀이 만들어지면 q랑 name에서 뽑아낸다
			q.poll();
			name.poll();
		}
		// 마지막 한 명 남은 애 이름을 출력한다
		System.out.println(name.poll());

	}

}
