import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;	
		while(true) {
				// 한줄씩 읽어서 
				// 만약 -가 나오면 그대로 종료
				// 아니면 스택에 하나씩 저장해서 바뀌어야하는 개수 세기
				String line = br.readLine();
				Stack<String> st = new Stack<String>();
				int cnt = 0;
				// line 길이만큼 반복
				for(int i=0; i<line.length();i++) {
					String tmp = line.substring(i,i+1);
					// - 이면 그대로 종료
					if(tmp.equals("-")) {
						System.exit(0);
					}
					else {
						// 1. {이면 push 
						// 2. }이면 스택에서 비어있으면 바꿔주고 넣고, 아니면 pop
						// 3. 모두 끝났을때 남으면 다 +1씩
						// (스택에는 {만 저장)
						if(tmp.equals("{")) {
							st.add(tmp);
						}
						else {
							if(st.size()==0) {
								st.add("{");
								cnt++;
							}
							else {
								st.pop();
							}
						}
					}
				} // for
				// for문 끝났을때 st 크기의 2분에1 만큼 cnt++
				System.out.println((tc++)+". "+(cnt+st.size()/2));
			} // while


	}

}
