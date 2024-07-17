class Solution {
    static int ans;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        // 우선 2진수 변환하고 
        // 해당 노드가 포화노드 될떄까지
        // 수를 탐색하면서 부족하면 0 추가하는 방식으로 포화로 만든다음
        // 이게 dfs로 가능한지 확인 
        for(int i = 0 ;i< numbers.length;i++){
            String line = Long.toBinaryString(numbers[i]);
            // 2진수 변환한다음 길이가 포화될때까지 확인
            int len = line.length();
    		int depth = 1;
    		int nodeCnt = 0;
    		// 노트 개수가 len을 넘을때까지
            // 깊이를 올리면서 count하고
            // 7같은 경우 depth = 2 , nodeCnt = 3 이렇게 나옴
    		while((nodeCnt = (int)Math.pow(2, depth) -1) < len) {
    			depth++;
    		}
            // 42는 0101010 -> depth = 3 nodCnt = 7
            
            boolean[] flag = new boolean[nodeCnt]; // 전체 나올수 있는 값 개수만큼 flag만들어서
            // 해당되는 위치에 1을 넣음
    		int index = nodeCnt - len;
    		for(int j = 0 ; j < len ; j++) {
                if(line.charAt(j) == '1'){
                    flag[index] = true;
                }
                index ++;
            }
            // 이제 1넣은 나무가
            // 가능한지 확인
            // dfs로 root노드를 먼저 찾고
            // 해당 root가 무조건 true인 상태여야함
            // false가 나오는데 자식노드가 true면 불가능
            ans = 1;
            // 이 과정에서 0나오면 불가능
            solve(flag, 0, nodeCnt-1);
            answer[i] = ans;
            
        }
        return answer;
    }
    
    public static void solve(boolean[] flag , int st, int en){
        // 우선 st랑 en같으면 끝
        if(st == en){
            return;
        }
        int root = (st + en)/2;
        // root가 false이면서 바로 밑에가 true인 경우 찾기
        // System.out.println(st+" "+en+" "+root);
        if(!flag[root] && ( flag[(st+root-1)/2] || flag[(root+1+en)/2] ) ){
            ans = 0;
            return;
        }
        
        // 전체를 기준으로 앞과 뒤로 계속 확인
        solve(flag, st, root-1);
        solve(flag ,root+1, en);
        return;      
    }
    
}
