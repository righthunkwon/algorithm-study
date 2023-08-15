import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int a= n/5;
		int c5=0;
		int c3=0;
	
		int tmp=n;
		for(int i=a;i>=0;i--) {
			tmp=n-5*i;
			if(tmp%3==0) {
				c5=i;
				c3=tmp/3;
				System.out.println(c5+c3);
				break;
			}
			if(i==0) {
				System.out.println(-1);
				break;
			}
		}
		
	}
}
