import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int	N = sc.nextInt(); 			
		int M = sc.nextInt();
		
		String[][] arr = new String[N][M];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = tmp.substring(j,j+1);
			}
		}
		
		int cnt =0;
		int min = 10000;
		
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				cnt=0;
				for(int k=0;k<8;k++) {
					for(int l=0;l<8;l+=2) {
						if((i+k)%2==0) {
							if(arr[i+k][j+l].equals("W")){
								cnt++;
							}
							if(arr[i+k][j+l+1].equals("B")) {
								cnt++;
							}
						}
						else {
							if(arr[i+k][j+l].equals("B")){
								cnt++;
							}
							if(arr[i+k][j+l+1].equals("W")) {
								cnt++;
							}
						}
					}
				}		
				if(cnt>32) {
					cnt=64-cnt;
				}
				if(min>cnt) {
					min =cnt;
				}
				
				
			}
		}
		System.out.println(min);
		
		
		
		
	}
}
