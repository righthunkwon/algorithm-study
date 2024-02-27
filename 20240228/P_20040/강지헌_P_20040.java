import java.io.*;
import java.util.*;

class Main {
    private static int ans = 1;
    private static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N];
        int ans=1;
        for(int i=0; i<N; i++) p[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)){
                a=find(a); b=find(b);
                if(a<b) p[b]=a;
                else p[a]=b;
                ans++;
            }else{
                System.out.println(ans);
                return;
            }
        }
        System.out.println(0);
    }

    private static int find(int n){
        if(p[n] == n) return n;
        return p[n] = find(p[n]);
    }
}
