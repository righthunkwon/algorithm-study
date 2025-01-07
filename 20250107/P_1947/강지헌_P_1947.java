import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] dp=new long[1000001];
        dp[2]=1;
        for(int i=3;i<=n;i++) dp[i]=(i-1)*(dp[i-2]+dp[i-1])%1000000000;
        System.out.println(dp[n]);
    }
}
