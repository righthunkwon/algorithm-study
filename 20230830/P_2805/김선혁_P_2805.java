import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
//		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));	
		Scanner sc=  new Scanner(System.in);
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M =Integer.parseInt(st.nextToken());
		int N = sc.nextInt(); // 나무 개수
		int M = sc.nextInt(); // 만들어야하는 길이
		long[] arr = new long[N]; // 배열
//		st = new StringTokenizer(br.readLine());		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr); // 정렬
		long middle =0; // 중간값
		long maxi = arr[N-1]; // 가장큰 나무 길이를 maxi로
		long mini = 0; // mini는 0으로
		long len = 0; // 자른 후 모은 나무길이
		while(true) {
			len=0; 
			middle = (maxi+mini)/2; // middle 값은 maxi+mini를 2로나눈값
			for(int i=0;i<N;i++) {
				long tmp = arr[i] - middle; // tmp에서 middle값 뺀것이 양수일 때에만 더함
				if(tmp>0) {
					len+=tmp;
				}
			}
			if(len == M) { // M이랑 len이 같으면 break
				break;
			}			
			if(len>M) { // 자른길이가 더 크면 적게 잘라도 되므로 mini를 middle+1로
				mini=middle+1;
			}
			else if(len<M) { // 자른길이가 더 적으면 더 많이 잘라야하므로 maxi를 middle-1로
				maxi=middle-1;
			}
			// 같을 경우 반례때문에
			// mini가 maxi보다 큰 경우만 
			if(mini>maxi) {
				middle = maxi;
				break;
			}
			
		}
		System.out.println(middle);

	}
}
