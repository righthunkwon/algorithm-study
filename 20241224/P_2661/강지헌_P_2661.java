import java.io.*;
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        dfs("");
    }
    private static void dfs(String s) {
        if(s.length() == n) {
            System.out.println(s);
            System.exit(0);
        }
        for(int i=1;i<=3;i++) if(chk(s + i)) dfs(s + i);
    }
    private static boolean chk(String ns) {
        int len=ns.length();
        for(int i=1;i<=len/2;i++) if(ns.substring(len - 2 * i, len - i).equals(ns.substring(len - i))) return false;
        return true;
    }
}
