import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {
 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
  // N : 원판의 개수 
	//	start : 출발지 
	//	mid : 중간에 거치는 장소
	//	to : 목적지
		bw.write((int) (Math.pow(2, N) - 1) + "\n");
 
		Hanoi(N, 1, 2, 3);
		bw.flush();
		bw.close();
 
	}	
		
	 
 
	public static void Hanoi(int N, int start, int mid, int to) throws IOException {
		// 이동할 원반의 수가 1개라면?
		if (N == 1) {
			bw.write(start + " " + to + "\n");
			return;
		}
 
		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(N - 1, start, to, mid);
    
		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		bw.write(start + " " + to + "\n");
    
		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(N - 1, mid, start, to);
 
	}
}
