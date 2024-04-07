import java.io.*;
public class Main {
	static char[][] map;
	static String ans="";
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		for(int i=1;i<=N;i++) map[i]=("0"+br.readLine()).toCharArray();
		dfs(1,1,N);
		System.out.println(ans);
	}
	private static void dfs(int sx, int sy, int le) {
		char chk=map[sx][sy];
		if(le==1) {
			ans+=Character.toString(chk);
			return;
		}
		for(int i=sx;i<sx+le;i++) {
			for(int j=sy;j<sy+le;j++) {
				if(map[i][j]!=chk) {
					ans+="(";
					dfs(sx,sy,le/2);
					dfs(sx,sy+le/2,le/2);
					dfs(sx+le/2,sy,le/2);
					dfs(sx+le/2,sy+le/2,le/2);
					ans+=")";
					return;
				}
			}
		}
		ans+=Character.toString(chk);
		return;
	}
}
