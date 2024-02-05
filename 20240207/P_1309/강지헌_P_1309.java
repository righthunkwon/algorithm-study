import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[100001];
        dy[0] = 1; dy[1] = 3;
        for (int i = 2; i < n + 1; i++) dy[i] = (dy[i - 1] * 2 + dy[i - 2]) % 9901;
        System.out.println(dy[n]);
    }
}
