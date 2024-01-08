import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] brr = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            brr[arr[i]] = i+1;
        }
        int[] ans = new int[N];
        for(int i=0;i<N;i++) {
            for(int j=arr[i]*2;j<=1000000;j+=arr[i]) {
                if(brr[j]!=0) {
                    ans[i]++;
                    ans[brr[j]-1]--;
                }
            }
        }
        for(int i=0;i<N;i++) System.out.print(ans[i]+" ");
    }
}
