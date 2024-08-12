import java.util.*;
class Solution {
    public int solution(int[] citations) {
		    int N=citations.length;
		    Integer[] arr=new Integer[N];
		    for (int i = 0; i < N; i++) arr[i]=citations[i];
		    int answer=0;
		    Arrays.sort(arr,(o1,o2)->o2-o1);
    		while(answer<N){
    			if(arr[answer]<=answer) break;
    			answer++;
    		}
        return answer;
    }
}
