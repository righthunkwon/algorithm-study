class Solution {
    public int solution(String name) {
        int answer = 0;
        // AAA를 기준으로 각 알파벳이 얼마나 걸리는지 확인
        // 왼쪽방향으로 진행과 오른쪽 방향진행 2가지가 있고,
        // 하나의 알파벳을 A를 기준으로 앞과 뒤로 더 빠른것 진행
        int[] num = new int[name.length()];
        int max = 0;
        for(int i = 0;i<name.length();i++){
            char word = name.charAt(i);
            // A에서 그대로 가는게 빠를지와 Z에서 접근하는게 빠를지 최소값으로 갱신
            // 그 후에 num배열에 size를 넣어놓음
            int size = word - 'A';
            size = Math.min(size , 26-size);
            num[i] = size;
            answer += num[i];
            max = Math.max(num[i], max);
        }
        // 만약 모두 0이면 그대로 리턴
        if(max ==0){
            return 0;
        }
        
        // 1. 오른쪽으로만 이동 , 2. 오른쪽으로 갔다가 왼쪽으로 이동(그냥 왼쪽가는 경우랑 같음)        
        // 커서 이동을 위한 최소 이동 계산
        int n = name.length();
        int minMove = n - 1; // 오른쪽으로만 이동할 경우
        for (int i = 0; i < n; i++) {
            // 오른쪽으로 이동했다가 왼쪽으로 되돌아오는 경우
            int nextIndex = i + 1;
            while (nextIndex < n && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            // 오른쪽으로 이동 후 왼쪽으로 돌아오는 이동 횟수 계산
            minMove = Math.min(minMove, i + n - nextIndex + Math.min(i, n - nextIndex));
        }
        
        answer += minMove;
        return answer;
    }
}
