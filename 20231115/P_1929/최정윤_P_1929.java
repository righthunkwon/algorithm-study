
import java.util.Scanner;

// 한개씩 소수인지 판별하면 시간초과 문제 발생
// 시간복잡도 :  O(N)

//에라토스테네스의 체 사용하여 소수 아닌 것 미리 걸러내기
// 시간복잡도 : O(Nlog(logN))
public class Pro_1929_소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] notPrime = new boolean[N + 1];
		//소수인지 아닌지 저장해놓는 배열
		//소수라면 false 소수가 아니라면 true
		notPrime[1] = true;//1은 소수가 아니다 
		
		//2부터 돌아서 소수라면 그의 배수들 다 소수 X 처리해놓기
		//앞부터 돌기 때문에 본인 숫자 나올때까지 배열이 false라면 약수가 없다는 소리니까 소수라는 뜻
		for (int i = 2; i <= N; i++) {
			if (notPrime[i])
				continue;
			else {//소수라면 나의 배수들 모두 notPrime=true 처리
				for (int j = i * 2; j <= N; j += i) {
					notPrime[j] = true;
				}
			}
		}
		for (int i = M; i <= N; i++) {//M부터 N까지의 수 중에 false인 것 수 세기
			if (!notPrime[i])
				System.out.println(i);
		}
	}

}
