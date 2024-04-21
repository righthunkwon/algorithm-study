class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int t=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]=='(') t++;
            else t--;
            if(t<0) return false;
        }
        if(t==0) return true;
        return false;
    }
}
