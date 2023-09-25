import java.io.*;
public class q1342 {
	static char[] arr;
	static int ans;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		arr=br.readLine().toCharArray();
		chk=new boolean[arr.length];
		dfs(0,' ');
		System.out.println(ans);
	}

	private static void dfs(int x, char c) {
		boolean[] c2=new boolean[26]; //중복 제거용 배열
		if(x==arr.length) {
			ans++;
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!chk[i] && !c2[arr[i]-'a'] && arr[i]!=c) { //이미 들어갔던 문자는 넣지 않는다(c2), 이미 들어간 위치는 다시 넣지 않는다(chk) 전에 쓴문자와 똑같으면 넣지않는다(arr[i])
				chk[i]=true; c2[arr[i]-'a']=true;
				dfs(x+1,arr[i]);
				chk[i]=false;
			}
		}
	}
}
