import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Arrays.fill(arr, 0);
        for (int i = 1; i <= 1000000; i++) {
            for (int j = i * 2; j <= 1000000; j += i) arr[j] += i;
            
        }
        for(int cnt=1;;cnt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (s == 0 && e == 0 && b == 0) break;

            int ans = 0;

            for (int i = s; i <= e; i++) {
                if (b >= Math.abs(arr[i] - i)) ans++;
            }
            sb.append("Test ").append(cnt).append(": ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
