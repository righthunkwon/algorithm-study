import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long dfs(long n) {
        if (n == 0 || n == 1) return n;
        int cnt = 0;
        long pow = 1;
        while (pow * 2 <= n) {
            pow *= 2;
            cnt++;
        }
        return cnt * pow / 2 + (n - pow + 1) + dfs(n - pow);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(dfs(B) - dfs(A - 1));
    }
}
