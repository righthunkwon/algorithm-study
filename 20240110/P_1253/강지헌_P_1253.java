import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=0;i<N;i++) {
            int l=0,r=N-1;
            while(l<r) {
                if(l==i) l++;
                else if(r==i) r--;
                else if (arr[l] + arr[r] == arr[i]) {
                    ans++;
                    break;
                } else if (arr[l] + arr[r] < arr[i]) l++;
                else r--;
            }
        }
        System.out.println(ans);
    }
}
