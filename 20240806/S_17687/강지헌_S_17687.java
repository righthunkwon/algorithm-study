import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
		List<Character> arr = new ArrayList<Character>();
		arr.add('0');
        for(int i=1;arr.size()<t*m;i++) {
            int j=i;
            String s = "";
			while (j!=0) {
				int mod=j%n;
				s =(char)(mod>=10?'A'+mod-10:'0'+mod)+s;
				j = j / n;
			}
			for (char c : s.toCharArray()) arr.add(c);
        }
		for (int i = p-1; answer.length() < t; i += m) answer += arr.get(i);
		return answer;  
    }
}
