import java.util.Scanner;

public class _2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][]= new int [100][100];
		int N = sc.nextInt();// 색종이의 수
		for(int tc=1;tc<=N;tc++) {
			int a = sc.nextInt();// 색종이 왼쪽 변과 왼쪽 변 사이의 거리
			int b = sc.nextInt();// 색종이 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
			// 색종이 한쪽 변의 크기가 10이므로 그만큼 색종이가 붙는다
			for(int i=a;i<a+10;i++) {
				for(int j=b;j<b+10;j++) {
					//색종이를 붙일 때 0인 자리는 tc번째 붙인 종이라면  tc+1 숫자로 바꾼다(1 사용하지 않기 위해)
					if(arr[i][j]==0) arr[i][j]=tc+1;
					//이미 숫자가 있다면 종이가 겹쳐서 붙는 것이므로 1로 바꾼다
					if(arr[i][j]!=0) arr[i][j]=1;
				}
			}

		}//T번 반복
		//전체 색종이를 훑으면서 1이면 겹치는 부분이므로 카운트를 한다
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
	}//main

}
