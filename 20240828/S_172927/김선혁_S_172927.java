import java.util.*;

class Solution {
    static int[] picks;
    static String[] minerals;
    static int min;
    static int[] arr;
    public int solution(int[] picks, String[] minerals) {
        min = Integer.MAX_VALUE;
        // 백트래킹
        // 피로도 계산하는 식 만들어놓기
        // 현재 nowPicks가 다이아, 철, 돌 순서대로 0 1 2라 해놓고
        // nowMinerals를 뺀 값이 0보다 크다면 그 수만큼 5에 제곱때려서 계산
        this.picks = picks;
        this.minerals = minerals;
        // 먼저 dfs를 통해서 picks의 배열의 곡괭이의 순서를 정하자
        // 순서를 모두 정해서 arr배열에 순서대로 숫자를 넣으면 
        // arr에서 5개씩 피로도 계산해서 최소값 return
        arr = new int[picks[0] + picks[1] + picks[2]];
        dfs(0);
        
        return min;
    }
    public static void dfs(int index){
        if(index == arr.length){
            // 이제 피로도 계산
            solve();
            return;
        }
        // 0번부터 곡괭이가 있을때마다
        // 해당 번호에 해당하는 곡괭이 번호를 arr에 넣음
        for(int i = 0;i<3;i++){
            if(picks[i] >0){
                picks[i] --;
                arr[index] = i;
                dfs(index +1);
                picks[i] ++;
            }
        }
    }
    
    public static void solve(){
        int sum = 0;
        for(int i = 0 ;i<arr.length;i++){
            for(int j = i*5;j<=i*5 +4;j++){
                // 먼저 j가 mineral 벗어나는지 체크
                // 벗어나면 끝내고
                if(j == minerals.length){
                    min = Math.min(min, sum);
                    return;
                }
                // 백트래킹
                if(sum > min){
                    return;
                }
                int nowP = arr[i];
                int nowM = nowNum(minerals[j]);
                sum += calculate(nowP, nowM);
            }
        }
        // for문 끝날때까지 살아있으면
        // 곡괭이 부족 -> 현재까지 피로도 계산
        min = Math.min(min, sum);
        return;
    }
    
    // 현재의 곡괭이로 광물 캘경우 오르는 피로도 return하는 메서드
    public static int calculate(int nowPicks, int nowMinerals){
        int dis = nowPicks - nowMinerals;
        if(dis > 0){
            return (int)Math.pow(5, dis);
        }     
        return 1;
    }
  // 현재 광물에 따라 번호 return
    public static int nowNum(String word){
        if(word.equals("diamond")){
            return 0;
        }
        else if(word.equals("iron")){
            return 1;
        }
        return 2;        
    }
    
    
    
}
