import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			// 옷 조합과 가짓수를 저장할 HashMap을 만든다
			HashMap<String, Integer> hm = new HashMap<>();
			
			int n = Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				// 공백을 기준으로 앞에 옷 이름은 버리고, 뒤에 종류만 저장한다
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				st.nextToken();//옷 이름은 버림
				String cloth = st.nextToken();
				// 이미 있는 종류이면 숫자에 +1하고, 없던 종류이면 종류와 가짓수 1을 추가한다
				if(hm.containsKey(cloth)) hm.put(cloth, hm.get(cloth)+1);
				else hm.put(cloth, 1);
				
			}//n
			// 주어진 조건에 맞게 답을 구하려면 입력된 가짓수 +1한 값을 곱한 뒤에
			// 아무것도 안입었을 경우(1)를 빼준다
			int result=1;
			for(int val : hm.values()) {
				result *=(val+1);
			}
			System.out.println(result-1);
		}//T
	}//main

}
