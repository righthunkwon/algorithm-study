import java.util.Scanner;

public class BOJ_Q1747_소수_팰린드롬 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean [] notPrime = new boolean[1003002]; //1000000보다 큰 첫 펠린드롬 소수 : 1003001
		notPrime[1]=true; //n이 1일수도 있어서..
		for(int i=2;i<1415;i++) {
			if(!notPrime[i]) {
				int tmp = i+i;
				while(tmp<1003002) {
					notPrime[tmp]=true;
					tmp+=i;
				}
			}
		}
		
		for(int i=n;i<1003002;i++) { //n보다 크거나 같은 수 중
			if(!notPrime[i]&&isPelindrom(i)) { //소수이고 펠린드롬이면 출력
				System.out.println(i);
				return;
			}
		}

	}
	
	//펠린드롬인지 확인하는 메서드
	static boolean isPelindrom(int a) {
		String str = a+"";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String reverse = sb.toString();
		if(str.equals(reverse)) {
			return true;
		}
		return false;
	}

}
