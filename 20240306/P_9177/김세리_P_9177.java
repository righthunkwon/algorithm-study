package _20240306;
//https://loosie.tistory.com/767
import java.util.*;
import java.io.*;

public class _9177_단어섞기 {

	static char[] w1,w2, out;
	static boolean[][] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		
		// 주어진 수 만큼 반복하며 수행
		while(tc <= n) {
			
			String[] str = br.readLine().split(" ");
			w1 = str[0].toCharArray(); // 단어1
			w2 = str[1].toCharArray(); // 단어2
			out = str[2].toCharArray(); // 결과값단어
			
			// bfs가 true인지 false인지 따라 결과값 sb에 저장
			if(bfs()) {
				sb.append("Data set "+tc+": yes\n");
			}else {
				sb.append("Data set "+tc+": no\n");
			}
			tc++;
		}
		// sb 출력
		System.out.println(sb.toString());
	}
	
	static boolean bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		check = new boolean[201][201]; // 최대 200자 제한
		
		// 각 단어 0, 0, 0 위치에서 시작
		q.add(new int[] {0,0,0});
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			
			int idx1 = q.peek()[0];
			int idx2 = q.peek()[1];
			int outIdx = q.peek()[2];
			
			q.poll();
			
			// outIdx가 끝까지 오면 true 반환
			if(outIdx == out.length) {
				return true;
			}
			// idx1<w1.length: 아직 처리하지 않은 문자가 남아있는지 확인
			// !check[idx1+1][idx2]: 다음 문자를 아직 처리하지 않았는지 확인
			// w1[idx1] == out[outIdx]: 현재 단어의 문자가 out단어의 문자와 일치하는지 확인
			
			if(idx1<w1.length && !check[idx1+1][idx2] && w1[idx1] == out[outIdx]) {
				// 해당 문자를 사용하고 다음 문자로 넘어간다
				q.add(new int[] {idx1+1, idx2, outIdx+1});
				check[idx1+1][idx2] = true;
			}
			// 두번째 문자에 대한 동일한 로직
			if(idx2<w2.length && !check[idx1][idx2+1] && w2[idx2] == out[outIdx]) {
				q.add(new int[] {idx1, idx2+1, outIdx+1});
				check[idx1][idx2+1] = true;
			}
		}
		// 아닐 경우 false반환
		return false;
	}//main
}
