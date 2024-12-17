import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] eat=new int[d+1],s=new int[N];
        eat[c]=3001;
        int cnt=1;
        for(int i=0;i<N;i++) s[i]=Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++) if(eat[s[i]]++==0) cnt++;
        int max=cnt;
        for(int i=0;i<N-1;i++){
            if(--eat[s[i]]==0) cnt--;
            if(++eat[s[(i+k)%N]]==1) cnt++;
            max=Math.max(max,cnt);
        }
        System.out.println(max);
    }
}
