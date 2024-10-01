class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        //이분탐색으로 필요한 금,은 다 옮기는 최소 시간 구하기
        long r = 400000000000000L;
        long l = 0;
        
        while(l + 1 < r) {
            long m = (l + r) / (long)2;
            if (isPossible(m, a, b, g, s, w, t)) r = m;
            else l = m;
        }
        return r;
    
    }//sol
    
    //time 동안 다 옮길 수 있는지 확인용 메서드
    public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t){
        int n = g.length; //도시 개수 n
        
        for (int i = 0; i < n; i++) {
            //미구현..
        }
        
    }//ispossible
    
}
