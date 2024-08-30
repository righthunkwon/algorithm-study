import java.io.*;
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        //길이 3~10, words 수 50 그냥 완탐 ,,,
        visited=new boolean[words.length];
        this.target=target;
        this.words=words;
        answer=Integer.MAX_VALUE;
        dfs(begin,0);
        if(answer==Integer.MAX_VALUE) return 0;
        return answer;
    }
    public static void dfs(String word,int depth){
        if(depth>=answer) return;
        if(word.equals(target)){
            answer=Math.min(depth,answer);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;
            int diff=0;
            for(int j=0;j<target.length();j++){ //알파벳 한개만 다른지 체크
                if(words[i].charAt(j)!=word.charAt(j)) diff++;
                if(diff>=2) break;
            }
            if(diff==1){ 
                visited[i]=true;
                dfs(words[i],depth+1);
                visited[i]=false;
            }
        }
    }
    static boolean[] visited;
    static String[] words;
    static String target;
    static int answer;
}
