import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        long at=Long.parseLong(st.nextToken());
        long hp=0,max=0;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int ty=Integer.parseInt(st.nextToken());
            int att=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            if(ty==1) {
                hp += att*((h/at)-(h%at!=0?0:1));
                max=Math.max(max, hp);
            }
            else {
                at += att;
                hp=Math.max(hp-h,0);
            }
        }
        System.out.println(max+1);
    }
}
