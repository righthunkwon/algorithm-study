import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static long[] arr;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new long[N];
    	for(int i =0;i<N;i++) {
    		arr[i] = sc.nextInt();
    	}
    	long max = sc.nextLong();
    	// 약간 이거 
    	// 일단 정렬해가지고 
    	// 허용되는 숫자랑 넘는숫자 두개가지고
    	// 이분탐색 하는 느낌
    	
    	// 일단 정렬
    	Arrays.sort(arr);
    	// 정렬해서 일단 더하다가 안넘는 범위랑 
    	// 넘어가는 범위를 구해보자 
    	long lo = 0;
    	long hi = arr[N-1];
    	// 2분탐색으로 적절한 수를 구해보자
    	long middle = 0;
    	while(true) {
    		// lo와 hi는 각각 0과 최대수로 정해놓고
    		// middle은 2개의 가운데로 설정한다.
    		middle = (lo + hi)/2;
    		// long범위로 sum을 선언하고
    		// middle보다 적으면 해당 배열의 숫자를,
    		// middle보다 큰수는 middle을 더해서
    		// sum과 max를 비교한다.
    		long sum = 0;
    		for(int i =0;i<N;i++) {
    			long tmp = Math.min(arr[i], middle);
    			sum += tmp;
    		} 
//    		System.out.println(sum+" "+middle);
    		// 만약 같으면 그대로 break
    		if(sum == max) {
    			break;
    		}
    		// sum이 크다면 middle이 줄어야하기 때문에
    		// hi를 middle-1로 설정
    		else if(sum>max) {
    			hi = middle-1;
    		}
    		// sum이 적은경우는 middle이 커져야 하므로
    		// lo를 middle+1로 설정
    		else {
    			lo = middle +1;
    		}
    		// 마지막에 lo가 hi보다 높은경우는
    		// hi의 점수가 결과를 나타내므로 
    		// middle을 hi로 설정하고 break
    		if(lo>hi) {
    			middle = hi;
    			break;
    		}
    		
    	}
    	
    	System.out.println(middle);
    	
    	
    }
}
