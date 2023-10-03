import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _27979_볼링장아르바이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int W[] = new int [N];
		int sW[] = new int [N];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			W[i]=Integer.parseInt(s[i]);
			sW[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(sW);
		// 결국 이동해야 하는 최소 이동 횟수를 구하는 것은
		// sW 배열과 순서가 일치하지 않는 것의 개수를 세면 된다
		int idx = 0;
		for(int i=N-1;i>=1;i--) {
			for(int j=0;j<N;j++) {
				if(sW[i]==W[j]) idx=j;
				
			}
		}
		
		
		
	}//main

}
