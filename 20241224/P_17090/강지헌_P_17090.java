import java.util.Scanner;
public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new char[n][m];
        visited=new boolean[n][m];
        for(int i=0;i<n;i++) map[i]=sc.next().toCharArray();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) if(dfs(i,j)) count++;
        }
        System.out.println(count);
    }

    public static boolean dfs(int y,int x){
        boolean result=false;
        if(0>x || 0>y || y>=n || x>=m || map[y][x]=='T') return true;
        if(map[y][x]=='F') return false;
        if(visited[y][x]) return false;
        visited[y][x]=true;
        if(map[y][x]=='U') result=dfs(y-1,x);
        else if(map[y][x]=='R') result=dfs(y,x+1);
        else if(map[y][x]=='L') result=dfs(y,x-1);
        else if(map[y][x]=='D') result=dfs(y+1,x);
        map[y][x]=result?'T':'F';
        return result;
    }
}
