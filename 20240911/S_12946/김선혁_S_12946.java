class Solution {
    static ArrayList<int[]> ar = new ArrayList<>();
    public ArrayList<int[]> solution(int n) {
        // dfs를 통해 현재 위치에서 맨밑에 빼고 다 중간으로 옮긴다음
        // 1에 있는거를 끝으로 옮기고
        // 2에 있는거를 맨밑에 빼고 다 1로 옮기고 하나 3으로 옮기는거 반복
        dfs(1,2,3,n);
        return ar;
    }

    public void dfs(int start, int mid, int end, int cnt) {
        if(cnt == 0){
            return;
        }
        // 맨밑에 빼고 모두 mid로 옮긴다음
        // 리스트에 방향 추가 후 다시 반대로
        dfs(start, end, mid, cnt-1);    
        ar.add(new int[]{start,end});     
        // mid에서 end 방향으로..
        dfs(mid,start,end,cnt-1);       
    }
}
