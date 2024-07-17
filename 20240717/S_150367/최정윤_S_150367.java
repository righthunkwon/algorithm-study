import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {

        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            str=Long.toBinaryString(numbers[i]);
            //1,3,7,15
            int cnt=cal(str.length());
            int count=cnt-str.length();
            for(int j=0;j<count;j++){
                str="0"+str;
            }

            //가운데부터 1돌면서 2로 바꾸고 남아있는 1 있다면 표현할 수 없는 것
            dfs(cnt/2,cnt);
            if(!str.contains("1")) answer[i]=1;
        }
        return answer;
    }
    public static void dfs(int idx,int cnt){
        if(cnt==0||idx<0||idx>=str.length()) return;
        if(str.charAt(idx)=='1'){
            str=str.substring(0,idx)+"2"+str.substring(idx+1);
            dfs(idx-cnt/2+cnt/4,cnt/2);
            dfs(idx+cnt/2-cnt/4,cnt/2);
        }
    }
    static String str;
    public static int cal(long length){
        if(length==1) return 1;
        int cnt=1;
        int j=1;
        while(true){
            cnt+=2*j;
            j*=2;
            if(cnt-length>=0) return cnt;
        }
    }
    
}
