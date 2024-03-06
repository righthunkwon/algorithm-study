
import java.io.*;
import java.util.*;

public class Pro_27084_카드뽑기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = map.getOrDefault(num, 0) + 1;
			map.put(num, cnt);
		}
		long[] cnt = new long[map.size()];
		int i = 0;
		for (Integer key : map.keySet()) {
			cnt[i] = map.get(key);
			i++;
		}
		long a = (long) (Math.pow(10, 9) + 7);
		// 그냥 겹치지 않게 뽑는 것 구하는 문제 어차피 확률이 1/2이라서 똑같음????
		// Map에 <숫자, 갯수>로 넣자
		// 아무것도 안뽑을 확률이 업으니까ㅏ -1 해야함 그럼 분자 분모 상쇄
		long result = 1;
		for (int j = 0; j < cnt.length; j++) {
			result = (result*(cnt[j] + 1)) % a;
		}
		long ans = (long) ((result - 1) % a);
		System.out.println(ans);
	}

}
