import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] chk = new int[100001];
        chk[arr[0]]++;
        int s = 0;
        int ans = 1;
        for (int i = 1; i < N; i++) {
            ;
            chk[arr[i]]++;
            if (chk[arr[i]] > M) {
                for (int j = s; j < i; j++) {
                    chk[arr[j]]--;
                    if (arr[i] == arr[j]) {
                        s = j + 1;
                        break;
                    }
                }
            }
            ans = Math.max(ans, i - s + 1);
        }
        System.out.println(ans);
    }
}
