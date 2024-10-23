import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        //총 경우의 수: n!
        long total = 1;
        for(int i=1;i<=n;i++)
        {
            list.add(i); //리스트에 1~n 까지 담아두기
            total *= i;
        }
        //배열 인덱스 0부터 시작하니까
        k--;
        
        int idx = 0;
        while(idx < n)
        {
            //총 경우의 수/남은 자릿수
            total /= n - idx;
            //리스트에서 k/total 번째 숫자가 들어가면 됨!
            int num = list.remove((int)(k/total));
            answer[idx++] = num;
            //다음 찾아야될 번호
            k %= total;
        }
        return answer;
    }
}



//그냥 dfs 돌렸더니 시간초과..
class Solution {
    static int idx;
    static int[] answer;
    static boolean[] visit;
    public int[] solution(int n, long k) {
        answer = new int[n];
        visit = new boolean[n];
        dfs(0,new int[n],n,k);
        return answer;
    }
    public static void dfs(int depth,int[]arr,int n,long k){
        if(depth==n){
            idx++;
            if(idx==k){
                for(int i=0;i<arr.length;i++)answer[i]=arr[i];
            }
            return;
        }  
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth]=i+1;
                dfs(depth+1,arr,n,k);
                visit[i]=false;                
            }
        }
    }
}
