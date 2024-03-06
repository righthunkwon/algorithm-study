package _20240306;

import java.util.*;
import java.io.*;

public class _27084_카드뽑기 {
	// 나눌 수: MOD
	private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // HashMap을 이용해서 각 숫자와 숫자가 나타난 횟수를 저장
        HashMap<Integer, Integer> table = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            // hashmap에서 키로 주어진 값을 찾는다
            // num 키가 존재하면, 그에 해당하는 값을 반환해서 1을 더하고 다시 넣는다
            // num 키가 없다면, 두 번째 인자로 주어진 기본값(0)을 반환해서 1을 더하고 다시 넣는다
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        
        long ans = 1;
        
        for (int value : table.values()) {
        	// 어떤 카드를 뽑았을 때  카드를 뽑을 수 있는 경우의 수는 카드 수 +1임.
            ans *= value + 1;
            // 결과값이 나머지 이므로 나머지를 계산해서 저장함
            ans %= MOD;
        }
        // 아무 카드도 뽑지 않는 경우를 -1로 빼줌.
        // 그리고 음수가 되지 않도록 MOD 더하고 그거의 나머지를 수하는 식으로 다시 수정
        ans = (ans - 1 + MOD) % MOD;
        
        System.out.println(ans);
	}//main
}
