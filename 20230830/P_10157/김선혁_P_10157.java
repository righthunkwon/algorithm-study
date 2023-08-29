import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);
		// 자리배정 실버4  10157번
		
		// R개의 높이 , C개의 가로길이를 가진 크기를 만듬
		// 1부터시작하는 것이 편하기 때문에 +1
		// 4방향으로 가는 dx dy 배열을 만들어 
		// index에 따라서 상->우->하->좌 순으로 이동
		int C = sc.nextInt();
		int R = sc.nextInt();
		int ans= sc.nextInt();
		int[][] arr = new int[R+1][C+1];
		
		int[] dx = {-1,0,1,0,};
		int[] dy = {0,1,0,-1};
		int in = 0; // dx dy의 index
		int x = R;  // 좌표를 좌측위를 0,0으로 시작하기 때문에 높이 좌표를 R로 잡음
		int y =1; // 가로 좌표는 1로 시작
		int ansx =0; // 정답 x좌표
		int ansy=0; //  정답 y좌표
		for(int i=1;i<=R*C;i++) { // 1부터 R*C까지
			arr[x][y] = i; // i에 해당하는 값을 좌표에 대입
			// 만약 i가 찾는 수를 만날 경우
			// x좌표와 y좌표를 입력한 후 break
			if(i==ans) {
				ansx=x;
				ansy=y;
				break;
			}
			// x와 y좌표를 각각 dx의 index만큼
			// 무한적으로 이동
			x+= dx[in];
			y+= dy[in];
			// 이동하는 과정중 범위를 벗어나거나 0이 아닌수를 만나면
			// in을 +1하여 회전한다.
			if(x<1 || x>R || y<1 || y>C || arr[x][y] !=0) {
				// 회전하기 전에 움직였던 한번만큼
				// 다시 뒤로가고 in++한 후 
				// 다시 움직임
				x-=dx[in];
				y-=dy[in];
				in++;
				// in++과정 중에
				// 움직이는 범위는 0에서 3으로
				// 4가되면 in은 0으로 초기화
				if(in==4) {
					in=0;
				}
				x+=dx[in];
				y+=dy[in];				
			}
			
		}
		// 없는 수이면 0을 출력
		if(ansx ==0) {
			System.out.println(0);
		}
		else {
		// ansy와 ansx 순으로 출력하는데
		// 세로의 좌표는 좌측밑에서부터 1로 시작하기때문에
		// R에서 ansx-1을 뺀 값을 출력
		System.out.println(ansy+" "+(R-(ansx-1)));
		}

	}
}
