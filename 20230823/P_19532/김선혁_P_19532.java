import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 수학은 비대면강의 입니다. 19532번 브론즈2
		// 연립방정식 푸는거 -- 수학시간에 많이했음
		//	ax+by=c 
		//	dx+ey=f
		// 저는 a와 d를 맞춘후에
		// 위에항에서 밑에항을 빼겠습니다.
		
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
