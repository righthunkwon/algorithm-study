
import java.io.*;
import java.util.*;
//덱으로 풀려다가 ...... 복잡해짐 ,,,,,
public class Pro_12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		Deque<Character> dq = new LinkedList<Character>();
		for (int i = 0; i < T.length; i++) {
			dq.addLast(T[i]);
		}
		boolean pollLast = true;
		boolean same1 = true; //앞부터 확인
		boolean same2 = true; //뒤집어서 확인
		//T에서 S길이로 줄이는 과정
		while (true) {
			if (dq.size() == S.length) {//찾으려는 길이와 같아졌다면 ..
				char[] ans = new char[S.length];
				for (int i = 0; i < S.length; i++) { 
					ans[i] = dq.poll();
				}
				for (int i = 0; i < S.length; i++) {
					if (S[i] != ans[i]) {//그대로가 일치하냐
						same1 = false;
					}
					if (S[i] != ans[S.length - i - 1]) {//뒤집어서 일치하냐
						same2 = false;
					}
				}
				break;
			}
			if (pollLast) { //마지막부터 빼라
				Character last=dq.pollLast();
				if (last == 'B') { //B라면 다음에는 맨 앞을 빼야함 (뒤집는다고 생각한다.)
					pollLast = false;
					same1 = false;
				}else if(last!='A') {//A,B이외의 글자면 이미 틀렸다는 것 ..
					System.out.println(0);
					System.exit(0);
				}else {
					same1=true;
				}
				same2=true;
			} else { //맨앞부터 빼라
				Character first=dq.pollFirst();;
				if (first == 'B') {//이것도 B라면 뒤집는다고 생각해야하니까 다음에는 맨 뒤글자를 빼야함
					pollLast = true;
					same2 = false;
				}
				else if(first!='A') {
					System.out.println(0);
					System.exit(0);
				}
				else {
					same2=true;
				}
				same1=true;
			}
		}
		if (same1 || same2)
			System.out.println(1);
		else {
			System.out.println(0);
		}
	}
	
}
