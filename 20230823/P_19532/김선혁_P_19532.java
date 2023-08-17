import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 6개 입력받아서 a랑 d 맞춰주기
		int a = sc.nextInt(); // a 입력받기
		int b = sc.nextInt(); // b 입력받기
		int c = sc.nextInt(); // c 입력받기
		int d = sc.nextInt(); // d 입력받기
		int e = sc.nextInt(); // e 입력받기
		int f = sc.nextInt(); // f 입력받기
		int ans1=0; // x값
		int ans2=0; // y값
		if(a==0) { // a가 0일경우 b를이용해 y를 먼저구함
			ans2 =c/b;
			ans1 =(f-ans2*e)/d;
		}
		else if(d==0) { // d가 0일경우 e를 이용해 y를 먼저구함
			ans1 = f/e;
			ans2 = (c-ans1*b)/a;
		}
		// 두개다 0일경우에는 x의 값이 유일하지 않기 때문에 
		// 0인 경우는 가능하다면 a와 d중에 하나일 수 밖에 없다
		else { //a와 d를 맞춰준 후에 나머지 항의 차이를 통해 y를 먼저 구함
			int tmp = a; // a에 d를 곱하면 a가 변하기때문에
			// a를 임시변수 tmp에 저장하여줌
			a*=d;
			b*=d;
			c*=d;
			d*=tmp;
			e*=tmp;
			f*=tmp; // 위항은 d로, 밑항은 a로 곱해주기

			int N = b-e; // y를 먼저 구하기 위해 위항에서 아래항 빼기
			int M = c-f;


			ans2 = M/N; // y의 값

			ans1 = (c-b*ans2)/a; // x의 값 --> c에서 b*y값을 빼고 이 전체를 a로 나눠줌
		}
		System.out.println(ans1+" "+ans2);

	}
}
