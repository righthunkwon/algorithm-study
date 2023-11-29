import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		// 이문제는 +, -만 가지고 하고
		// 가장 작은수가 나오려면
		// 큰수를 빼면됨 
		
		// 일단 나오는수 쭉 더하다가
		// -가 나오는순간부터는
		// 따로 더해서 최대수가 나오도록
		int sum = 0; // 더하는수
		int sub = 0; // 빼는수
		String N = sc.next(); 
		String num = "";
		a : for(int i =0;i<N.length();i++) {
			String tmp = N.substring(i,i+1);
			// tmp는 N잘라서 숫자인지 확인
			if(tmp.equals("+")) {
				sum += Integer.parseInt(num);
				// 숫자만큼 더함
				num = "";
				// 초기화
//				System.out.println(sum+" !!");
			}
			else if(tmp.equals("-")) {
				// 일단 앞에숫자는 sum에다가 더해놓고 초기화
				sum += Integer.parseInt(num);
				num = "";
//				System.out.println(sum);
				// 이제 나머지 숫자를 더해보자
				// - 다음부터 숫자를 다더하자
				for(int j=i+1;j<N.length();j++) {
					 tmp = N.substring(j,j+1);
					if(tmp.equals("+") || tmp.equals("-")) {
						sum -= Integer.parseInt(num);
						num= "";
						continue;
					}
					// 부호가 아니라면 다 더하자
					num += tmp;
				}
				sum -= Integer.parseInt(num);
				num ="";
				break a; // -이후로 다 더하는게 끝나면 전체 break
			}
			else {
				 num += tmp;
			}
		}
		if(!num.equals("")) {
			sum += Integer.parseInt(num);
		}
		// 마지막까지 -가 없을 경우 다 더해야해서
		System.out.println(sum);
		
		
	}

	

	


}
