import java.util.Arrays;
public class Solution {
    public int solution(String[] words) {
        Arrays.sort(words);
        String pre="";
        int answer=0,preCnt=1,preSimilar=0;
        for(String cur : words) {
            int sameCnt=0;
            boolean isSimilar=false;
            for(int i=0;i<pre.length();i++) {
                if(pre.charAt(i)==cur.charAt(i)) {
                    sameCnt++;
                    isSimilar=true;
                }
                else break;
            }
            if(isSimilar && sameCnt>=preSimilar) {
                answer -= preCnt;
                if(pre.length()>sameCnt) answer+=(sameCnt+1);
                else answer+=(sameCnt);
                answer+=(preCnt=sameCnt+1);
            }
            else answer+=(preCnt=sameCnt+1);
            pre=cur;
            preSimilar=sameCnt;
        }
        return answer;
    }
}
