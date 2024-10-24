class Solution {
    public int solution(String arr[]) {
        //dp로 뒤에서부터 최대값, 최소값 구하기
        int max = 0;
        int min = 0;
        int sum = 0;
        for (int i = arr.length-1; i>0 ; i -= 2) {//뒤에서부터 연산자,숫자 세트로 계산하기
            int num = Integer.parseInt(arr[i]); //숫자 
            String sign = arr[i-1];	// 연산자
            if (sign.equals("+")) sum += num;	//플러스면 sum에 더하기
            else {	// 마이너스면   
                // tmp1: 현재 숫자, 이전 합, 최소값을 모두 더하고 음수로 바꾼 경우
                int tmp1 = -(num + sum + min);

                // tmp2: 현재 숫자만 음수로 바꾸고 이전 합과 최대값을 더한 경우
                int tmp2 = -num + sum + max;

                // tmp3: 현재 숫자, 이전 합, 최대값을 더하고 음수로 바꾼 경우
                int tmp3 = -(num + sum + max);

                // tmp4: 현재 숫자와 이전 합만 음수로 만들고 최소값을 더한 경우
                int tmp4 = -(num + sum) + min;
                
                max = Math.max(tmp1, tmp2);
                min = Math.min(tmp3, tmp4);
                sum = 0;//sum 0으로 초기화
            }
        }
        return max + Integer.parseInt(arr[0]) + sum; //맨 앞 연산이 +면 max값에 sum이 반영이 안되니까 예외처리 해줘야함
    }
}
