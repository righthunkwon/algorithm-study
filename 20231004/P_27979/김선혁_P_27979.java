import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	// 입력되는 것들중
	// 오름차순에서 예외인 것들 중
	// 오름차순에서 제외되는 숫자들 중
	// 가장 큰 숫자보다 작은 숫자들의 개수
	// 2 7 6 10 4에서 보면
	// 7 10 이 순서로 이루어지고
	// 어긋나는 숫자는 6, 6이하는 3개 
	
	// 일단 뒤에서부터
	// 오름차순으로 정렬한 후 
	// 큰수에서 내림차순으로 가는 숫자의 개수를
	// 제외하고는 전부 개수 세야함
	int[] arr = new int[N];
	int[] arr2 = new int[N];
	for(int i =0;i<N;i++) {
		arr[i] = sc.nextInt();
		arr2[i] = arr[i];
	}	
	// 입력끝
	// 일단 arr2 정렬
	Arrays.sort(arr2);
	int cnt = 0;
	int index = N-1; // 이제 여기서부터 체크할거임
	for(int i =N-1;i>=0;i--) {
		if(arr[i] == arr2[index]) {
			cnt++;
			index--;
		}
		// 같은숫자나오면 cnt++
	}
	System.out.println(N-cnt);
	
	
}

}
