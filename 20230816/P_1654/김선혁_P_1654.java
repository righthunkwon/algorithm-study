import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();			
		int	N = sc.nextInt();
		long[] arr =new long[K];
		long sum=0;
		for(int i=0;i<K;i++) {
			arr[i] = sc.nextInt();
			sum+= arr[i];
		}
		
		Arrays.sort(arr);

		long maxindex=arr[arr.length-1];
		long minindex=1;
		long middle = 0;
		while(true) {			
			long nsum=0;
			long[] count = new long[K];
			middle = (maxindex+minindex)/2;
			for(int i=0;i<K;i++) {
				count[i] = arr[i]/middle;				
				nsum += count[i];
			}

			if(nsum>= N) {
				minindex = middle+1;
			}
			else {
				maxindex=middle-1;
			}
			
			if(minindex>maxindex) {
				middle =maxindex;
				break;
			}			
		}
		System.out.println(middle);
	}
}
