class Solution {
    static int [][]answer;
    static int idx;
    public int[][] solution(int n) {
        //n=2 -> 3 / n=3 -> 3 1 3 / n=4 -> 7 1 7 / n=5 -> 15 1 15 .. n -> 2^n -1
        answer = new int[(int)Math.pow(2,n)-1][2];
        idx=0;
        hanoi(n,1,3,2);
        return answer;
    }
    public static void hanoi(int depth,int from,int to,int mid){
        if(depth==0){
            return;
        }
        hanoi(depth-1,from,mid,to);
        answer[idx][0]=from;
        answer[idx][1]=to;
        idx++;
        hanoi(depth-1,mid,to,from);
    }  
}
