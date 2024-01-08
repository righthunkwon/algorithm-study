import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        System.out.println(dfs(0,N-1));
    }

    private static int dfs(int s, int e) {
        if(s==e) return arr[s];
        if(e-s==1) return arr[s]+arr[e];
        int m=(e-s+1)/2,i;
        int gcd=arr[s];
        for(i=s+1;i<s+m;i++) gcd=GCD(gcd, arr[i]);
        int ls=gcd+dfs(s+m,e);
        gcd=arr[s+m];
        for(;i<=e;i++) gcd=GCD(gcd, arr[i]);
        int rs=gcd+dfs(s,s+m-1);
        return Math.max(ls,rs);
    }

    private static int GCD(int a, int b) {
        int c;
        while(b!=0) {
            c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
}
