import java.util.*;
public class q9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dy = new int[11];
		dy[1]=1; dy[2]=2; dy[3]=4;
		for(int i=4;i<=10;i++) dy[i]=dy[i-3]+dy[i-2]+dy[i-1];
		int T=sc.nextInt();
		for(int te=1;te<=T;te++) System.out.println(dy[sc.nextInt()]);
	}
}
