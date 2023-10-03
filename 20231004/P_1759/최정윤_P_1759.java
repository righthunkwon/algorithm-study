
import java.io.*;
import java.util.*;
//무조건 조건에 부합하게 만들어지게 짜는 코딩을 했습니다.
//모든 조합 다 만든 다음에 조건에 부합하는 것만 선택하는 방법이 더 좋은 것 같은..!
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
		alpa = new ArrayList<Character>();
		aeiou = new ArrayList<Character>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			Character a = st.nextToken().toCharArray()[0];
			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
				aeiou.add(a);
			} else {
				alpa.add(a);
			}
		} // 입력끝

		select = new char[L];
		set = new HashSet<String>();
		for (int i = 1; i <= L - 2; i++) {
			cnt = i;
			select(0, 0, 0, 0);
		}
		List<String> list = new ArrayList<String>(set);

		Collections.sort(list);
		for (String select : list) {
			sb.append(select + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void select(int sidx, int count, int ae, int al) {
		if (sidx == L) {
			char[] key = new char[L];
			key = select.clone();
			Arrays.sort(key);
			String key2 = "";
			for (char a : key) {
				key2 += a;
			}
			set.add(key2);
			return;
		}

		if (ae >= aeiou.size() && al >= alpa.size())
			return;

		if (count < cnt && ae < aeiou.size()) {
			select[sidx] = aeiou.get(ae);
			select(sidx + 1, count + 1, ae + 1, al);
			select(sidx, count, ae + 1, al);
		}
		if (L - sidx > cnt - count && al < alpa.size()) {
			select[sidx] = alpa.get(al);
			select(sidx + 1, count, ae, al + 1);
			select(sidx, count, ae, al + 1);
		}

	}
}
