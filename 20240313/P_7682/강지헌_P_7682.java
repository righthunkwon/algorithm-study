import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
			String s = br.readLine();
			if (s.equals("end")) break;
			int xr = 0, xc = 0, or = 0, oc = 0, ox = 0, xx = 0, x = 0, o = 0;
			char[][] map = new char[3][3];
			for (int i = 0; i < 3; i++) {
				map[i] = s.substring(i, i + 3).toCharArray();
				for (int j = 0; j < 3; j++) {
					if (map[i][j] == 'X') x++;
					else if (map[i][j] == 'O') o++;
				}
			}
			if (Math.abs(x - o) > 1 || o > x) {
				System.out.println("invalid");
				continue;
			}
			
			int t5 = 0, t6 = 0, t7 = 0, t8 = 0;
			for (int i = 0; i < 3; i++) {
				if (map[i][i] == 'X') t5++;
				else if (map[i][i] == 'O') t6++;
				if (map[2 - i][i] == 'X') t7++;
				else if (map[2 - i][i] == 'O') t8++;
				int t1 = 0, t2 = 0, t3 = 0, t4 = 0;
				for (int j = 0; j < 3; j++) {
					if (map[i][j] == 'X') t1++;
					else if (map[i][j] == 'O') t2++;
					if (map[j][i] == 'X') t3++;
					else if (map[j][i] == 'O') t4++;
				}
				if (t2 == 3) or++;
				else if (t1 == 3) xr++;
				else if (t3 == 3) xc++;
				else if (t4 == 3) oc++;
			}
			if (t5 == 3) xx++;
			if (t6 == 3) ox++;
			if (t7 == 3) xx++;
			if (t8 == 3) ox++;
			
			if (xr > 1 || xc > 1 || or > 1 || oc > 1) {
				System.out.println("invalid");
				continue;
			}
			if (x == o) {
				if ((xr > 0 || xc > 0 || xx > 0)) {
					System.out.println("invalid");
					continue;
				}
			} else {
				if (or > 0 || oc > 0 || ox > 0) {
					System.out.println("invalid");
					continue;
				}
			}
			if (x + o == 9) {
				System.out.println("valid");
				continue;
			}
			if (xr + xc + or + oc + ox + xx == 0) {
				System.out.println("invalid");
				continue;
			}
			System.out.println("valid");
		}
	}
}
