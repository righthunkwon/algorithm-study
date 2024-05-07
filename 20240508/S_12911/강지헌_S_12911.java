class Solution {
    public int solution(int n) {
        int t = Integer.bitCount(n);
	    for(int i=n+1;;i++) if(t == Integer.bitCount(i)) return i;
    }
}
