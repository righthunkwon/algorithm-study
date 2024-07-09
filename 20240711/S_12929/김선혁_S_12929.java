class Solution {
    static int answer;
    public int solution(int n) {
        answer = 0;
        // 1 -> 1
        // 2 -> 합치는 경우 + 나열
        // 3 -> 합쳐진거 + 배치할곳 4곳 2!/ 3!/3 4!/4 이런식으로 합쳐진거는 늘어나고 
        // dp 같긴한데 너무 어려워서 일단 dfs 도전
        
        // 0에서 시작해서 왼쪽하나 늘어날 때랑 오른쪽하나 늘어날 떄 각자 dfs해서 카운트
        // 중간에 오른쪽이 많아지면 끝
        solve(n,0,0);
        
        return answer;
    }
    // a = (  b = )
    public static void solve(int n , int a, int b) {
        if(a == n && b == n){
            answer ++;
            return;
        }
        // 백트래킹
        if(a< b || a> n || b > n){
            return;
        }
        // ( 증가 , ) 증가
        solve(n , a+1 , b);
        solve(n, a, b+1);
        
    }
    
}
