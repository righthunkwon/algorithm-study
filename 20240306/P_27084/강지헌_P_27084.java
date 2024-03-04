import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) arr[Integer.parseInt(st.nextToken())]++;
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) continue;
            ans = (ans * (arr[i] + 1)) % 1000000007;
        }
        System.out.println(ans-1);
    }
}
