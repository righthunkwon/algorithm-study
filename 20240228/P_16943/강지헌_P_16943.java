import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static boolean[] check;
    static int N, ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = st.nextToken().toCharArray();
        N = Integer.parseInt(st.nextToken());
        check = new boolean[arr.length];
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int cnt, int sum) {
        if (cnt >= arr.length) {
            if (sum < N && ans < sum) ans = sum;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                if (sum == 0 && arr[i] == '0') continue;
                check[i] = true;
                dfs(cnt + 1, sum * 10 + arr[i] - '0');
                check[i] = false;
            }
        }
    }
}
