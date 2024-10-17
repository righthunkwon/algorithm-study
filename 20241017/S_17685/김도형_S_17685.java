import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Arrays.sort(words);//사전 순으로 정렬
        int[] cnt = new int[words.length]; //해당 단어 찾을 때 필요한 글자 수 저장
        
        for(int i=0;i<words.length-1;i++){
            String now = words[i];
            String next = words[i+1];
            int overlap = same(now,next);
            
            //now가 next에 모두 포함될 경우 now 다 입력해야 검색가능
            if(overlap==Math.min(now.length(),next.length())){
                cnt[i]=Math.max(cnt[i],overlap);
            }else{ //모두 포함되지 않는 경우에는 겹치는 부분+1까지 입력해야됨
                cnt[i]=Math.max(cnt[i],overlap+1);
            }//다음 단어의 경우 이전 단어와 겹치는 문자 수 +1
            cnt[i+1]=overlap+1;
        }
        
        //입력해야 할 전체 문자 수 계산
        for(int i=0;i<words.length;i++){
            answer+=cnt[i];
        }
        
        return answer;
    }
    
    //두 단어 중복되는 문자 수 카운트(앞에서부터)
    public int same(String a,String b){
        
        int shortLen = Math.min(a.length(),b.length()); //둘중 짧은 단어 길이
        int cnt = 0;
        
        for(int i=0;i<shortLen;i++){
            if(a.charAt(i)==b.charAt(i)){
                cnt++;
            }else break;
        }

        return cnt;
    }
}
