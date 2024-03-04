import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int T = 1; T <= N; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();
            char[] c = st.nextToken().toCharArray();
            int ln = a.length, rn = b.length;
            boolean[][] dy = new boolean[ln + 1][rn + 1];
            dy[0][0] = true;
            for (int i = 0; i < ln; i++) dy[i+1][0] = a[i] == c[i] && dy[i][0];
            for (int i = 0; i < rn; i++) dy[0][i+1] = b[i] == c[i] && dy[0][i];
            for (int i = 1; i <= ln; i++) {
                for (int j = 1; j <= rn; j++) {
                    if (a[i-1] != c[i+j-1] && b[j-1] != c[i+j-1]) dy[i][j] = false;
                    else if (a[i-1] == c[i+j-1] && b[j-1] != c[i+j-1]) dy[i][j] = dy[i - 1][j];
                    else if (a[i-1] != c[i+j-1] && b[j-1] == c[i+j-1]) dy[i][j] = dy[i][j - 1];
                    else dy[i][j] = dy[i - 1][j] || dy[i][j - 1];
                }
            }
            System.out.println("Data set " + T + ": "+((dy[ln][rn]) ? "yes" : "no"));
        }
    }
}
