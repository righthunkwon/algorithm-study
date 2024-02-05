import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dy = new long[N + 1];
        dy[0] = dy[1] = 1;
        for (int i = 2; i < N + 1; i++) dy[i] = (dy[i - 2] + dy[i / 2]) % 1000000000;
        System.out.println(dy[N]);
    }
}
