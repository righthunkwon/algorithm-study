class Solution {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            usage = usage * (100+change[i]) / 100; //지난달 사용한물 x 백분율 증감량 = 해당 달 사용한 물
            total_usage += usage;
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }
}
