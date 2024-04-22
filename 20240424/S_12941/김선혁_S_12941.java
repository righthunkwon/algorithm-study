import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // 최소값 만드려면 가장큰수가 가장작은수랑 곱해져야함 
        // --> 둘다 정렬하고 거꾸로 서로 곱해서 더함(둘다 자연수)
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0;i<A.length;i++){
            answer += (A[i] * B[B.length-1-i]);
        }
        
        return answer;
    }
}
