import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N],ans=new long[3];
		long min=9999999999L;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			int s=0,e=N-1;
			while(s<e) {
				if(i==s) { s++; continue; }
				if(i==e) { e--; continue; }
				if(Math.abs(arr[s]+arr[e]+arr[i])<min) {min=Math.abs(arr[s]+arr[e]+arr[i]); ans[0]=arr[s]; ans[1]=arr[e]; ans[2]=arr[i];}
				if(arr[s]+arr[e]+arr[i]<0) s++;
				else e--;
			}
		}
		Arrays.sort(ans);
		System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
	}
}
