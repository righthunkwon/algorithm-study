import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N =sc.nextInt();
		int[] arr = new int[N];
		int num = sc.nextInt();
		int mNum= sc.nextInt();
		int pencil = num*mNum; // 필요한 총 개수
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
	
		int count=0;
		int index=N-1;
		while(true) {			
			pencil -= arr[index];
			count++;
			if(index==0 && pencil>0) {
				System.out.println("STRESS");				
			break;
			}
			if(pencil<=0) {
				System.out.println(count);
			break;
			}
			
			index--;
			
		}
	
	
		
	}
}
