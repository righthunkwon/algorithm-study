
import java.io.*;
import java.util.*;

public class Pro_2831_댄스파티 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> boyTgirl = new ArrayList<Integer>();
		List<Integer> boyLgirl = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			if (h > 0)
				boyTgirl.add(h);
			else
				boyLgirl.add(-h);
		}
		List<Integer> girlTboy = new ArrayList<Integer>();
		List<Integer> girlLboy = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			if (h > 0)
				girlTboy.add(h);
			else
				girlLboy.add(-h);
		} // 입력 끝
		int cnt = 0;
		// 여자 음수+ 남자 양수(여자가 남자보다 커야함)
		Collections.sort(girlLboy);
		Collections.sort(boyTgirl);
		int b = 0;
		int g = 0;
		while (b < boyTgirl.size() && g < girlLboy.size()) {
			if (girlLboy.get(g) > boyTgirl.get(b)) {
				cnt++;
				g++;b++;
			} else {
				g++;
			}
		}
		// 여자 양수+ 남자 음수(남자가 여자보다 커야함)
		Collections.sort(girlTboy);
		Collections.sort(boyLgirl);
		b = 0;
		g = 0;
		while (b < boyLgirl.size() && g < girlTboy.size()) {
			if (boyLgirl.get(b) > girlTboy.get(g)) {
				cnt++;
				g++;b++;
			} else {
				b++;
			}
		}
		System.out.println(cnt);
	}
}
