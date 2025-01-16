import java.util.Scanner;

public class BOJ_G5_3933_라그랑주의_네_제곱수_정리 {
	public static void main(String[] args) {
  
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0)break;
			int cnt = 0;
			for(int i=1;i<=183;i++) { //2^15 보다 작은수니까 최대 182까지 해보면 됨
				if(i*i>=n) {
					if(i*i==n)cnt++;
					break; //i*i가 n과 크거나같으면 그 뒤는 n보다 커지니까 끝
				}
				for(int j=i;j<=183;j++) {
					if(i*i+j*j>=n) {
						if(i*i+j*j==n)cnt++;
						break;
					}
					for(int k=j;k<=183;k++) {
						if(i*i+j*j+k*k>=n) {
							if(i*i+j*j+k*k==n)cnt++;
							break;
						}
						for(int l=k;l<=183;l++) {
							if(i*i+j*j+k*k+l*l>=n) {
								if(i*i+j*j+k*k+l*l==n)cnt++;
								break;
							}
						}//l
					}//l
				}//j
			}//i
			System.out.println(cnt);
		}//while
	}
}
