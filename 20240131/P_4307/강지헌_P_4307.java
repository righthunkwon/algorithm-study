import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) arr[i] = Integer.parseInt(br.readLine());
            int min = 0, max = 0;
            for (int i = 0; i < m; i++) min = Math.max(min, Math.min(arr[i], n - arr[i]));
            for (int i = 0; i < m; i++) max = Math.max(Math.max(max, arr[i]), n - arr[i]);
            System.out.println(min + " " + max);
        }
    }
}
