import java.util.*;
class Solution {
	static String[] d;
	static HashMap<Character, Integer> map;
	static boolean[] vi;
	static int[] ch;
	static int ans;
	public int solution(int n, String[] data) {
		d = data;
		map = new HashMap<>();
		vi = new boolean[8];
		ch = new int[8];
		ans = 0;
		map.put('A', 0); map.put('C', 1); map.put('F', 2); map.put('J', 3); map.put('M', 4); map.put('N', 5); map.put('R', 6); map.put('T', 7);
		dfs(0);
		return ans;
	}

	public static void dfs(int t) {
		if (t==8 && ch()) ans++;
        else if(t!=8){
			for (int i = 0; i < 8; i++) {
				if (!vi[i]) {
					vi[i] = true; ch[t] = i;
					dfs(t + 1);
					vi[i] = false;
				}
			}
		}
	}
	public static boolean ch() {
		int a,b,c;
		char o;
		for (String s : d) {
			a = ch[map.get(s.charAt(0))]; b = ch[map.get(s.charAt(2))]; o = s.charAt(3);
			c = s.charAt(4)-'0'+1;
			if (o == '=') {
				if (Math.abs(a-b) != c) return false;
			} else if (o == '>') {
				if (Math.abs(a-b) <= c) return false;
			} else {
				if (Math.abs(a-b) >= c) return false;
			}
		}
		return true;
	}
}
