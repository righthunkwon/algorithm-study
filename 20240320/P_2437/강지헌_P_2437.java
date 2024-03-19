import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		if(arr[0]>1) { System.out.println(1); return; }
		for(int i=1;i<N;i++) {
			if(arr[i-1]+1<arr[i]) { System.out.println(arr[i-1]+1); return; }
			arr[i]=arr[i-1]+arr[i];
		}
		System.out.println(arr[N-1]+1);
	}
}
