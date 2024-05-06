class Solution {
    public int solution(int n) {
        
        // 미리 다 설정해놓자
        int[] arr = new int[100001];
        arr[0] = 0 ;
        arr[1] = 1;
        // 100000까지 다 설정완료
        for(int i = 2;i<=100000;i++){
            arr[i] = arr[i-1]+ arr[i-2];
            arr[i]%= 1234567;
        }
        
        return arr[n];
    }
}
