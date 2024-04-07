import java.io.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[][] dy = new int[N+1][40001];
		String[] in1 = br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			arr[i]= Integer.parseInt(in1[i-1]);
		}
		dy[0][0]=1;
		for(int i=1;i<=N;i++) {
			dy[i][0]=1;
			for(int j=0;j<=40000;j++) {
				if(dy[i-1][j]==1) {
					dy[i][j]=1;
					dy[i][Math.abs(arr[i]-j)] = 1;
					if(arr[i]+j<=40000) dy[i][arr[i]+j]=1;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		in1 = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			String t=(dy[N][Integer.parseInt(in1[i])]==1)?"Y":"N";
			bw.write(t+" ");
		}
		bw.close();
	}
}
