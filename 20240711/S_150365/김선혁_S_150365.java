class Solution {
    static int n;
    static int m; // 제한좌표
    static int r;
    static int c; // 목표지점
    static int k;
    static String peekAns;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        peekAns = "";
        this.n =n;
        this.m =m;
        this.r = r;
        this.c =c;
        this.k =k;
        // 같은곳 방문가능한 대신 k보다 크면 일단 백트래킹쓰고
        // 사전순 비교해서 가장 빠른거로
        
        // 왼 l 오 r 위 u 밑 d -> 밑0 왼1 오2 위3 이런식으로 추가해서 비교
        
        // 일단 거리 애초에 안되면 불가능 + 왔다갔다하려면 무조건 짝수여야함
        if(k<possible(r,c,x,y) || (k-possible(r,c,x,y))% 2 == 1){
            return "impossible";
        }
        
        solve(x,y,0,peekAns);
        
        
        return peekAns;
    }
    public static void solve(int x, int y, int cnt, String num){
        // dfs로 풀어보자
        
        // 하나만 무조건 찾으면 된다
        if(peekAns != ""){
            return;
        }
        // 일단 조심해야할게 1. 현재 위치에서 목표지점까지 거리가 가능한지 안되면 return 
        // 2. 해당깊이가 됬을 때 최소로 갱신
        if(cnt + possible(r,c,x,y) > k){
            return;
        }
        // 깊이랑 맞으면 peekAns 넣고 끝냄
        if(cnt == k){
            for(int i = 0 ;i<num.length();i++){
                String tmp = num.substring(i,i+1);
                peekAns += change2(tmp);
            }
            return;
        }
        
        for(int i = 0;i<dx.length;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >0 && ny > 0 && nx<=n && ny<=m){
               String newNum = num + change(i);
                solve(nx,ny,cnt+1, newNum);
            }
        }
    }
    // 떨어진 거리 반환
    public static int possible(int r, int c, int a, int b){
        return (int)Math.abs(a-r) + (int)Math.abs(b-c); 
    }
        
    public static String change(int idx){
        if(idx ==0){
            return "1";
        }
        if(idx == 1){
            return "2";
        }  
        if(idx ==2){
            return "3";
        }
        return "4";
    }
    
    public static String change2(String a){
        if(a.equals("1")){
            return "d";
        }
        if(a.equals("2")){
            return "l";
        }
        if(a.equals("3")){
            return "r";
        }
        return "u";
    }
    
    static int dx[] = {1,0,0,-1};
    static int dy[] = {0,-1,1,0}; // 밑 좌 우 위 순서
}
