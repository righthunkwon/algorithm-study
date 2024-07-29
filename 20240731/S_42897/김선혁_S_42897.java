import java.util.*;

class Solution {
    public int solution(int[] money) {
        // 한집을 골랐을 떄 그 다음집은 무조건 못털게 
        // 해당집을 털었을 떄의 값 저장 + 해당집 안털었을 떄 값 저장
        // dp로 갱신해가자
        
        // 점화식은 현재집-2값 + 현재값과 , 현재-1까지의 값중 최대값 갱신
        int [] dp1 = new int[money.length]; // 첫집턴경우(마지막집 못털음)
        int [] dp2 = new int[money.length]; // 첫집 안턴경우
       
        dp1[0] = money[0];
        dp1[1] = money[0];

        dp2[0] = 0;
        dp2[1] = money[1];
        // 두개 모두 초기화 완료 이제 시작
        // 첫집의 경우 마지막집 포함x라 lenght-1까지만 돌음
        for(int i = 2;i<money.length-1;i++){
            dp1[i] = Math.max(dp1[i-2]+ money[i] , dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+ money[i] , dp2[i-1]);
            // System.out.println(i+" "+dp1[i] +" "+dp2[i]);
        }
        dp2[money.length-1] = Math.max(dp2[money.length-3]+money[money.length-1], dp2[money.length-2]);
        // 4 1 2 10 1
        int max = Math.max(dp1[money.length-2], dp2[money.length-1]);
        return max;
    }
}
