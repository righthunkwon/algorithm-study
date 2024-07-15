class Solution {
    static int[] dis = {10, 20, 30, 40}; // 할인율
    static int maxUsers;
    static int maxPrice;
    static int[] emoDis;
    static int[][] users;
    static int[] emoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        // 모든 사용자의 할인율을 재귀로하고
        // 그 결과에 따라 max user일 때 값 저장
        emoDis = new int[emoticons.length]; // 각 유저의 할인율 index를 적을거임
        
        maxUsers = 0;
        maxPrice = 0;
        this.emoticons = emoticons;
        this.users = users;
        dfs(0);
        answer[0] = maxUsers;
        answer[1] = maxPrice;
        return answer;
        
    }
    public static void dfs(int index){
        if(index == emoDis.length) {
            // 이제 계산
            int[] res = solve();
            if(res[0] > maxUsers){
                // 크면 교체 , 같으면 max
                maxUsers = res[0];
                maxPrice = res[1];
            }
            else if(res[0] == maxUsers){
                maxPrice = Math.max(res[1], maxPrice);
            }
            return;
        }
        emoDis[index] = dis[0];
        dfs(index+1);
        emoDis[index] = dis[1];
        dfs(index+1);
        emoDis[index] = dis[2];
        dfs(index+1);
        emoDis[index] = dis[3];
        dfs(index+1);
        return;
    }
    // emoDis에 있는 값대로 
    // 할인율을 적용했을 떄 
    // 한명씩 for문을 통해 user의 값이 넘으면 
    // +1씩해서 계산해보자
    public static int[] solve() {
        int user = 0;
        int price = 0;
        for(int i = 0;i<users.length;i++){
            // 할인율 비교
            int sum = 0;
            for(int j = 0;j<emoticons.length;j++){
                if(emoDis[j] >= users[i][0]){
                    sum += emoticons[j]/100 *(100 -emoDis[j]) ;
                }
            }
            // 이과정 거쳤을 때 sum이 유저 제한보다 넘으면 
            // user ++ , 아니면 price에 sum 더함
            if(sum >= users[i][1]){
                user ++;
            }
            else{
                price += sum;
            }
        } // i
        int[] tmp = new int[2];
        tmp[0] = user;
        tmp[1] = price;
        return tmp;
    }
    
}
