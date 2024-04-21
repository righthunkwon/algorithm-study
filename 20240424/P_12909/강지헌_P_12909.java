class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(String t : arr) {
            int n = Integer.parseInt(t);
            max = Math.max(n,max);
            min = Math.min(n,min);
        }
        return min+" "+max;
    }
}
