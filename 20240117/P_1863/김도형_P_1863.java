import java.io.*;
import java.util.*;

public class BOJ_Q1863_스카이라인_쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 앞 숫자 버림
        int[] map = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 사용하지 않는 문자열 버리기
            map[i] = Integer.parseInt(st.nextToken());
        }
        map[N] = 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0; // 정답 변수

        for (int i = 0; i <= N; i++) {
            while (!stack.isEmpty() && stack.peek() > map[i]) {
                stack.pop(); // 맨 꼭대기 뽑고
                ans++; // 정답 +1
            }
            if (!stack.isEmpty() && stack.peek() == map[i]) { // 남은 거 맨 위랑 같으면
                continue;
            }
            stack.add(map[i]);
        }
        System.out.println(ans);
    }
}
