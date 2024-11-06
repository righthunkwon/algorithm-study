class Solution {
    public int[] solution(int e, int[] starts) {
        // 약수 갯수 미리 구해놓기
        int[] record = new int[e+1];
        for(int i = 1; i <= e; i++){
            for(int j = i; j <= e; j+=i){
                record[j]++;
            }
        }
        // e부터 역순으로 최대 값 가지는 인덱스 저장, i는 starts 값 기준으로 검색
        int[] max = new int[e+1];
        int idx = 0, value = 0;
        for(int i = e; i >= 1; i--){
            if(record[i] >= value){// 같음도 처리해줘야 idx 가장 작은값으로 최신화
                value = record[i];
                idx = i;
            }
            max[i] = idx;
        }
        // 최종 순회
        int[] result = new int[starts.length];
        for(int i = 0; i < starts.length; i++){
            result[i] = max[starts[i]];
        }
        return result;
    }
}
// record [0,1,2,2,3,2,4,2,4]
// max [0,6,6,6,6,6,6,8,8]
// result [6, 6, 8]