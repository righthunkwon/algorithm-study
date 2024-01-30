import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M], chk = new int[M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int l = 0;
            int r = M - 1;
            for (int j = 0; j < M; j++) {
                if (j % 2 == 0) chk[l++] = arr[j];
                else chk[r--] = arr[j];
            }
            int min = Math.abs(chk[0] - chk[M - 1]);
            for (int j = 1; j < M; j++) min = Math.max(min, Math.abs(chk[j] - chk[j - 1]));
            System.out.println(min);
        }
    }
}
