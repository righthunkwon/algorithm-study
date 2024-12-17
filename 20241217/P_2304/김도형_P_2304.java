import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1<= N <=1000
		int []arr = new int [1001];
		for(int i = 0 ; i<N ; i++) {
			int L = sc.nextInt();  // 위치 (1~1000)
			int H = sc.nextInt();  // 높이 (1_1000)
			arr[L]=H;
		}
		
		int ans = 0 ; //정답(가장 작은 창고 다각형 면적)들어갈 변수
		
		//가장 높은 기둥 찾기
		int top = 0;
		int topIdx = 0;
		
		for(int i=0;i<1001;i++) {
			if(arr[i]>top) {
				top=arr[i];  //가장 높은 기둥 높이
				topIdx=i;    //가장 높은 기둥 위치(index)
			}
		}

		//가장 높은 기둥 기준으로 왼쪽 넓이 (0~ top기둥 전까지 탐색)
		//처음보다 더 높은 기둥 나올때마다 면적 더해줘야..

		//왼쪽 탐색
		int leftStart = 0; //시작점(높이 0 초기화)
		int leftSpace = 0; //넓이 누적
		for(int i=0;i<=topIdx;i++) {
			if(arr[i]>=arr[leftStart]) {
				leftSpace+=(i-leftStart)*arr[leftStart];
				leftStart=i;
			}	
		}
		
		//오른쪽 탐색
		int rightStart = 0; //시작점(높이 0 초기화)
		int rightSpace = 0; //넓이 누적
		for(int i=1000;i>=topIdx;i--) {
			if(arr[i]>=arr[rightStart]) {
				rightSpace+=(rightStart-i)*arr[rightStart];
				rightStart=i;
			}	
		}
		ans = top + leftSpace + rightSpace;
		System.out.println(ans);
	}
}
