package _20231108;

import java.util.Scanner;

public class _1105_팔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long L = sc.nextLong();
		long R = sc.nextLong();
		int ans=0;
		int Lsize = (int)Math.log10(L)+1; // L 자릿수를 구한다
		int Rsize = (int)Math.log10(R)+1; // R 자릿수를 구한다

		while(Rsize > 0) { // 오른쪽 수의 자릿수가 0보다 클 동안 while문 반복한다
			// 밑에서 변동이 생기는 경우가 있으므로 한번 더 자릿수를 계산해준다
			Lsize = (int)Math.log10(L)+1; //L 자릿수
			Rsize = (int)Math.log10(R)+1; //R 자릿수
			
			// L과 R의 자릿수가 같을 때
			if(Lsize == Rsize) {
				
				// 한 자리 숫자라면 둘 다 8인 경우에 ans를 증가시켜 주고, while문을 나간다
				if(Lsize==1) {
					if(L==8 && R==8) {
						ans++; break;
					}else {
						break;						
					}
				}
				// L과 R이 자릿수가 같지만 한 자리 수가 아니라면

				// 맨 앞자리 수가 둘 다 8인지를 고려하고, 맞다면 ans를 증가시킨다.
				// 그리고 맨 앞자리 수를 버리고 나머지 수로 L과 R을 바꿔준다.
				// 만일 L이 0이 된다면 더 이상 반복할 이유가 없으므로 나간다.
				else if(L/(int)(Math.pow(10, Lsize-1))==8 && R/(int)(Math.pow(10, Rsize-1))==8) {
					ans++;
//					System.out.println("여기");
					L = L%(int)(Math.pow(10, Lsize-1));
					R = R%(int)(Math.pow(10, Rsize-1));
					if(L==0) break;
				}else {
					// 둘 다 8인 경우가 아니라면 8없이 수를 만들 수 있으므로
					// 맨 앞자리 수를 버리고 나머지 수로 L과 R을 바꿔준다. 
					// 만일 L이 0이 된다면 더 이상 반복할 이유가 없으므로 나간다.
					L = L%(int)(Math.pow(10, Lsize-1));
					R = R%(int)(Math.pow(10, Rsize-1));
					if(L==0) break;
					
				}

			}
			// L과 R의 자릿수가 다르다면 8을 이용하지 않고도 수를 만들 수 있으므로 그대로  while문을 나간다.
			else if(Lsize != Rsize) {
				break;
			}

		}
		// 구해진 답을 출력한다.
		System.out.println(ans);
	}//main

}
