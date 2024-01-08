import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        int[][] dy = new int[a.length()+1][b.length()+1];
        int max=0;
        for(int i=1;i<=a.length();i++) {
            for(int j=1;j<=b.length();j++) {
                if(a.charAt(i-1)==b.charAt(j-1)) {
                    dy[i][j]=dy[i-1][j-1]+1;
                    max=Math.max(max,dy[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
