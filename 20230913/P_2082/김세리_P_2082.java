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
		for(int i=0;i<4;i++) {
			for(int j=0;j<10;j++) {
				for(k=0;k<15;k++) {
					// 켜지지 않은 발광다이오드가 켜지는 경우는 없다고 문제에서 했으므로
					// 이러한 경우에는 무조건 해당 숫자가 될 수 없음을 알 수 있다
					// 숫자를 앞에서부터 훑으므로 안되는 숫자를 제외하고 가장 빠른 숫자가 추측 가능한 수이다
					if(myClock[i][k]=='#' && digit[j][k]=='.') break;
				}
				// k가 15일 때 해당 숫자의 배열 끝까지 훑었을 때이다
				// 켜지지 않는 발광다이오드가 켜지는 경우가 없다고 판단된 수 이다
				// 이때 숫자는 j이므로 j를 출력한다
				if(k==15) {
					System.out.print(j);
					break;
				}
			}
			//시계 형식으로 출력되어야 하므로 1이 끝난 후에 :가 출력되어야한다
			if(i==1) System.out.print(":");
		}
		
		
		
	}//main

}
