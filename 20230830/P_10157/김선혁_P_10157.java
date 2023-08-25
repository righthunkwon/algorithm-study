import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {		
		Scanner sc=  new Scanner(System.in);

		int C = sc.nextInt();
		int R = sc.nextInt();
		int ans= sc.nextInt();
		int[][] arr = new int[R+1][C+1];

		int[] dx = {-1,0,1,0,};
		int[] dy = {0,1,0,-1};
		int in = 0;
		int x = R;
		int y =1;
		int ansx =0;
		int ansy=0;
		for(int i=1;i<=R*C;i++) {
			arr[x][y] = i;
			if(i==ans) {
				ansx=x;
				ansy=y;
				break;
			}
			x+= dx[in];
			y+= dy[in];
			if(x<1 || x>R || y<1 || y>C || arr[x][y] !=0) {
				x-=dx[in];
				y-=dy[in];
				in++;
				if(in==4) {
					in=0;
				}
				x+=dx[in];
				y+=dy[in];				
			}
			
		}
		if(ansx ==0) {
			System.out.println(0);
		}
		else {
		System.out.println(ansy+" "+(R-(ansx-1)));
		}

	}
}
