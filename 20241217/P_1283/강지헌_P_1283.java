import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		Set<Character> set=new HashSet<>();
		ArrayList<String> list=new ArrayList<>();
		boolean flag=false;
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			flag=false;
			while(st.hasMoreTokens()) {
				String str=st.nextToken();
				if(flag) bw.write(str+" ");
				else if(!set.contains(Character.toUpperCase(str.charAt(0)))) {
					set.add(Character.toUpperCase(str.charAt(0)));
					str="["+str.charAt(0)+"]"+str.substring(1,str.length());
					if(!list.isEmpty()) {
						for(int j=0;j<list.size();j++) bw.write(list.get(j)+" ");
						list.clear();
					}
					bw.write(str+" ");
					flag=true;
				}
				else list.add(str);
			}
			if(!flag) {
				for(int j=0;j<list.size();j++) {
					String str=list.get(j);
					if(!flag) {
						for(int k=0;k<str.length();k++) {
							if(!set.contains(Character.toUpperCase(str.charAt(k)))) {
								set.add(Character.toUpperCase(str.charAt(k)));
								str=str.substring(0,k)+"["+str.charAt(k)+"]"+str.substring(k+1,str.length());
								flag=true;
								break;
							}
						}
					}
					bw.write(str+" ");
				}
			}
			list.clear();
			bw.write("\n");
		}
		bw.flush();
	}
}
