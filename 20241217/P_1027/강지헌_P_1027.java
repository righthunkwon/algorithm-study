import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()),max=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            double lh=-1000000000,rh=-1000000000;
            int lc=0,rc=0;
            for(int j=i-1;j >=0;j--) {
                double t=(double)(arr[j]-arr[i])/(i-j);
                if(t>lh){
                    lh=t;
                    lc++;
                }
            }
            for(int j=i+1;j<N;j++) {
                double t=(double)(arr[j]-arr[i])/(j-i);
                if(t>rh) {
                    rh=t;
                    rc++;
                }
            }
            max=Math.max(max, rc+lc);
        }
        System.out.println(max);
    }
}
