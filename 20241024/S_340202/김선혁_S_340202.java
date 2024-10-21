class Solution {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            usage = usage * (100 + change[i]) / 100; // 기존에는 -를 반영못함 -> -10일 경우 0.9를 곱하도록 수정 + total에서 계산하는 것이 아닌 전달 사용량에서 계산해야함
            total_usage += usage;
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }
}
