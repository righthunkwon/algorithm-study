import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long N=Integer.parseInt(br.readLine());
        long[] di= new long[6];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++) di[i]=Long.parseLong(st.nextToken());
        
        long ans=0;
        if(N==1) {
            Arrays.sort(di);
            for(int i=0;i<5;i++) ans+=di[i];
            System.out.println(ans);
        } else {
            long t=di[0];
            for(long x:di) if(x<t) t=x;
            long a=(N-2)*(5*N-6)*t;

            t=Math.min(Math.min(di[0]+di[1], di[1]+di[5]), Math.min(di[0]+di[4], di[4]+di[5]));
            t=Math.min(Math.min(di[0]+Math.min(di[2], di[3]), di[1]+Math.min(di[2], di[3])), t);
            t=Math.min(Math.min(di[4]+Math.min(di[2], di[3]), di[5]+Math.min(di[2], di[3])), t);
            long b=(8*N-12)*t;

            t=Math.min(Math.min(di[0]+di[1], di[1]+di[5]), Math.min(di[0]+di[4], di[4]+di[5]))+Math.min(di[2], di[3]);
            long c=4*t;

            System.out.println(a+b+c);
        }
    }
}
