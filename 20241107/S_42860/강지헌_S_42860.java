import java.util.*;
class Solution {
    public int solution(String name) {
        int ans=0, x, j=name.length()-1;
        for(int i=0;i<name.length();i++) {
            ans+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            x=i+1;
            while(x<name.length() && name.charAt(x) == 'A') x++;
            j=Math.min(j, i*2+name.length()-x);
            j=Math.min(j, (name.length()-x)*2 + i);
        }
        return ans+j;
    }
}
