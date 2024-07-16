import java.util.*;
public class Solution {
    static boolean[] chk;
    static HashSet<String> set;
	public static int solution(String[] userid, String[] banid) {
        chk = new boolean[userid.length];
        set = new HashSet<String>();
        for(int i=0; i<banid.length; i++) banid[i] = banid[i].replace('*', '.');
        dfs(0,"",banid,userid);
		return set.size();
	}
	public static void dfs(int t, String d, String[] b, String[] u) {
		if(t==b.length) {
			String[] arr = d.split(" ");
			Arrays.sort(arr);
			String str="";
			for(String s:arr) str+=s;
			set.add(str);
			return;
		}
		for(int i=0; i<u.length; i++) {
			if(chk[i] || !u[i].matches(b[t])) continue;			
			chk[i]=true; dfs(t+1,u[i]+" "+d,b,u); chk[i]=false;
		}
	}
}
