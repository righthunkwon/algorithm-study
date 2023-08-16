import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 랜선 자르기  1654
		// https://www.acmicpc.net/problem/1654
		// 현재 K개의 전선을 가지고 있는데 이 전선을 이용하여
		// N개의 전선을 만들어야함 --> 기존의 전선을 잘라서, 붙이지는 못함
		// 먼저 전선을 모두 입력받은 후 
		// 최소 index와 최고 index를 구하여 
		// 이분탐색을 통해 중간값을 찾아감 
		// 최소가 최고index보다 커지는 시점 middle이 정답
		
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();	// 현재 가지고 있는 전선 K개
		int	N = sc.nextInt();	// 만들어야 하는 전선 개수
		long[] arr =new long[K]; // 입력받은 K개의 전선 길이 배열로 저장		
		for(int i=0;i<K;i++) {
			arr[i] = sc.nextInt();			
		}
		// 전선 정렬
		Arrays.sort(arr);
		// 최고index의 경우 정렬했을 때 가장큰값을 기준으로 잡고
		// 최소 index의 경우에는 1로잡음 (처음에 0으로 잡음)
		// 중간 값은 임시로 0으로 잡음
		long maxindex=arr[arr.length-1];
		long minindex=1;
		long middle = 0;
		// 무한루프를 통해
		// nsum이라는 자른 전선의 합을 선언,
		// K개 만큼의 전선개수를 넣은 배열은 임시로 만들어주고
		// 각 K의 길이에서 middle값을 나눈 개수를 count 배열 i위치에 저장하여주고
		// 그 count의 전체적인 합 nsum값을 구함
		while(true) {			
			long nsum=0; //전선개수 합
			long[] count = new long[K];
			middle = (maxindex+minindex)/2;
			for(int i=0;i<K;i++) {
				count[i] = arr[i]/middle;				
				nsum += count[i];
			}
			// nsum의 개수가 N보다 크다면
			// 현재 middle값이 최적의 middle값보다 적다는 뜻이므로
			// 최소index를 현재 기준잡은 middle값보다 1큰값으로 수정			
			if(nsum>= N) {
				minindex = middle+1;
			}
			// nsum이 N보다 적다면 
			// 현재 middle값이 크다는 것이기 때문에
			// middle값을 줄이고자 maxindex값을 middle값보다 1적은 값으로 수정
			else {
				maxindex=middle-1;
			}
			// 만약 최적의 middle값이 구해지면
			// 즉, middle값보다 1큰 값이 정해지면 N개보다 적어지고 
			// 현재 middle값으로 만들었을 때 N개가 만들어지는 값
			// 이 값이 middle값으로 잡히게 되면 nsum>=N에 속해
			// minindex가 middle+1로 maxindex보다 큰 값이 정해진다.
			// 이럴 경우 break
			if(minindex>maxindex) {
				middle =maxindex;
				break;
			}			
		}
		System.out.println(middle);
	}
}
