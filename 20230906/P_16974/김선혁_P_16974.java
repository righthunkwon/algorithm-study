    import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {	

	static int N;
	static long x;
//	static long cnt;
	static long[] count;
	static long[] meat;
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		x=  sc.nextLong();
		count = new long[N+1];
		 meat = new long[N+1];
		count[0] = 1;
		meat[0] = 1;		
		for(int i=1;i<=N;i++) {
			count[i] = count[i-1]*2+3;
			meat[i] = meat[i-1]*2+1;			
		}


		long cnt = stack(N,x);
		
		//		for(int i =0;i<arr.size();i++) {
		//			System.out.print(arr.get(i));			
		//		}
		//		

		System.out.println(cnt);

	}
	public static long stack(int num,long x) {
		if(num==0) {
			if(x==0) {
				return 0;				
			}
			if(x==1) {
//				cnt++;
				return 1;
			}
		}
		if(x==1) {
			return 0;
		}
		else if( x <= 1+count[num-1] ) return stack( num-1, x-1 );

		//x가 중간패티의 위치라면 이전 패티수+1을 반환
		else if( x == 1+count[num-1]+1 ) return meat[num-1]+1;

		//x가 중간패티 위치보다 크면 
		else if( x <= 1+count[num-1]+1+count[num-1] ) return meat[num-1]+1+stack( num-1, x-(1+count[num-1]+1) );

		//x가 현재 레밸 재료수의 크기와 같다면 현재 레밸의 패티수를 반환
		else return meat[num-1]+1+meat[num-1];


