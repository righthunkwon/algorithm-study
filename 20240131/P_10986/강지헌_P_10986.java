import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] chk = new int[M];
        chk[0] = 1;
        st = new StringTokenizer(br.readLine());
        int t = 0;
        for (int i = 0; i < N; i++) {
            t += Integer.parseInt(st.nextToken());
            t = t % M;
            chk[t]++;
        }
        long ans = 0;
        for (int i = 0; i < M; i++) {
            if (chk[i] > 1) ans += (long) (chk[i]) * (long) (chk[i] - 1) / (long) 2;
        }
        System.out.println(ans);
    }
}
