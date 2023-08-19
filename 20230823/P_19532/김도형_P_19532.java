import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
    
		
		for(int x = -999; x<=999 ; x++ ) {
			for(int y=-999; y<=999 ; y++) {   //범위 입력
				
				if(a*x+b*y==c && d*x+e*y==f)   //2차방정식 조건 작성
					System.out.println(x+" "+y);  //정답 출력
				
			}
						
		}
			
	}//main
	
}
