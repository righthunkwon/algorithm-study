
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	
		// 1차원 배열이라 생각하자
		// 가장 높은 높이를 기준으로 
		// 각 끝부터 나오는 높이를 시작으로 
		// 그보다 큰 값이 나오면 갱신해주면서 최고값이 나오면
		// 반대 index에서부터 시작
		int[][] tmp = new int[N][2];
		int maxi =0; // 등장하는 최대 배열 index
		int max=0; // 최대값 -- 안써도 ㄱㅊ
		int maxindex = 0;// 최대값일때의 index
		for(int i =0;i<N;i++) { 
			tmp[i][0] = sc.nextInt();
			if(tmp[i][0]>maxi) {
				maxi = tmp[i][0];
			} // maxi+1만큼 배열만들기 위해서  구함
			tmp[i][1] = sc.nextInt();	
			if(tmp[i][1] >max) {
				max= tmp[i][1]; // 전체배열에서의 최고높이
				maxindex = tmp[i][0]; // 최고높이일때의 index
			}
		}

		int[] arr = new int[maxi+1];
		for(int i =0;i<N;i++) {
			arr[tmp[i][0]] = tmp[i][1];
		}
		int sum = 0; // 정답 넓이
		int num=0; // 진행중인 과정에서의 최대 값 
		int i =0; // 시작 index = 0부터시작			
		while(true) {
			if(num<arr[i]) {
				num = arr[i];
			}
			sum+=num;			
			i++;
			// l은 1이상이기 때문에 0일때 고려하지 않아도 괜찮 
			// 0이라고려하면 최고값이 0에 있을때 고려해야함
			if(i==maxindex) {
				break;
			}
		}
		num = 0; // num은 0으로 초기화
		i = maxi; // 끝에서부터
		while(true) {
			if(num<arr[i]) {
				num = arr[i];
			}
			sum+= num;
			i--;
			if(i==maxindex-1) {
				break;
			}
			
		}
		System.out.println(sum);


	}



}
