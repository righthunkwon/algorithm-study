import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1부터 일단 최대 높은 숫자까지
		// 다 값을 +1씩 값을 넣어놓자
		 N = sc.nextInt();
		 arr = new int[N];
		 int max =0;
		 for(int i =0;i<N;i++) {
			 max = Math.max(max, arr[i] = sc.nextInt());
		 }
		 // 입력 끝
		 //해당 숫자가 있는지 flag로 판단을 하고
		 //있으면 ans 배열에서 그 숫자의 배수가 있을때마다
		 // 해당 수는 +1, 그 배수는 -1을 해줌
		 boolean[] flag = new boolean[max+1];
		 int[] ans = new int[max+1]; // 100001로 크기 설정해도 상관 x
		 for(int i =0;i<N;i++) {
			 // 있는 숫자들은 true처리 해줌
			 flag[arr[i]] = true;
		 }
		 
		 for(int i=0;i<N;i++) {
			 // 이건 arr배열에서 시작
			 // ans배열에서는 arr[i]의 2배부터 arr[i]가 증가하는
			 // 크기만큼만 확인하면됨
			 for(int j = arr[i]*2;j<max+1;j+=arr[i]) {
				 if(flag[j]) {
					 // 해당수는 +1, 배수는 -1
					 ans[arr[i]] ++;
					 ans[j] --;
				 }
			 }
		 } // i for
		 for(int i =0;i<N;i++) {
			 if(flag[arr[i]]) {
				 System.out.print(ans[arr[i]]+" ");
			 }
		 }
		 
		 
	}
	
}

