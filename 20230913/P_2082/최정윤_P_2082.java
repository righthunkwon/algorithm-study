package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Pro_2082_시계 {
	public static void main(String[] args) throws IOException {
		char[][] h1 = new char[5][3];
		char[][] h2 = new char[5][3];
		char[][] m1 = new char[5][3];
		char[][] m2 = new char[5][3];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h1[i] = st.nextToken().toCharArray();
			h2[i] = st.nextToken().toCharArray();
			m1[i] = st.nextToken().toCharArray();
			m2[i] = st.nextToken().toCharArray();
		} // 입력끝

		char[][] zero = { { '#', '#', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '.', '#' },
				{ '#', '#', '#' } };
		char[][] one = { { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' },
				{ '.', '.', '#' } };
		char[][] two = { { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '#', '.', '.' },
				{ '#', '#', '#' } };
		char[][] three = { { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' },
				{ '#', '#', '#' } };
		char[][] four = { { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' },
				{ '.', '.', '#' } };
		char[][] five = { { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '.', '.', '#' },
				{ '#', '#', '#' } };
		char[][] six = { { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '#', '.', '#' },
				{ '#', '#', '#' } };
		char[][] seven = { { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' },
				{ '.', '.', '#' } };
		char[][] eight = { { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '#', '.', '#' },
				{ '#', '#', '#' } };
		char[][] nine = { { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' },
				{ '#', '#', '#' } };
		list = new ArrayList<>();
		list.add(zero);
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		list.add(six);
		list.add(seven);
		list.add(eight);
		list.add(nine);
		
		
		
		num(h1);
		num(h2);
		System.out.print(":");
		num(m1);
		num(m2);
		System.out.println();

	}

	public static List<char[][]> list;

	public static void num(char[][] arr) {
		for (int i = 0; i < list.size(); i++) {
			char[][] arr2 = list.get(i);
			boolean time = true;
			here: for (int a = 0; a < 5; a++) {
				for (int b = 0; b < 3; b++) {
					if (arr2[a][b] == '.' && arr[a][b] == '#') {//숫자는 .인데 이미 켜져있는것 break;
						time = false;
						break here;
					}
				}
			}
			if (time) {
				System.out.print(i);
				return;
			}
		}
		return;
	}
}
