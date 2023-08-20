
import java.io.*;
import java.util.*;

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
		List<Integer> minusCount = new ArrayList<Integer>();// 센서의 위치 차이 넣는 리스트
		for (int i = 0; i < suList.size() - 1; i++) { 
			minusCount.add(suList.get(i + 1) - suList.get(i));//두 센서의 위치 차이를 리스트에 넣기
		}
		Collections.sort(minusCount);//제일 큰 값들을 빼기 위해 sort
			for (int i = 1; i <= K - 1; i++) {
				minusCount.remove(minusCount.size() - 1);//집중국수 -1 만큼 큰 수 빼고 
														//(왜냐면 그 수만큼 집중국 세울 거기 때문에 
														//가장 차이 많이 나는 곳을 끊어서 그곳에 세운다는 가정하에 그럼 차이 없앨 수 있음)
			}
			int sum = 0;
				for (int i = 0; i < minusCount.size(); i++) {//남은 센서의 위치 차이 다 더하면 됨
					sum += minusCount.get(i);
				}
			System.out.println(sum);
		}
	}
}
