import java.io.*;
import java.util.*;

public class Main{
    public static class Node implements Comparable<Node>{
        int r,c,g,next_g;
        public Node(int r, int c,int g,int next_g){
            this.r=r;
            this.c=c;
            this.g=g;
            this.next_g=next_g;
            
        }
        public int compareTo(Node n){
            if(this.g==n.g) return this.next_g-n.next_g;
            return this.g-n.g;
        }
    }
    static char[][] arr;
    static PriorityQueue<Node> pq;
    static int N,M,end_r,end_c;
    static boolean[][][][] visited;
    static int[] dr,dc;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dr=new int[]{-1,1,0,0};
        dc=new int[]{0,0,-1,1};
        arr=new char[N][M];
        pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
                arr[i]= br.readLine().toCharArray();         
        }
        int st_r=-1;
        int st_c=-1;
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]=='S'){
                    st_r=i;
                    st_c=j;
                    pq.add(new Node(i,j,0,0));
                }else if(arr[i][j]=='F'){
                    end_r=i;
                    end_c=j;
                }else if(arr[i][j]=='g') cnt++;
            }
        }
        visited=new boolean[N][M][cnt+1][N*M];
        visited[st_r][st_c][0][0]=true;
        
        
        bfs();
            
    }
    public static void bfs(){
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            if(curr.r==end_r&&curr.c==end_c){
                System.out.println(curr.g+" "+curr.next_g);
                return;
            }
            
            for(int i=0;i<4;i++){
                int nr=curr.r+dr[i];
                int nc=curr.c+dc[i];
                if(nr<0||nc<0||nr>=N||nc>=M||visited[nr][nc][curr.g][curr.next_g])continue;
                if(arr[nr][nc]=='g'){ 
                    pq.add(new Node(nr,nc,curr.g+1,curr.next_g));
                    visited[nr][nc][curr.g+1][curr.next_g]=true;
                                    
                }
                else {
                    boolean go_next=false;
                    for(int j=0;j<4;j++){
                        int rg=nr+dr[j];
                        int cg=nc+dc[j];
                        if(rg<0||cg<0||rg>=N||cg>=M)continue;
                        if(arr[rg][cg]=='g'){
                            go_next=true;
                            break;
                        }
                    }
                    if(go_next){
                        pq.add(new Node(nr,nc,curr.g,curr.next_g+1));
                        visited[nr][nc][curr.g][curr.next_g+1]=true;   
                    }else{
                        pq.add(new Node(nr,nc,curr.g,curr.next_g));
                        visited[nr][nc][curr.g][curr.next_g]=true;
                    }
                   
                    
                }
               
            }
        }
    }
}