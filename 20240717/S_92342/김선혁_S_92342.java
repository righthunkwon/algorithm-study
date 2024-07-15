
class Solution {

    static int[] info;
    static int[] info2;
    static int[] ans;
    static int n;
    static int min;
    public int[] solution(int n, int[] info) {
        // dfs해보자
        int[] answer = {-1};
        this.n = n;
        this.info = info;
        info2 = new int[info.length];
        ans = new int[info.length];
        min = -2;
        solve(0);
        
        if(min == -1){
            return answer;
        }
        return ans;
    }
    public static void solve(int index){
        // 화살 하나씩 늘려가면서 쏠거임
        if(index == n){
            // 화살 다 쐈으면 점수 계산
            int score = cal();
            // 차이가 가장 큰 점수 갱신(같을 떄도 포함 - 나중에 나올수록 낮은 점수 더 많이 맞힘)
            if(min <= score){
                min = score;
                // 복붙
                for(int i = 0 ;i<info.length;i++){
                    ans[i] = info2[i];
                }
            }
            return;
        }
        
        // 화살을 쏘는데 우선 조건이 info보다 적은상태에서의 i를 하나 늘리고 줄이고 다음 점수 늘리고 이런식
        for(int i = 0 ;i<info.length && info2[i] <= info[i];i++){
            // 현재 info보다 개수 낮을 때만 늘림 - 같을떄도 포함 (잘못품) , if문 따로 빼는거보다 for문에 조건 2개넣는게 빠름
                info2[i]++;
                // 한발 더 쏘고 dfs 돌고 취소하고
                solve(index+1);
                info2[i] --;    
        }
        
    }
    
    public static int cal(){
        int a = 0;
        int b = 0; // 얘가 높아야함 
        
        for(int i = 0 ;i<info.length;i++){
            // 두명의 점수 비교해서 info2가 높으면 b올리고 반대면 a올려서
            // 두명의 점수 차이 return 
            // 만약 a가 높게되면 -1
            
            // 1. 둘다 0이면 다음으로
            // 2. info2가 높으면 b가(반대 포함)
            if(info[i] == 0 && info2[i] == 0){
                continue;
            }
            if(info2[i] > info[i]){
                b += (10-i);
            }
            else{
                a += (10 -i);
            }
        }
        int tmp = b - a;
        // 두 점수차 구함
        if(tmp <= 0){
            return -1;
        }
        return tmp;
        
    }
    
}
