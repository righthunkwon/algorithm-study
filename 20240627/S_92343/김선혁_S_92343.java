import java.util.*;

class Solution {
    static ArrayList<Integer>[] ar;
    static int max;
    static int[] info;
    public int solution(int[] info, int[][] edges) {
        // 0은 양 , 1 은 늑대
        // 각배열은 그대로 list 추가함
        this.info = info;
        ar = new ArrayList[info.length];
        // 배열 모두 초기화
        for(int i = 0;i<info.length;i++){
            ar[i] = new ArrayList<>();
        }
        // edges에서 그대로 리스트에 추가
        for(int i = 0 ;i<edges.length;i++){
            ar[edges[i][0]].add(edges[i][1]);
        }
        
        // 0번부터 그 점에서 이어진 배열값을 모두 새로운 리스트에 추가하고
        // 그 각 값마다 양의 개수 count해서 max 값 갱신
        // 될때까지 dfs
        max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        solve(0,0,0,list);
        
        return max;
    }
    public static void solve(int sheep, int wolf, int idx , ArrayList<Integer> list){
        // 양이면 양추가 , 늑대면 늑대 추가
        if(info[idx] == 0){
            sheep ++;
        }
        else{
            wolf ++;
        }
        // 늑대가 많아지면 return
        if(wolf >= sheep){
            return;
        }
        max = Math.max(max, sheep);
        
        // 이제 모든 배열값에서 뻗어 나갈 수 있는 모든점 뻗어나감(현재위치에서 뻗어나간 것 포함)
        // 일단 배열에 현재 위치에서 뻗어나간 점들 추가하고 모두 dfs
        
        // 현재위치는 제거해야함
        ArrayList<Integer> tmp = new ArrayList<>(list); // list 복제
        tmp.remove(tmp.indexOf(idx));
        // idx 점에서 뻗어나간 모든 번호 tmp에 추가
        for (int i = 0; i < ar[idx].size(); i++) {
            tmp.add(ar[idx].get(i));
        }
      
        // 모든 점 dfs
        for(int i = 0;i<tmp.size();i++){
            solve(sheep, wolf, tmp.get(i), tmp);
        }
        return;
    }
    
    
}
