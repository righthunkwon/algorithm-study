import java.util.*;

public class BOJ_Q1074_Z {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int a = 1;
		for(int i=0;i<N;i++) {
			a = a*2;
		}
		int ans = 0;
		int x = a/2; //x=4
		int y = a/2; //y=4
		while(x>0||y>0) {
			if(r>=x) {//위아래 반으로 나눠서 아래쪽이면
				r=r-x;
				ans+= Math.pow(2,2*N-1);
			}
			if(c>=y) {//오른쪽,왼쪽 반으로 나눴을 때 오른쪽이면
				c=c-y;
				ans+= Math.pow(2,2*N-2);
			}
			x/=2;
			y/=2;
			N--;
		}
		System.out.println(ans);
	}
}
