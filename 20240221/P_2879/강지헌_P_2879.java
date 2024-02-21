import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int t = 0, ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken())-arr[i];
        if(N>1) {
            t=arr[0];
            for (int i = 1; i < N; i++) {
                if(t*arr[i]<0) ans += Math.abs(t);
                else if(Math.abs(t)>=Math.abs(arr[i])) ans += Math.abs(t)-Math.abs(arr[i]);
                t = arr[i];
            }
        }
        else ans = arr[0];
        System.out.println(ans+Math.abs(t));
    }
}
