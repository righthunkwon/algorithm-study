import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N 입력받기
		
		int tmp=0; // 임시 변수
		boolean flag =false;
		
		// 최대한 N에서 뺼수 있는 3의배수를 구함 3의 tmp거듭제곱만큼	
		while(true) {
			if(N==0) {
				tmp=-1;
				break;
			}
			if(N >=Math.pow(3,tmp)) {
				tmp++;
			}		
			if(N<Math.pow(3,tmp)) {
				tmp--;
				break;
			}
		} // 현재 3의 tmp제곱값이 N값에 가장가까운 작은 수 
		while(true) {
			if(tmp==-1) {
				break;
			}
			// N이 현재 3의 tmp제곱값 이상이면
			// N에서 3의배수를 뺴가면서
			// N이 0이 될때까지  계속 반복
			if(N>=Math.pow(3,tmp)) {
				N-=Math.pow(3,tmp);
			}
			// N이 0이라는 뜻은 삼삼한 수라는 뜻
			// flag를 true로 바꿔주고 break
			if(N==0) {
				flag =true;
				break;
			}
			// tmp가 0이 됬다는 뜻은
			// N은 0이 아니며 삼삼한수가
			// 아니라는 뜻!
			if(tmp==0) {
				break;
			}
			tmp--;
		}
		// flag가 true면 YES 출력
		if(flag) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		
		
		
		
		
	}
}
