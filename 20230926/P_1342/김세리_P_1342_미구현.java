import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1342_행운의문자열 {
	static int[] abc;
	static int cnt, res;
	static boolean[] visited;
	static String st;
	static ArrayList<Character> arrList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine();
		
		// 알파벳 총 26자이므로 26칸 배열 만든다
		abc = new int [26];
		
		// abc 배열에서 해당하는 알파벳의 수를 증가시킨다(각 알파벳이 몇개있는지)
		for(int i=0;i<st.length();i++) {
			abc[st.charAt(i)-'a']++;
		}
		visited = new boolean [10]; // 문자열 최대 길이가 10
		//조합을 돌려서 전체 문자열 개수를 구한다
		per(0);
		//중복을 제거해준다
		for(int i=0;i<26;i++) {
			if(abc[i]>1) {
				res /= fac(abc[i]);
			}
		}
		System.out.println(res);
	}//main
	
	static boolean check() {
		for(int i=0;i<arrList.size()-1;i++) {
			if(arrList.get(i)==arrList.get(i+1)) return false;
		}
		return true;
	}
	
	
	static int fac(int N) {
		if(N==1)
			return 1;
		else return N*fac(N-1);
	}
	
	
	static void per(int cnt) {
		if(cnt == st.length()) {
			if(check()) {
				res++; return;
			}
		}
		for(int i=0;i<st.length();i++) {
			if(!visited[i]) {
				visited[i]=true;
				arrList.add(st.charAt(i));
				per(cnt+1);
				arrList.remove(arrList.size()-1);
				visited[i]=false;
			}
		}
	}

}
