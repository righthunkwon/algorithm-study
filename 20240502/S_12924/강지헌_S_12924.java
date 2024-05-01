class Solution {
    public String solution(String s) {
        String answer = "";
        char[] t = s.toCharArray();
        if(t[0]>='a' && t[0]<='z') t[0]-=32;
        for(int i=1;i<t.length;i++) {
            if(t[i]==' ' && i!=t.length-1 && t[i+1]>='a' && t[i+1]<='z') t[i+1]-=32;
            else if(t[i-1]!=' ' && t[i]>='A' && t[i]<='Z') t[i]+=32;
        }
        for(int i=0;i<t.length;i++) answer+=t[i];
        return answer;
    }
}
