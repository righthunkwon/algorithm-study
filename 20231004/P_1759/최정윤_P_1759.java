package baek;

import java.io.*;
import java.util.*;

//무조건 조건에 부합하게 만들어지게 짜는 코딩을 했습니다.
//모든 조합 다 만든 다음에 조건에 부합하는 것만 선택하는 방법이 더 좋은 것 같은..!


//만든 순서 
//1. 모음의 수가 1개인 것 부터 L-2개 인 것 까지 조합을 만들기 : L개의 문자 암호 만들기
//2. set에 넣고 중복 없앤 후 sort하여 알파벳 순서대로 뽑기
public class Pro_1759_암호만들기 {
	static int cnt;
	static int L;
	static char[] select;
	static List<Character> alpa;
	static List<Character> aeiou;
	static StringBuilder sb;
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		int C = Integer.parseInt(st.nextToken());
		// 입력받을 때부터 자음과 모음 분리
		alpa = new ArrayList<Character>();// 자음
		aeiou = new ArrayList<Character>();// 모음
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			Character a = st.nextToken().toCharArray()[0];
			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
				aeiou.add(a);
			} else {
				alpa.add(a);
			}
		} // 입력끝

		select = new char[L];// L개의 암호를 선택하는 배열
		set = new HashSet<String>();

		for (int i = 1; i <= L - 2; i++) {
			cnt = i; // 모음의 수 1개 이상 L-2개 이하 : 자음이 2개 이상이여야하니까
			select(0, 0, 0, 0);//모음이 i개인 조합 만드는 메소드
		}

		List<String> list = new ArrayList<String>(set);

		Collections.sort(list);
		for (String select : list) {
			sb.append(select + "\n");
		}
		System.out.println(sb.toString());
	}
   
	public static void select(int sidx, int count, int ae, int al) {// 선택한 글자수, 여태까지 선택한 모음수, 모음인덱스, 자음인덱스
		if (sidx == L) {// 암호가 만들어졌다면
			char[] key = new char[L];
			key = select.clone(); // clone을 한 이유: select를 넣어버리면 주소값이 복사되어서 sort하면 select도 sort가 되어짐
								  // 아직 재귀 진행중이라서 select가 sort될 경우 정답이 바뀌게 된다.
			Arrays.sort(key); // 알파벳순으로 정렬한 뒤
			String key2 = "";
			for (char a : key) {
				key2 += a;
			}
			set.add(key2);// set에 넣는다. 중복된 암호 없애기 위해서
			return;
		}

		if (ae >= aeiou.size() && al >= alpa.size())
			return;

		if (count < cnt && ae < aeiou.size()) { //모음 고르기 : 아직 모음 수가 채워지지 않았을 때 
			select[sidx] = aeiou.get(ae);//현재 모음 고르고 select배열에 담기
			select(sidx + 1, count + 1, ae + 1, al);//현재 모음 고른것 
			select(sidx, count, ae + 1, al);//현재 모음 고르지 않고 다음 모음 보는 것
		}
		if (L - sidx > cnt - count && al < alpa.size()) {//자음고르기 : 자음만 골라지는 것을 방지하기 위해 앞 조건문 
			select[sidx] = alpa.get(al);
			select(sidx + 1, count, ae, al + 1);//현재 자음 고르기
			select(sidx, count, ae, al + 1);//현재 자음 고르지않고 다음 자음으로 넘어가는 것
		}

	}
}
