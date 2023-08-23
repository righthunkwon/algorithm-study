package back;
import java.io.*;
import java.util.*;
//문제 해석 및 접근 : 집중국이 1개라면 센서를 위치 순서대로 sort한 뒤 처음부터 끝까지의 길이를 나타낸다
				//(어느 위치에 해도 오른쪽 왼쪽 값 더해야하기 때문)
          		//집중국이 2개라면 2개로 나누어서 선을 이어도 된다라는 뜻이기 때문에 
				//처음부터 끝까지 중 센서사이끼리의 거리 1개 빼준 값이다.
          		//집중국이 K개라면 센서 사이의 거리 K-1개 빼준값이다.
				//최솟값이기 위해서는 거리사이 차이가 가장 많이 나는 것을 빼주어야한다.
				//센서보다 집중국 수가 많거나 같으면 0을 출력
public class Problem_2212 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());// 센서의 개수
		int K = Integer.parseInt(bf.readLine());// 집중국의 개수
		StringTokenizer st = new StringTokenizer(bf.readLine());
		List<Integer> suList = new ArrayList<Integer>();// 센서가 있는 위치 넣는 리스트

		for (int i = 0; i < N; i++) {
			suList.add(Integer.parseInt(st.nextToken()));
		} // 입력받기
		Collections.sort(suList);// 수 나열
		if (N <= K) {//센서의 개수와 집중국의 개수가 같거나 집중국이 더 많으면 0출력해야함
			System.out.println(0);
		} else {
		List<Integer> gapList = new ArrayList<Integer>();// 센서의 위치 차이 넣는 리스트
		for (int i = 0; i < suList.size() - 1; i++) { 
			gapList.add(suList.get(i + 1) - suList.get(i));//두 센서의 위치 차이를 리스트에 넣기
		}
		Collections.sort(gapList);//제일 큰 값들을 빼기 위해 sort
			for (int i = 1; i <= K - 1; i++) {
				gapList.remove(gapList.size() - 1);//집중국수 -1 만큼 큰 수 빼고 
														//(왜냐면 그 수만큼 집중국 세울 거기 때문에 
														//가장 차이 많이 나는 곳을 끊어서 그곳에 세운다는 가정하에 그럼 차이 없앨 수 있음)
			}
			int sum = 0;
				for (int i = 0; i < gapList.size(); i++) {//남은 센서의 위치 차이 다 더하면 됨
					sum += gapList.get(i);
				}
			System.out.println(sum);
		}
	}
}
