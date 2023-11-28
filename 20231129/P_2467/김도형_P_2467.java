package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q2467_용액 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 용액의 수 N
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}//입력끝
		
		//양 끝에서 시작해서 왼쪽에서 하나를 이동했을 때와 오른쪽에서 하나를 이동했을 때의 합을 비교해
		//0에 더 가까운 곳으로 이동해가면서 0에 가장 가까운 값이 갱신될때마다 그 left,right 값을 저장해준다!
		
		int left = 0;
		int right = N-1;
		int minLeftValue = arr[0];
		int minRightValue = arr[N-1];
		int min = Math.abs(arr[0]+arr[N-1]);
		
		while(left<right) {
			
			int leftmove = Math.abs(arr[left+1]+arr[right]); //왼쪽 이동했을 경우 특성값
			int rightmove = Math.abs(arr[left]+arr[right-1]); //오른쪽 이동했을 경우 특성값
			
			if(leftmove<rightmove) {//왼쪽이동이 더 0에 가까울 경우
				left++;//왼쪽꺼 한칸 이동
//				System.out.println("leftmove to:"+left+", right:"+ right);
				if(min>leftmove && left!=right) { //갱신여부 확인, left right 같은 경우는 갱신X
					minLeftValue = arr[left];
					minRightValue = arr[right];
					min = leftmove;
				}
			}else {
				right--;
//				System.out.println("rightmove to:"+right+", left:"+ left);
				if(min>rightmove && left!=right) { //갱신여부 확인, left right 같은 경우는 갱신X
					minRightValue = arr[right];
					minLeftValue = arr[left];
					min = rightmove;
				}
			}
			
		}//while
		System.out.println(minLeftValue+" "+minRightValue);

	}//main
}
