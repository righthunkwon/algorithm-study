import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		// n개의 수가 입력되면
		// 일단 정렬을 한후에 그 안에서
		// for문을 통해
		// 숫자 하나를 골라서 그 숫자의 합이
		// 만들어지는지 이분탐색을 통해 index로 계산
		int ans =0; // 정답 개수
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 정렬

		// 이제 i번째 수가 합이 되는지 판단
		for(int i =0;i<N;i++) {
			int num = arr[i];
			int left = 0;
			int right = N-1;
			int sum = 0;
			// 목표 수를 num에 저장
			while(true) {
				sum = arr[left]+arr[right];
				if(num == sum) {
					// 정답 찾으면 left랑 right가 i가
					// 아닌걸 확인하고 ans++
					if(left != i && right != i) {
						ans ++;
						break;
					}
					// 같은경우 만약 두개가 같다면 break 되야하지만
					// left가 같으면 left++하고 반대는 right--(음수때매?)
					if(left == i) {
						left++;
					}
					else {
						right --;
					}
//					System.out.println(left+" "+right+" "+i+" "+num);
				}
				// sum이 더 작으면 
				// sum이 더 커지게 left를 높임
				else if(num>sum) {
					left ++;
				}
				else {
					// 반대의 경우는 right 줄임
					right --;
				}
				// 중간에 left가 더 커지면 break
				if(left>=right) {
					break;
				}
			}
		} // for
		System.out.println(ans);

	}
}
