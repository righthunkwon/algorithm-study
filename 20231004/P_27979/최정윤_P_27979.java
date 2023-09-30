import java.io.*;
import java.util.*;
public class Pro_27979_볼링장아르바이트2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		} // 입력끝

		//공이 앞에 있는 공보다 무거우면 빼야하고, 다시 넣는 것은 정렬해서 순서대로 넣으면 되기 때문에 빼는 공 숫자만 세면 된다.
		//max값은 그 시점에만 확인하기 때문에 마지막에 안빼는 공 중에 빼는 공 보다 가벼운 공이  있는지  다시 한번 확인한다.(앞에서부터 넣는데 새로 넣는 공이 원래 있던 공보다 무게가 크면 안되기때문)
		//있다면 빼는 공으로 전환
		
		int result = 0;//정답
		int max = 0;//앞부터 탐색시 그 시점에서의 가장 큰 공무게
		int[] remove = new int[N];//빼서 다시 넣어야하는 것은 1로 바꿔놓는 배열
		int r_max = 0;//빼는 공 중 가장 큰 공무게
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < max) {//앞에 있는 공보다 가벼우면 빼야함 
				remove[i] = 1;
				r_max = Math.max(r_max, list.get(i));
			}
			max = Math.max(max, list.get(i));
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < r_max && remove[i] == 0) {//아직 안 뺀 공 중에서 빼야하는 가장 무거운 공보다 가벼우면 어차피 빼서 다시 놔야함 
				remove[i] = 1;
			}
		}
		for (int i = 0; i < remove.length; i++) {
			if (remove[i] == 1)
				result++;
		}
		System.out.println(result);
	}
}
