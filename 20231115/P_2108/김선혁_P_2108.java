import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// -가 있는 와중에 4000을 넘지 않으니깐
		// 입력되는 모든 수에 4000을 더해서 저장해버리자
		int[] arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt()+4000;			
		}
		// 1. N개의 수들의 합을 N으로 나눈 값
		// 일단 수들 다 더해서 -4000하기
		double sum = 0;
		for(int i = 0;i<N;i++) {
			sum += arr[i]-4000;
		}
		// N으로 나눈값을 출력 ㄱㄱ -> 소수첫번째 자리까지 ==round함수		
		System.out.println(Math.round(sum/N));
		
		
		// 2 .중앙값  -> 정렬해서 가운데 있는 수 출력
		int[] tmp = arr;
		Arrays.sort(tmp);
		System.out.println(tmp[N/2]-4000);
		
		
		// 3. 최빈값 -> 8001개의 배열을 생성해서 arr의 값에 해당하는
		// 배열에 +1해줘서 개수가 가장 많은 수 구함
		int[] arr2 = new int[8001];
		for(int i=0;i<N;i++) {
			arr2[arr[i]]++;
		}
		// 개수 set 끝 이제 count 가자
		int max = 1;
		ArrayList<Integer> ar = new ArrayList<>();
		for(int i =0;i<arr2.length;i++) {
			if(arr2[i] > max) {
				ar = new ArrayList<>();
				ar.add(i);
				max = arr2[i];
				// 리스트를 재선언한다.(기존값 제거)
				// 리스트에 추가하고 max값 교체
			}
			else if(arr2[i] == max){
				// 같으면 리스트에 추가만한다.
				ar.add(i);
			}			
		}
		// 만약 한개면 그냥 출력, 여러개면 정렬 후 2번째 값만 출력
		if(ar.size()==1) {
			System.out.println(ar.get(0)-4000);
		}
		else {
			Collections.sort(ar);
			System.out.println(ar.get(1)-4000);
		}
		
		
		// 4.최대값과 최소값 차이
		// 아까 정렬한 tmp에서 0번째와 N-1번째 수의 차이를 구하면 됨!
		System.out.println(tmp[N-1]-tmp[0]);
	}
}
