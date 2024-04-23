import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
        
        while(st.hasMoreTokens()) {
        	int a = Integer.parseInt(st.nextToken());
        	min = Math.min(min,a);
        	max = Math.max(max, a);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        String ans = sb.toString();
        return ans;
    }
}
