import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int N;
	static int ans;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);	
		int T  =sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
		// 해시맵을 이용해
		// 입을 수 있는 종류의 개수를 구해서
		// 저장한 후에 
		// for문을 통해서 구해보자
		N = sc.nextInt();
		HashMap<String, Integer> hash = new HashMap<>();
		for(int i =0;i<N;i++) {
			String a = sc.next();
			String b = sc.next();
			if(hash.containsKey(b)) {
				hash.put(b, hash.get(b)+1);
				// 기존의 값을 불러와 새롭게 갱신
			}
			else {
				hash.put(b, 1);
			}
			// 해쉬맵을 이용해서
			// 기존에 존재하는 종류이면
			// 값을 1만 +1해주고
			// 처음들어오는 옷종류이면
			// 새롭게 종류를 만들어주고
			// 값을 1로 설정
		}
		
		// 이상태에서 2 ,1 이면 
		// 3x2 -1 이 결과 값
		int ans = 1;
		for(Map.Entry<String, Integer> h : hash.entrySet()) {
			ans *=h.getValue()+1;
//			System.out.println(h.getKey());
//			System.out.println(h.getValue());
		}
		
		System.out.println(ans-1);
		//알몸인 경우를 빼야하므로 -1
		
		
		
		
		

		}
	}

}
