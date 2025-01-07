import java.io.*;
import java.util.*;
public class Main {
    private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF=1000000000;
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[][] arr=new int[n + 1][n + 1];
        for(int i=0;i<=n;i++) Arrays.fill(arr[i], INF);
        for(int i=1;i<=n;i++) arr[i][i]=0;
        for(int i=0;i < m;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[a][b]=Math.min(c, arr[a][b]);
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i!=j) {
                    for(int k=1;k<=n;k++) if(j!=k && i!=k) arr[j][k]=Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                sb.append((arr[i][j]!=INF?arr[i][j] : 0) + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
