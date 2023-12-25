import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	int[] xx= {1,0,-1,0}, yy= {0,-1,0,1};
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
l:      for(int test=1;test<=T;test++) {
		StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            char[][] arr=new char[M][N];
            Queue<int[]> Q=new LinkedList<>();
            int ans=0,x=0,y=0;
            for(int i=0;i<M;i++) {
            	arr[i]=br.readLine().toCharArray();
                for(int j=0;j<N;j++) {
                    if(arr[i][j] == '*') Q.add(new int[]{i,j});
                    else if(arr[i][j] == '@'){ x=i; y=j;}
                }
            }
            Q.add(new int[]{x,y});
            while(!Q.isEmpty()){
                ans++;
                for(int i=0,size=Q.size();i<size;i++){
                    int[] now=Q.poll();
                    for(int j=0;j<4;j++){
                        int dx=now[0] + xx[j],dy=now[1] + yy[j];
                        if(dx<0 || dx>=M || dy<0 || dy>=N) {
                            if(arr[now[0]][now[1]] == '@') {
                                System.out.println(ans);
                               continue l;
                            }
                            continue;
                        }
                        if(arr[dx][dy] != '.') continue;
                        arr[dx][dy]=arr[now[0]][now[1]];
                        Q.add(new int[]{dx,dy});
                    }
                }
            }
            System.out.println("IMPOSSIBLE");
        }
    }
}
