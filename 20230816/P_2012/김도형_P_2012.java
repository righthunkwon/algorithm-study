import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
		
		int N = Integer.parseInt(br.readLine()); //
		
		int []arr = new int[N];
		
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		long cnt = 0;
		for(int i=0;i<N;i++) {
			if(arr[i]<i+1) {
				cnt+=i+1-arr[i];
			}else
				cnt+=arr[i]-i-1;
		}
		
		System.out.println(cnt);
		
		
	}

}
