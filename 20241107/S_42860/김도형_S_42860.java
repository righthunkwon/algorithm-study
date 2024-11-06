class Solution {
    public int solution(String name) {
        int answer = 0;

        int length = name.length();
        int move = length - 1; // 기본 이동 횟수: 오른쪽으로 쭉 가는 경우

        for(int i=0;i<name.length();i++){
            //필요한 상하 조작 계산
            answer+=changeAlpaCnt(name.charAt(i));
            
            //필요한 좌우 조작 계산
            int nextIdx = i + 1;
            while (nextIdx < length && name.charAt(nextIdx) == 'A') {
                nextIdx++; // 연속된 'A' 구간 탐색
            }
            // 왼쪽으로 갔다가 돌아오는 경우와 오른쪽으로 갔다가 돌아오는 경우 중 최소 이동 비교
            move = Math.min(move, i + i + length - nextIdx);
            move = Math.min(move, (length - nextIdx) * 2 + i);
        }
        
        return answer+move;
    }
    
    //A를 특정 알파벳으로 변환하기까지 필요한 이동 계산
    static int changeAlpaCnt (char c){ 
        if(c-0>=65 && c-0<=77)return c-65; //A~M
        else return 91-c; //N ~ Z
    }
    
}
