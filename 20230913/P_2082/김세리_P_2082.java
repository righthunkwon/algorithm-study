package _20230913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2082_시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] zero = "####.##.##.####".toCharArray();
		char[] one = "..#..#..#..#..#".toCharArray();
		char[] two = "###..#####..###".toCharArray();
		char[] three = "###..####..####".toCharArray();
		char[] four = "#.##.####..#..#".toCharArray();
		char[] five = "####..###..####".toCharArray();
		char[] six = "####..####.####".toCharArray();
		char[] seven = "###..#..#..#..#".toCharArray();
		char[] eight = "####.#####.####".toCharArray();
		char[] nine = "####.####..####".toCharArray();
		
		char[][] digit = new char[][] {
			zero, one, two, three, four, five, six, seven, eight, nine
		};
		
		System.out.println(Arrays.deepToString(digit));
		String input[] =new String[] {"","","",""};
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 필요한 부분을 잘라서 input에 합쳐서 저장하는 방식으로
			// 위에 숫자와 같은 형식의 문자로 저장한다
			String temp1 = st.nextToken();
			String temp2 = st.nextToken();
			String temp3 = st.nextToken();
			String temp4 = st.nextToken();
			input[0] += temp1;
			input[1] += temp2;
			input[2] += temp3;
			input[3] += temp4;
			
		}
		//위에서 저장한 입력값을 char로 변형하고, 비교가 용이하게 myclock 배열에 넣는다
		char[][] myClock = new char[4][15];
		for(int i=0;i<4;i++) {
			myClock[i] = input[i].toCharArray();
		}

		//내 시계에 나타난 숫자를 char로 저장한 배열(myClock)과 숫자를 char로 표현한 배열(digit)을 비교한다
		int k;
		
		//요기 밑에 이해 못함ㅠ0ㅠ
		for(int i=0;i<4;i++) {
			for(int j=0;j<10;j++) {
				for(k=0;k<15;k++) {
					if(myClock[i][k]=='#' && digit[j][k]=='.') break;
				}
				
				if(k==15) {
					System.out.print(j);
					break;
				}
			}
			if(i==1) System.out.print(":");
		}
		
		
		
	}//main

}
