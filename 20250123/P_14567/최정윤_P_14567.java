import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int f=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[f].add(b);
        }
        int[] dp=new int[N+1];
        Arrays.fill(dp,1);
        for(int i=1;i<N+1;i++){
            for(Integer a:arr[i]){ //i보다 먼저 들어야하는 과목들
                dp[a]=Math.max(dp[i]+1,dp[a]);//i번째+1하거나 원래 순서 중에 더 큰 수
                
            }
        }
        for(int i=1;i<=N;i++){
            System.out.print(dp[i]+" ");
        }            
        
        
    }
    static List<Integer>[] arr;
}