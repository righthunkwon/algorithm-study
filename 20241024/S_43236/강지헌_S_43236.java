import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int[] arr=new int[rocks.length+2];
        for(int i=0; i<rocks.length; i++) arr[i+2]=rocks[i];
        arr[0]=0; arr[1]=distance;
        Arrays.sort(arr);
        int answer=0, s=0, e=distance, m, cnt, st;
        boolean f;
        while(s<=e) {
            m=(s+e)/2; cnt=0; st=0; f=false;
            for(int i=1; i<arr.length; i++) {
                if(arr[i]-st<m) {
                    if(cnt<n) {
                        cnt++;
                        continue;
                    }
                    else {
                        e=m-1;
                        f=true;
                        break;
                    }
                }
                st=arr[i];
            }
            if(!f) {
                answer=m;
                s=m+1;
            }
        }
        return answer;
    }
}
