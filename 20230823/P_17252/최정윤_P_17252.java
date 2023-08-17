import java.io.*;

public class Problem_17252 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		// 삼삼한 수는 3으로 나눴을 때 3의 배수 이거나 3의 배수+1만 삼삼한 수가 가능하다
		// 3으로 묶었을 때 3의 0제곱 빼고는 묶일 수 있기 때문에
		//ex) 109= 1+108 =1+3(3(3(1+3)))
		String result = "YES";//일단 YES가정
		if(N==0) result="NO";//0일 때는 따로 NO지정 N=0이면 나누기 3하면 안되기 때문에 while 문 안에 못넣음
		
		while (N>0) {
			if (N % 3 == 2) {//나머지 2이면 NO하고 break
				result = "NO";
				break;
			}
			else if (N % 3 == 1) {//나머지 1이면 -1먼저하고
				N = N - 1;
			}
			N = N / 3;//나누기 3하고 다시 반복
		}
		
		System.out.println(result);
	}
}
