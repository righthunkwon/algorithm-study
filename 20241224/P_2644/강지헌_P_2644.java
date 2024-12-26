package q2644;

import java.util.*;
import java.io.*;

public class Main {
    static int n,m,s,e;
    static int[][] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1][n+1];
        dist=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        s=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x][y]=arr[y][x]=1;
        }
        dfs(s);
        System.out.println(dist[e] == 0 ? -1 : dist[e]);
    }
    public static void dfs(int index){
        if(index == e) return;
        for(int i=1; i<=n; i++){
            if(arr[index][i]==1 && dist[i]==0){
                dist[i]=dist[index]+1;
                dfs(i);
            }
        }
    }
}
