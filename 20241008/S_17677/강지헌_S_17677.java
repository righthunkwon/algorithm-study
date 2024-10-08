import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		List<String> list1 = new ArrayList<String>(), list2 = new ArrayList<String>();
		for(int i=0; i<str1.length()-1; i++) {
			if(str1.substring(i, i+2).matches("^[a-z]*$")) list1.add(str1.substring(i, i+2));
		}
		for(int i=0; i<str2.length()-1; i++) {
			if(str2.substring(i, i+2).matches("^[a-z]*$")) list2.add(str2.substring(i, i+2));
		}
        if(list1.size() == 0 && list2.size() == 0) return 65536;
		int t=0;
		for(int i=0; i<list1.size(); i++) {
			String s = list1.get(i);
			if(list2.contains(s)) {
				list1.remove(s);
				list2.remove(s);
				t++; i--;
			}
		}
	    return (int)((double)t/(t+list1.size()+list2.size())*65536);
    }
}
