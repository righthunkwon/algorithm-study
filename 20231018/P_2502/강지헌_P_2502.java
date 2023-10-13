import java.util.*;

public class q2502 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dy = new int[30];
		dy[0]=1; dy[1]=1;
		for(int i=2;i<30;i++) dy[i]=dy[i-2]+dy[i-1];
		int a=sc.nextInt();
		int b=sc.nextInt();
		for(int i=1;;i++) {
			int t=b-dy[a-3]*i;
			if(t%dy[a-2]==0) {
				System.out.println(i+"\n"+t/dy[a-2]);
				return;
			}
		}
	}
}
