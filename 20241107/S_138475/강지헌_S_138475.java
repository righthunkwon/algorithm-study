import java.util.*;
class Solution {
    public int[] solution(int e,int[] starts) {
        int[] c=new int[e+1];
        Arrays.fill(c,1);
        for(int i=2;i<=e;i++) {
            for(int j=1;j*i<=e;j++) c[i*j]++;
        }
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<starts.length;i++) list.add(new int[]{i,starts[i]});
        list.sort((o1,o2)->o2[1]-o1[1]);
        int end=e,max=1,v=e;
        int[] answer=new int[starts.length];
        for(int i=0;i<starts.length;i++) {
            int[] t=list.get(i);
            for(int j=end;j>=t[1];j--) {
                if(c[j]>=max){
                    max=c[j];
                    v=j;
                }
            }
            end=t[1];
            answer[t[0]]=v;
        }
        return answer;
    }
}
