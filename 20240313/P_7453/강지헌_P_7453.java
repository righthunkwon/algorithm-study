import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		int[] a = new int[N*N], b = new int[N*N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				a[i*N+j]=arr[i][0]+arr[j][1];
				b[i*N+j]=arr[i][2]+arr[j][3];
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);

		int fi=0,se=N*N-1;
		long ans=0;
		while(fi<N*N && se>=0) {
			int sum=a[fi]+b[se];
			if(sum<0) fi++;
			else if(sum>0) se--;
			else {
				int c1=1,c2=1;
				while (fi+c1<N*N && a[fi] == a[fi + c1]) ++c1;
				while (se-c2 >= 0 && b[se] == b[se - c2]) ++c2;
				ans+=(long)c1*c2;
				fi+=c1;
				se-=c2;
			}
		}
		System.out.println(ans);
	}
}
