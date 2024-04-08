import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] n = br.readLine().toCharArray();
		char[][] arr = {br.readLine().toCharArray(),br.readLine().toCharArray()};
		int ans=0;
		for(int i=0;i<2;i++) {
			int[][] dy = new int[n.length+1][arr[0].length+1];
			Arrays.fill(dy[0],1);
			for(int j=1;j<=n.length;j++) {
				char[] s = arr[(j-i) & 1];
				for(int k=1;k<=s.length;k++) {
					dy[j][k]=dy[j][k-1]+(n[j-1]==s[k-1]?dy[j-1][k-1]:0);
				}
			}
			ans+=dy[n.length][arr[0].length];
		}
		System.out.println(ans);
	}
}
